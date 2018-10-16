package lockingFwk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class lockingFwkTest {

    private ReentrantLockDemo reentrantLockDemo;

    @Before
    public void setUp() throws Exception {
        reentrantLockDemo = new ReentrantLockDemo();
    }

    @Test
    public void testReentrantLock() {

        Assert.assertNotNull(reentrantLockDemo);
        Assert.assertEquals(reentrantLockDemo.executeTask(),"executing tasks");
        Assert.assertEquals(reentrantLockDemo.getCount(),1);
    }
}
