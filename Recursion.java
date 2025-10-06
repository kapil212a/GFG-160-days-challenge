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
    }
}
