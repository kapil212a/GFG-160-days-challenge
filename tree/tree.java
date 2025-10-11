package tree;
class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
}

public class tree {
    
    public static int height(Node root){
        if(root == null){
            return -1;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight , rheight)+1;
    }


    public static void main (String args[]){
        Node root = new Node(12);
        root.right = new Node(8);
        root.left = new Node(18);
        root.left.right  = new Node(5);
        root.left.left = new Node(11);
        System.out.println(height(root));
    }
}