package com.stair.cache;

import com.stair.dto.cache.CacheDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/*
Cache class which mainly holds two section.
1. DailyTop10
2. MonthlyTop15

Internal DS:
Cache will be using concurrentHahMap with MinHeap data structure
to store the elements.

Cache will support only two function
1. insert
2. extractTop10

Both the methods will be guarded the lock, so that when TopLinksJob will be inserting the workout data
then at the same time handler can not fetch top 10 daily workout.
*/
@Component
public class WorkoutCache {

    private static final Logger LOG = LoggerFactory.getLogger(WorkoutCache.class);

    private final int capacity = 10;
    private final ConcurrentMap<String, CacheDto> map = new ConcurrentHashMap<>();
    private final Heap heap = new Heap(capacity);
    private final ReentrantLock lock = new ReentrantLock();

    public void insert(CacheDto cacheDto){
        LOG.info("taking lock");
        lock.lock();
        try{
            LOG.info("After taking lock");
            //check whether the element present in the map
            if(map.containsKey(cacheDto.getEmail())){
                //update the points
                map.get(cacheDto.getEmail()).setTotalPoints(cacheDto.getTotalPoints());
                // now check whether this element exist inside the heap
                int index = map.get(cacheDto.getEmail()).getIndex();
                if(index != -1){
                   // replace the existing element in the heap
                   heap.increaseKey(index, cacheDto);
                }
            }else{
                // else this is a new data altogether
                heap.insert(cacheDto);
                map.put(cacheDto.getEmail(), cacheDto);
            }
        }finally {
            lock.unlock();
        }

    }

    public CacheDto extractMax(){
        lock.lock();
        try{
            return heap.extract();
        }finally {
            lock.unlock();
        }
    }

    public CacheDto[] extractTop10(){
        lock.lock();
        try{
            return heap.extractTop10();
        }finally {
            lock.unlock();
        }
    }


    // min heap of size 10
    private static class Heap{

        private int currentSize = 0;
        private final int size;
        private final CacheDto[] cacheDtos;

        public Heap(int capacity) {
            this.size = capacity;
            cacheDtos = new CacheDto[size];
        }

        public void insert(CacheDto cacheDto){
            LOG.info("Current Size of heap : " + currentSize);
            if(currentSize == 0){
                cacheDto.setIndex(currentSize);
                cacheDtos[currentSize ++] = cacheDto;
            }
            else if(currentSize < size){
                cacheDtos[currentSize] = cacheDto;
                //maintain the heap property
                int i = currentSize;
                while(i != 0 &&
                        cacheDtos[parent(i)].getTotalPoints() > cacheDtos[i].getTotalPoints()){
                    swap(parent(i), i);
                    i = parent(i);
                }
                cacheDto.setIndex(i);
                currentSize ++;
            }else if(cacheDto.getTotalPoints() > cacheDtos[0].getTotalPoints()){
                // put this element at top and call heapify()
                //first make the index of the first element -1 as we are taking it off from heap
                cacheDtos[0].setIndex(-1);
                // now put the current one on 0
                cacheDtos[0] = cacheDto;
                int index = heapify(0);
                cacheDto.setIndex(index);
            }
        }

        public int increaseKey(int index, CacheDto cacheDto){
            // replace the dto at this index
            cacheDtos[index] = cacheDto;

            //now call heapify upwards
            int parent = parent(index);
            while(cacheDtos[parent].getTotalPoints() < cacheDtos[index].getTotalPoints()){
                swap(parent, index);
                index = parent;
                parent = parent(index);
            }
            return index;
        }

        public CacheDto extract(){
            if(currentSize < 0)
                return null;
            if(currentSize == 0){
                return cacheDtos[0];
            }

            CacheDto cacheDto = cacheDtos[0];
            cacheDtos[0] = cacheDtos[--currentSize];
            heapify(0);

            return cacheDto;
        }

        public CacheDto[] extractTop10(){
            //Arrays.sort(cacheDtos);
            return cacheDtos;
        }

        private int heapify(int index){
            int l = left(index);
            int r = right(index);

            int smallest = index;

            if(l < currentSize && cacheDtos[l].getTotalPoints() < cacheDtos[index].getTotalPoints()){
                smallest = l;
            }
            if(r < currentSize && cacheDtos[r].getTotalPoints() < cacheDtos[smallest].getTotalPoints()){
                smallest = r;
            }
            if(smallest != index){
                swap(index, smallest);
                smallest = heapify(smallest);
            }

            return smallest;
        }

        private void swap(int first, int second){
            CacheDto temp = cacheDtos[first];
            cacheDtos[first] = cacheDtos[second];
            cacheDtos[second] = temp;

            cacheDtos[first].setIndex(first);
            cacheDtos[second].setIndex(second);
        }

        private int left(int index){
            return 2*index + 1;
        }

        private int right(int index){
            return 2*index + 2;
        }

        private int parent(int index){
            return (index - 1) / 2;
        }
    }

}
