package lockingFwk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerformReadWriteLockTest {


    private PerformReadWriteLock performReadWriteLock;

    @Before
    public void setUp() throws Exception {
        performReadWriteLock = new PerformReadWriteLock();
    }


    @Test
    public void testWriteLockPut() {
        Assert.assertNotNull(performReadWriteLock);
        Assert.assertEquals(performReadWriteLock.put("1","1"),"1");
        Assert.assertEquals(performReadWriteLock.put("2","2"),"2");
        Assert.assertEquals(performReadWriteLock.put("3","3"),"3");
    }

    @Test
    public void testWriteLockRemove() {
        Assert.assertNotNull(performReadWriteLock);
        Assert.assertEquals(performReadWriteLock.put("1","1"),"1");
        Assert.assertEquals(performReadWriteLock.put("2","2"),"2");
        Assert.assertEquals(performReadWriteLock.put("3","3"),"3");
        Assert.assertEquals(performReadWriteLock.remove("1"),"1");
        Assert.assertEquals(performReadWriteLock.remove("2"),"2");
        Assert.assertEquals(performReadWriteLock.remove("3"),"3");
    }

    @Test
    public void testReadLockGetValue() {
        Assert.assertNotNull(performReadWriteLock);
        Assert.assertEquals(performReadWriteLock.put("1","1"),"1");
        Assert.assertEquals(performReadWriteLock.put("2","2"),"2");
        Assert.assertEquals(performReadWriteLock.put("3","3"),"3");

        Assert.assertEquals(performReadWriteLock.getValue("1"),"1");
        Assert.assertEquals(performReadWriteLock.getValue("2"),"2");
        Assert.assertEquals(performReadWriteLock.getValue("3"),"3");
    }

    @Test
    public void testReadLockContains() {
        Assert.assertNotNull(performReadWriteLock);
        Assert.assertEquals(performReadWriteLock.put("1","1"),"1");
        Assert.assertEquals(performReadWriteLock.put("2","2"),"2");

        Assert.assertEquals(performReadWriteLock.containsKey("1"),true);
        Assert.assertEquals(performReadWriteLock.containsKey("2"), true);
        Assert.assertEquals(performReadWriteLock.containsKey("3"),false);
    }
}
