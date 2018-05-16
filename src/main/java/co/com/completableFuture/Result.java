package co.com.completableFuture;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<String> results;


    public Result() {
        this.results= new ArrayList<>();
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
