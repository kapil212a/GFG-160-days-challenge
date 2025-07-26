public class ran{
    public static void reverse(int a , int b){
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a);
        System.out.println(b);
    }

    public static int reversenum(int num){
        int rev = 0;
        while(num>=0){
            int last = num%10;
            rev  = rev * 10 + last;
            num  = num/10;
        }
        return rev;
    }
    public static void main(String[] args) {
        // int a =10;
        // int b = 9;
        // reverse(a, b);
        int num = 12345;
        System.out.print(reversenum(num));
    }
}