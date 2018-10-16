package lockingFwk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerformTryLockTest {


    private PerformTryLock performTryLock;

    @Before
    public void setUp() throws Exception {
        performTryLock = new PerformTryLock();
    }


    @Test
    public void testTryLock() throws InterruptedException {
        Assert.assertNotNull(performTryLock);
        Assert.assertEquals(performTryLock.execute(),"executing tasks");
        Assert.assertEquals(performTryLock.getCount(),1);
    }
}
