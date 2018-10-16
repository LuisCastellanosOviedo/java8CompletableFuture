package lockingFwk;

import java.util.HashMap;
import java.util.concurrent.locks.StampedLock;

public class PerformReadWriteStampedLock extends CalculateTasks {

    /**
     * StampedLock is introduced in Java 8. It also supports both read and write locks.
     * However, lock acquisition methods returns a stamp that is used to release a lock or to check if the lock is still valid:
     */
    private HashMap<String,String> syncMap = new HashMap<>();
    private StampedLock lock = new StampedLock();


    public String put(String key , String value ){
        long stamp = lock.writeLock();
        try{
            syncMap.put(key,value);
        }finally {
            lock.unlockWrite(stamp);
        }

        return value;
    }


    public String get(String key){
        long stamp = lock.readLock();
        try{
            return syncMap.get(key);
        }finally {
            lock.unlockRead(stamp);
        }
    }

    /**
     * Another feature provided by StampedLock is optimistic locking.
     * Most of the time read operations doesn’t need to wait for write operation completion and as a result of this,
     * the full fledged read lock is not required. Instead, we can upgrade to read lock:
     */

    public String readWithOptimisticLock(String key){
        long stamp = lock.tryOptimisticRead();
        String value = syncMap.get(key);

        if(!lock.validate(stamp)){
            stamp = lock.readLock();
            try{
                return syncMap.get(key);
            }finally {
                lock.unlock(stamp);
            }

        }
        return value;
    }
}
