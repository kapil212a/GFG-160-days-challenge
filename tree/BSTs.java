package tree;
public class BSTs {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left , val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void main(String[] args) {
        int vlaue[] = {5,1,3,4,2,7};
        Node root = null;
        for(int i =0 ;i<vlaue.length; i++){
            root = insert(root, i);
        }
    }
}


// public class Main{
//     public static void indexes(int arr[],int target){
//         int n = arr.length;
//         int ls[] = new int[2];
//         int start = 0, end = arr.length-1;
//         int i = 0;
//         while(start < end){
            
//             if(arr[start]+arr[end] == target){
//                 ls[i] = start;
                
//                 ls[i+1] = end;
//                 break;
//             }
//             else if(arr[start]+arr[end] > target){
//                 end--;
//                 if(arr[start] > target){
//                     start++;
//                 }
//             }
//             else{
//                 start++;
//             }
//         }
//         for(int j =0;j<ls.length;j++){
//             System.out.print(ls[j]);
//         }
//     }
//     public static void main (String args[]){
//         int arr[] = {3,19,2,1,5,19};
//         indexes(arr,5);
        
        
//     }

// }