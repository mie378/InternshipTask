import org.junit.Assert;
import org.junit.Test;
import task1.Node;
import task1.Task1Solver;

public class Task1Tests {
    private Node buildTreeFromExample(){
        //example given in the document
        Node root=new Node(5);
        Node rootL=new Node(3);
        Node rootLL=new Node(2);
        Node rootLR=new Node(5);
        Node rootR=new Node(7);
        Node rootRL=new Node(1);
        Node rootRR=new Node(0);
        Node rootRRL=new Node(2);
        Node rootRRR=new Node(8);
        Node rootRRRR=new Node(5);
        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootL.setLeftNode(rootLL);
        rootL.setRightNode(rootLR);
        rootR.setLeftNode(rootRL);
        rootR.setRightNode(rootRR);
        rootRR.setLeftNode(rootRRL);
        rootRR.setRightNode(rootRRR);
        rootRRR.setRightNode(rootRRRR);
        return root;
    }
    private Node buildShuffledTreeFromExample(){
        //the tree from example but some right and left nodes are swapped
        Node tree=buildTreeFromExample();
        Node rootL=tree.getLeftNode();
        Node rootR=tree.getRightNode();
        Node rootRR=rootR.getRightNode();
        Node rootRL=rootR.getLeftNode();
        tree.setLeftNode(rootR);
        tree.setRightNode(rootL);
        rootR.setLeftNode(rootRR);
        rootR.setRightNode(rootRL);
        return tree;
    }
    private Node buildSecondTree(){
        //there is a visualized tree in the TreesVisualized directory
        Node root=new Node(2);
        Node rootL=new Node(20);
        Node rootR=new Node(10);
        Node rootLL=new Node(2);
        Node rootLR=new Node(10);
        Node rootLLR=new Node(21);
        Node rootLLRL=new Node(28);
        Node rootLLRR=new Node(25);
        Node rootRR=new Node(10);
        Node rootRRL=new Node(25);
        Node rootRRLR=new Node(5);
        Node rootRRLRR=new Node(20);
        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootR.setRightNode(rootRR);
        rootRR.setLeftNode(rootRRL);
        rootRRL.setRightNode(rootRRLR);
        rootRRLR.setRightNode(rootRRLRR);
        rootL.setLeftNode(rootLL);
        rootL.setRightNode(rootLR);
        rootLL.setRightNode(rootLLR);
        rootLLR.setLeftNode(rootLLRL);
        rootLLR.setRightNode(rootLLRR);
        return root;
    }
    private Node buildThirdTree(){
        //there is a visualized tree in the TreesVisualized directory
        Node root=new Node(20);
        Node rootL=new Node(10);
        Node rootLL=new Node(10);
        Node rootLLL=new Node(10);
        Node rootR=new Node(5);
        Node rootRL=new Node(10);
        Node rootRLR=new Node(2);
        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootL.setLeftNode(rootLL);
        rootLL.setLeftNode(rootLLL);
        rootR.setLeftNode(rootRL);
        rootRL.setRightNode(rootRLR);
        return root;
    }
    @Test
    public void numOfLeavesTest(){
        Node root=this.buildTreeFromExample();
        Node root2=this.buildSecondTree();
        Node root3=this.buildThirdTree();

        int answer= Task1Solver.numOfLeaves(root);
        Assert.assertEquals(5,answer);
        Assert.assertEquals(4,Task1Solver.numOfLeaves(root2));
        Assert.assertEquals(2,Task1Solver.numOfLeaves(root3));
        Assert.assertEquals(1,Task1Solver.numOfLeaves(new Node(4)));
    }
    @Test
    public void longestPathTest(){
        Node root=this.buildTreeFromExample();
        Node root2=this.buildSecondTree();
        Node root3=this.buildThirdTree();

        int answer=Task1Solver.longestPath(root);
        Assert.assertEquals(4,answer);
        Assert.assertEquals(5,Task1Solver.longestPath(root2));
        Assert.assertEquals(3,Task1Solver.longestPath(root3));
        Assert.assertEquals(0,Task1Solver.longestPath(new Node(5)));

    }
    @Test
    public void areEqualTest(){
        Node root1=this.buildTreeFromExample();
        Node root1Shuffled=this.buildShuffledTreeFromExample();
        Node root1Copy=this.buildTreeFromExample();
        Node root2=this.buildSecondTree();
        Node root3=this.buildThirdTree();
        Node root2Copy=this.buildSecondTree();

        root1Copy.getRightNode().setRightNode(new Node(10));

        boolean answer1=Task1Solver.areEqual(root1,root1Shuffled);
        boolean answer2=Task1Solver.areEqual(root1,root1Copy);
        Assert.assertTrue(answer1);
        Assert.assertFalse(answer2);
        Assert.assertFalse(Task1Solver.areEqual(new Node(4),new Node(6)));
        Assert.assertTrue(Task1Solver.areEqual(new Node(1),new Node(1)));
        Assert.assertTrue(Task1Solver.areEqual(root2,root2Copy));
        Assert.assertFalse(Task1Solver.areEqual(root3,root2));
    }
}
