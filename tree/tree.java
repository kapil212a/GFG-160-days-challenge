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

    public static int diamter(Node root){
        if(root == null){
            return 0;
        }
        int lheight = height(root.left);
        int rhight = height(root.right);

        int ldiam = diamter(root.left);
        int rdiam = diamter(root.right);

        return Math.max(lheight+rhight , Math.max(ldiam , rdiam));

    }


    public static void main (String args[]){
        Node root = new Node(12);                                          //    12
        root.right = new Node(8);                                         //   /    \
        root.left = new Node(18);                                        //   18     8
        root.left.right  = new Node(5);                                 //   /  \      
        root.left.left = new Node(11);                                 //   11   5    
        System.out.println(height(root));

        Node root1 = new Node(5);                                         //        5
        root1.left = new Node(8);                                        //       /   \
        root1.right = new Node(6);                                      //       8     6
        root1.left.left = new Node(3);                                 //       / \   /
        root1.left.right = new Node(7);                               //       3   7 9
        root1.right.left = new Node(9);
        System.out.println(diamter(root1));
    }
}