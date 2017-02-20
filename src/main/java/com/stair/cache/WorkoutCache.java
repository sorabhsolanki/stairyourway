package com.stair.cache;

import com.stair.dto.cache.CacheDto;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/*
Cache class which mainly holds two section.
1. DailyTop10
2. MonthlyTop15

Internal DS:
Cache will be using concurrentHahMap with MaxHeap data structure
to store the elements.

Cache will support only two function
1. insert
2. extractTop10

Both the methods will be guarded the lock, so that when TopLinksJob will be inserting the workout data
then at the same time handler can not fetch top 10 daily workout.
*/
@Component
public class WorkoutCache {

    private final int capacity = 10;
    private int currentSize;
    private final ConcurrentMap<String, CacheDto> map = new ConcurrentHashMap<>();
    private final Heap heap = new Heap();
    private final ReentrantLock lock = new ReentrantLock();

    public void insert(CacheDto cacheDto){
        lock.lock();
        try{
            //check whether the element present in the map
            if(map.containsKey(cacheDto.getEmail())){
                int index = map.get(cacheDto.getEmail()).getIndex();
                // replace the existing element in the heap
                heap.increaseKey(index, cacheDto);
                return;
            }
            // else this is a new data altogether
            heap.insert(cacheDto);
        }finally {
            lock.unlock();
        }
    }

    public CacheDto extractMax(){
        lock.lock();
        try{
            return heap.extractMax();
        }finally {
            lock.unlock();
        }

    }

    private static class Heap{
        public void insert(CacheDto cacheDto){}
        public void increaseKey(int index, CacheDto cacheDto){}
        public CacheDto extractMax(){
            return null;
        }
    }

}
