package lockingFwk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerformReadWriteStampedLockTest {

    private PerformReadWriteStampedLock performReadWriteStampedLock;


    @Before
    public void setUp() throws Exception {
        performReadWriteStampedLock = new PerformReadWriteStampedLock();
    }


    @Test
    public void testWrite() {
        Assert.assertNotNull(performReadWriteStampedLock);
        Assert.assertEquals(performReadWriteStampedLock.put("1","1"),"1");
        Assert.assertEquals(performReadWriteStampedLock.put("2","2"),"2");
    }

    @Test
    public void testRead() {
        Assert.assertNotNull(performReadWriteStampedLock);
        Assert.assertEquals(performReadWriteStampedLock.put("1","1"),"1");
        Assert.assertEquals(performReadWriteStampedLock.put("2","2"),"2");
        Assert.assertEquals(performReadWriteStampedLock.get("1"),"1");
        Assert.assertEquals(performReadWriteStampedLock.get("2"),"2");
    }
}
