package tree;
public class BinarytreesB {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class BinaryTree{
        static int idx = -1;
        public static Node buildtree(int arr[]){
            idx++;
            if(arr[idx] == -1){
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = buildtree(arr);
            newNode.right = buildtree(arr);
            return newNode;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
    //    BinaryTree tree = new BinaryTree();
    //    Node root = tree.buildtree(arr);
       Node root = BinaryTree.buildtree(arr);
       System.out.println(root.data);
       

    }
    
}

