package lockingFwk;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo extends CalculateTasks{

    private ReentrantLock lock = new ReentrantLock();
    private int count =0;

    public String executeTask(){
        String res = null;
        lock.lock();
        try {
         res = calculateValues();
            count++;
        }finally {
            lock.unlock();
        }
        return res;
    }


    public int getCount() {
        return count;
    }
}
