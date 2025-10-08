public class Recursion {
    public static double powers(double b ,int e){
        return Math.pow(b, e);
    }
    public static double power(double b ,int e){
        if(e == 0){
            return 1;
        }
        if(e < 0 ){
            return 1 / power(b , -e);
        }
        return b * power(b, e-1);
    }

    public static Boolean isSafe(char Board[][],int row,int col){
            for(int i =row-1 ;i>=0;i--){
                if(Board[i][col] == 'Q'){
                    return false;
                }
            }
            for(int i=row-1 , j=col-1; i>=0 && j>=0 ; i-- , j--){
                if(Board[i][j] == 'Q'){
                    return false;
                }
            }
            for(int i =row-1 , j = col+1; i>=0 && j<=Board.length;i--,j++){
                if(Board[i][j] =='Q'){
                    return false;
                }
            }
            return true;
        }
        public static void printBoard(char Board[][]){
            for(int i=0 ; i<Board.length;i++){
                for(int j = 0; j<Board.length; j++){
                    System.out.print(Board[i][j]+" ");
                }
                System.out.println();
            }
        }

    public static void nQueen(char Board[][] ,int row){
        if(row == Board.length){
            printBoard(Board);
            return;
        }
        for(int j=0;j<Board.length;j++){
            if(isSafe(Board , row ,j)){
                Board[row][j] = 'Q';
                nQueen(Board , row+1);
                Board[row][j] = '.';
            }
        }
        
    }

    public static boolean isSafe(int mat[][] , int row ,int col, int num){  //row match
        for(int i = 0 ; i<9 ; i++){
            if(mat[row][i] == num){
                return false;
            }
        }
        for(int i = 0 ; i<9 ; i++){         // col match
            if(mat[i][col] == num){
                return false;
            }
        }
        
        int startrow = row - (row % 3) , startcol = col - (col % 3);
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j<3 ; j++){
                if(mat[i + startrow][j+startcol] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solveSudokuOn(int mat[][] , int row , int col){
        if(row == 8 && col == 9){                      //base condition
            return true;   
        }
        if(col == 9){
            row++;
            col = 0;
        }
        if(mat[row][col] != 0){
            return solveSudokuOn(mat , row ,col+1);
        }
        for(int num = 1; num <= 9; num++){
            if(isSafe(mat , row , col, num)){
                mat[row][col] = num;
                if(solveSudokuOn(mat , row , col+1)){
                    return true;
                }
                mat[row][col] = 0;
            }
        }
        return false;
    }
    public static void solveSudoku(int[][] mat) {
        
        solveSudokuOn(mat ,0,0);
    }


    public static void main(String[] args) {
        double b = 3;
        int e = 5;
        System.out.println(power(b, e));
        System.out.println(powers(b, e));

        int n =2;
        char Board[][] = new char [n][n];
        for(int i=0 ; i<n;i++){
            for(int j = 0; j<n; j++){
                Board[i][j] = 'X';
            }
        }
        nQueen(Board , 0);

         int[][] mat = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        solveSudoku(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
    
}
