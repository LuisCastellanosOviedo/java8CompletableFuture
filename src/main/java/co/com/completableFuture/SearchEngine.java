package co.com.completableFuture;

import java.util.List;

public class SearchEngine {


    private ConcurrentSearchComponent concurrentSearchComponent  = new ConcurrentSearchComponent();


    public Result search(String paramToSearch) {
        Result result = new Result();

        if(isValidData(paramToSearch)){
            return result;
        }

        List<String> resultFromNodes= concurrentSearchComponent.executeSearch(paramToSearch);

        return result;
    }

    private boolean isValidData(String s) {
        return s==null || s.equals("");
    }
}
