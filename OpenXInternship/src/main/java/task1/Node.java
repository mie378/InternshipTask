package task1;

public class Node {
    private Node leftNode=null;
    private Node rightNode=null;
    private final int value;

    public Node(int value){
        this.value=value;
    }

    public void setLeftNode(Node leftNode){
        this.leftNode=leftNode;
    }

    public void setRightNode(Node rightNode){
        this.rightNode=rightNode;
    }

    public Node getLeftNode(){
        return this.leftNode;
    }

    public Node getRightNode(){
        return this.rightNode;
    }

    public int getValue(){
        return this.value;
    }



}
