package com.stair.persistent;


import com.stair.dto.WorkoutDto;
import com.stair.jobqueue.JobQueue;
import com.stair.persistent.entity.Workout;
import com.stair.persistent.repository.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
* This Class will pop elements from JobQueue and inserts them into DB.
* */
public class RepositoryFeederJob implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(RepositoryFeederJob.class);
    private final JobQueue queue = JobQueue.getInstance();
    private final TotalPointHelper totalPointHelper = new TotalPointHelper();

    private WorkoutRepository workoutRepository;

    public RepositoryFeederJob(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public void run() {
        boolean b = true;
        while (b) {
            try {

                //check if new data is in queue
                WorkoutDto workoutDto = queue.pop();
                LOG.info("Poping new job from queue " + workoutDto.toString());


                Workout workout = new Workout(workoutDto.getEmail(), workoutDto.getFloorUpDirection(),
                        workoutDto.getFloorDownDirection());

                //compute total points
                double points = totalPointHelper.getTotalPoints(workoutDto.getFloorUpDirection(),
                        workoutDto.getFloorDownDirection());

                //TODO: check if user has already any workout submitted already, then add the computed points
                // to the already submitted points.
                Workout workoutFromDb = workoutRepository.getWorkoutForUser(workoutDto.getEmail());
                if (workoutFromDb != null) {
                    workoutFromDb.setTotalPoints(points + workoutFromDb.getTotalPoints());
                    workoutFromDb.setFloorUpDirection(workout.getFloorUpDirection()
                            + workoutFromDb.getFloorUpDirection());
                    workoutFromDb.setFloorDownDirection(workout.getFloorDownDirection()
                            + workoutFromDb.getFloorDownDirection());
                    workoutRepository.save(workoutFromDb);
                } else {
                    workoutRepository.save(workout);
                }

                // TODO: save or update the enity

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TotalPointHelper {

        private final double upPoints = 0.6;
        private final double downPoints = 0.2;

        public double getTotalPoints(int totalUpFloors, int totalDownFloors) {
            return upPoints * totalUpFloors + downPoints * totalDownFloors;
        }
    }
}
