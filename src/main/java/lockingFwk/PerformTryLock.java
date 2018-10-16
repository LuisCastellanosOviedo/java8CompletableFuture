package lockingFwk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class PerformTryLock extends  CalculateTasks{

    private ReentrantLock lock = new ReentrantLock();
    private int count =0;

    // In this case, the thread calling tryLock(), will wait for one second and will give up waiting if the lock is not available.
    public String execute() throws InterruptedException {
        String res = null;

        boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);

        if(isLockAcquired){
            try {
                res = calculateValues();
                count++;
            }finally {
                lock.unlock();
            }
        }

        return res;
    }

    public int getCount() {
        return count;
    }
}
