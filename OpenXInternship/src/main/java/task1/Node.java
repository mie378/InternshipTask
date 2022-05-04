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
    /*
    Przemyslaw Kociuba
    Let f(root) be the number of leaves in a tree
    Therefore, f(root)=f(root.left)+f(root.right)  and f(leaf)=1
    Complexity: O(n)
     */
    public int numOfLeaves(Node root){
        if(root==null){
            return 0;
        }
        if(root.getLeftNode()==null&&root.getRightNode()==null){
            return 1;
        }
        int numOfLeaves=0;
        numOfLeaves+=numOfLeaves(root.getLeftNode())+numOfLeaves(root.getRightNode());
        return numOfLeaves;
    }



}
