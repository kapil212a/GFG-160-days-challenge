public class ran{
    public static void reverse(int a , int b){
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a);
        System.out.println(b);
    }
    public static void main(String[] args) {
        int a =10;
        int b = 9;
        reverse(a, b);
    }
}