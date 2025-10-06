public class Recursion {
    public static double power(double b ,int e){
        if(e == 0){
            return 1;
        }
        if(e < 0 ){
            return 1 / power(b , -e);
        }
        return b * power(b, e-1);
    }

    public static void main(String[] args) {
        double b = 3;
        int e = 5;
        System.out.println(power(b, e));
    }
}
