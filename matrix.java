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
    
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4}, 
            {5, 6, 7, 8}, 
            {9, 10, 11, 12}, 
            {13, 14, 15, 16}
        };

        ArrayList<Integer> res = spirallyTraverse(mat);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}
