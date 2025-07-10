import java.util.ArrayList;

public class matrix {
    public static ArrayList<Integer> spirallyTraverse(int[][] mat) {
    
        int m = mat.length;
        int n = mat[0].length;
        
        ArrayList<Integer> spy = new ArrayList<>();
        
        int startrow = 0;
        int startcol = 0;
        int endrow = m-1;
        int endcol = n-1;
        
        while(startrow <= endrow && startcol <= endcol){
            for(int j = startcol;j<=endcol;j++){
                spy.add(mat[startrow][j]);
            }
            
            for(int i= startrow+1;i<=endrow;i++){
                spy.add(mat[i][endcol]);
            }
            for(int j = endcol-1;j>=startrow;j--){
                if(startrow==endrow){
                    break;
                }
                spy.add(mat[endrow][j]);
            }
            for(int i = endrow-1;i>startrow;i--){
                if(startcol==endcol){
                    break;
                }
                spy.add(mat[i][startcol]);
            }
            startcol++;
            endcol--;
            startrow++;
            endrow--;
        }
        return spy;
    }

     public static void rotateMatrix(int[][] mat) {   ///90 degree rotation
        int n = mat.length;
        
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][n-1-i];
                mat[j][n-1-i] = mat[n-1-i][n-1-j];
                mat[n-1-i][n-1-j] = mat[n-1-j][i];
                mat[n-1-j][i] = temp;
            }
        }
    }

    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int row = 0;
        int col = mat[0].length-1;
        
        while(row<mat.length && col>=0){
            if(mat[row][col]==x){
                return true;
            }
            else if(mat[row][col] > x){
                col--;
            }else{
                row++;
            }
        }
        return false;
        
    }

     public static boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i =0;i<n;i++){
            int low = 0;
            int hi = m-1;
            
            while(low<=hi){
                int mid = (low+hi)/2;
                if(mat[i][mid] == x){
                    return true;
                }
                else if(mat[i][mid] > x){
                    hi = mid-1;
                }else{
                    low = mid +1;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int lo = 0;
        int hi = m*n-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            int row = mid/m;
            int col = mid%m;
            
            if(mat[row][col]==x){
                return true;
            }
            else if(mat[row][col] > x){
                hi = mid-1;
            }
            else{
                lo = mid + 1;
            }
        }
        return false;
        //     int n = mat.length;
        //     int m = mat[0].length;
        //     for(int i=0;i<n;i++){
        //         for(int j =0;j<m;j++){
        //             if(mat[i][j] == x){
        //                 return true;
        //             }
        //         }
        //     }
        //     return false;
    }
    
    public static void main(String[] args) {
        // int[][] mat = {
        //     {1, 2, 3, 4}, 
        //     {5, 6, 7, 8}, 
        //     {9, 10, 11, 12}, 
        //     {13, 14, 15, 16}
        // };

        // ArrayList<Integer> res = spirallyTraverse(mat);
        // for (int ele : res) {
        //     System.out.print(ele + " ");
        // }

        // int[][] mat = {
        //     {1, 2, 3, 4},
        //     {5, 6, 7, 8},
        //     {9, 10, 11, 12},
        //     {13, 14, 15, 16}
        // };

        // rotateMatrix(mat);
        // for (int i = 0;i<mat.length;i++) {
        //     for (int j = 0;j<mat.length;j++) {
        //         System.out.print(mat[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        // int mat[][] = {{3, 30, 38},
        //                {20, 52, 54},
        //                {35, 60, 69}
        //             };
        //             int k = 60;
        // System.out.println(matSearch(mat, k));

        // int mat[][] = {{3, 4, 9},
        //                 {2, 5, 6},
        //                 {9, 25, 27}};
        //                 int x = 9;
        // System.out.println(searchRowMatrix(mat,x));
                    
        int mat[][] = {{1, 5, 9}, 
                       {14, 20, 21}, 
                       {30, 34, 43}};
                       int x = 14;
                       System.out.println(searchMatrix(mat, x));

    }
    
}
