package co.com.completableFuture.nodes;

public class Node3 implements Inode {

    public String search(String param){

        try {
            Thread.sleep(20000l);
        } catch (InterruptedException e) {
            System.out.println("ERROR IN NODE 1");
        }

        return "result node 3";
    }
}
