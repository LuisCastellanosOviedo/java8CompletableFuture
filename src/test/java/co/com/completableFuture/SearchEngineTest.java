package co.com.completableFuture;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchEngineTest {


    SearchEngine searchEngine;

    @Before
    public void setUp() throws Exception {
        searchEngine  = new SearchEngine();
    }

    @Test
    public void existModuleNotNull() {
        assertNotNull(searchEngine);
    }

    @Test
    public void noResultsWhenParamIsNull() {
        assertEquals(0,searchEngine.search(null).getResults().size());
    }

    @Test
    public void emptyResultWithEmptyParam() {
        assertEquals(0,searchEngine.search("").getResults().size());
    }
}
