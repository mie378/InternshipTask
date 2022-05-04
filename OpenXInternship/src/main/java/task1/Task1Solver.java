package task1;

public class Task1Solver {
/*
Let f(root) be the number of leaves in a tree
Therefore, f(root)=f(root.left)+f(root.right)  and f(leaf)=1
Complexity: O(n)
 */
    public static int numOfLeaves(Node root){
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
/*
Let f(root) be the largest number of edges in a path from the root node
Therefore, f(root)=max(f(root.left),f(root.right))+1 and f(leaf)=0
Complexity: O(n)
 */
    public static int longestPath(Node root){
        if(root==null){
            return 0;
        }
        if(root.getLeftNode()==null&&root.getRightNode()==null){
            return 0;
        }
        return 1+Math.max(longestPath(root.getLeftNode()),longestPath(root.getRightNode()));
    }
/*
Assuming that the fact whether the node is on the left or right of its parent Node doesn't make it a different structure
since the graph stays the same
Let f(root1,root2) be the boolean that returns true if two structures are equivalent and false if they are not
Therefore, f(root1,root2)=true if root1.value==root2.value and ((f(root1.left,root2.left) and f(root1.right,root2.right)) or
(f(root1.left,root1.right) and f(root1.right,root2.left)))
Complexity: O(n)
*/
    public static boolean areEqual(Node root1, Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root2==null){
            return false;
        }
        boolean equalValues=root1.getValue()==root2.getValue();
        if(!equalValues){
            return false;
        }
        boolean equalSubtrees=areEqual(root1.getLeftNode(),root2.getLeftNode())&&areEqual(root1.getRightNode(),root2.getRightNode());
        if(equalSubtrees){
            return true;
        }
        equalSubtrees=areEqual(root1.getLeftNode(),root2.getRightNode())&&areEqual(root1.getRightNode(),root2.getLeftNode());
        return equalSubtrees;
    }
}
