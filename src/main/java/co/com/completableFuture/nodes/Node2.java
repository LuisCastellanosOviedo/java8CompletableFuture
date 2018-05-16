package co.com.completableFuture.nodes;

public class Node2 implements Inode {

    public String search(String param){

        try {
            Thread.sleep(15000l);
        } catch (InterruptedException e) {
            System.out.println("ERROR IN NODE 1");
        }

        return "result node 2";
    }
}
