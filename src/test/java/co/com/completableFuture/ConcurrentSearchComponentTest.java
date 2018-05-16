package co.com.completableFuture;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ConcurrentSearchComponentTest {


    ConcurrentSearchComponent concurrentSearchComponent;


    @Before
    public void setUp() throws Exception {
        concurrentSearchComponent = new ConcurrentSearchComponent();
    }

    @Test
    public void componentNotNull() {
        assertNotNull(concurrentSearchComponent);
    }

    @Test
    public void getFirstValidResult() {
        List<String> result  = concurrentSearchComponent.executeSearch("s");
        assertNotNull(result);
    }
}
