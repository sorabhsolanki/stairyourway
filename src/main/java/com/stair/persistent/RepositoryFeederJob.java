package com.stair.persistent;


import com.stair.dto.WorkoutDto;
import com.stair.jobqueue.JobQueue;
import com.stair.persistent.entity.Workout;
import com.stair.persistent.repository.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryFeederJob implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(RepositoryFeederJob.class);
    private final JobQueue queue = JobQueue.getInstance();
    private WorkoutRepository workoutRepository;
    private final TotalPointHelper totalPointHelper = new TotalPointHelper();

    @Override
    public void run() {
        while (true){
            try {

                //check if new data is in queue
                WorkoutDto workoutDto = queue.pop();
                LOG.info("Poping new job from queue "+workoutDto.toString());


                Workout workout = new Workout(workoutDto.getEmail(), workoutDto.getFloorUpDirection(),
                        workoutDto.getFloorDownDirection());

                //compute total points
                double points = totalPointHelper.getTotalPoints(workoutDto.getFloorUpDirection(),
                        workoutDto.getFloorDownDirection());
                workout.setTotalPoints(points);

                //TODO: check if user has already any workout submitted already, then add the computed points
                // to the already submitted points.



                // TODO: save or update the enity

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setWorkoutRepository(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    private static class TotalPointHelper{

        private final double upPoints = 0.6;
        private final double downPoints = 0.2;

        public double getTotalPoints(String totalUpFloors, String totalDownFloors){
            return 0;
        }
    }
}
