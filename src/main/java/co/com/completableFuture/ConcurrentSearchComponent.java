package co.com.completableFuture;

import co.com.completableFuture.nodes.Inode;
import co.com.completableFuture.nodes.Node1;
import co.com.completableFuture.nodes.Node2;
import co.com.completableFuture.nodes.Node3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class ConcurrentSearchComponent {

    private List<Inode> searchNodes= Arrays.asList(new Node1(),new Node2(),new Node3());

    public List<String> executeSearch(String param){

      List<CompletableFuture<String>> completableFutures =  searchNodes.stream().map(
              node -> CompletableFuture.supplyAsync(()-> node.search(param)))
              .collect(toList());


      return completableFutures.stream().map(CompletableFuture::join).collect(toList());

    }
}
