package lockingFwk;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PerformReadWriteLock extends CalculateTasks {

    /**
     Read Lock – if no thread acquired the write lock or requested for it then multiple threads can acquire the read lock
     Write Lock – if no threads are reading or writing then only one thread can acquire the write lock
     **/

    /**
     * For both the write methods, we need to surround the critical section with the write lock, only one thread can get access to it:
     */
    Map<String,String> syncMap = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    Lock  writeLock = lock.writeLock();

    public String  put (String key, String value){
        try {
            writeLock.lock();
            syncMap.put(key,value);

        }finally {
            writeLock.unlock();
        }

        return value;
    }


    public String remove (String key){
        try{
            writeLock.lock();
            return syncMap.remove(key);
        }finally {
            writeLock.lock();
        }
    }


    /**
     * For both read methods, we need to surround the critical section with the read lock.
     * Multiple threads can get access to this section if no write operation is in progress.
     */

    Lock readLock = lock.readLock();

    public String getValue(String key){
        try{
            readLock.lock();
            return syncMap.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public boolean containsKey(String key){
        try {
            readLock.lock();
            return syncMap.containsKey(key);
        }finally {
            readLock.unlock();
        }
    }
}
