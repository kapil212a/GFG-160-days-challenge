import java.util.Arrays;

public class gfgString {
    public static int myAtoi(String s) {
        int res =0;
        int sign =1;
        int indx=0;
        while(indx < s.length() && s.charAt(indx)==' '){
            indx++;
        }
        
        if(indx < s.length() && (s.charAt(indx)=='-' || s.charAt(indx)=='+')){
            if(s.charAt(indx++)=='-'){
                sign = -1;
            }        
            
        }
        while(indx < s.length() && s.charAt(indx) >='0' && s.charAt(indx) <='9'){
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10  && s.charAt(indx) -'0'>7)){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                
            }
            res = 10 * res + (s.charAt(indx++)-'0');
        }
        return res * sign;
    }

    
    static String removeZero(String s){
        int first = s.indexOf("1");
        return (first == -1) ? "0" : s.substring(first);
    }
    public static String addBinary(String s1, String s2) {
        
        s1 = removeZero(s1);
        s2 = removeZero(s2);
        
        int n = s1.length();    
        int m = s2.length();
        
        if(n<m){
            return addBinary(s2,s1);
        }
        
        int j = m-1;
        int carry = 0;
        StringBuilder result = new StringBuilder(); 
        
        for(int i = n-1;i>=0;i--){
            int str1 = s1.charAt(i) - '0';
            int sum = str1 + carry;
            
            if(j>=0){
                int str2 = s2.charAt(j) - '0';
                sum +=str2;
                j--;
            }
            
            int str3 = sum%2;
            carry = sum/2;
            
            result.append((char)(str3 + '0'));
        }
        
        if(carry>0){
            result.append('1');
        }
        return result.reverse().toString();
    }

    public static boolean areAnagrams(String s1, String s2) {
        
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        return Arrays.equals(str1,str2);
    }
    
    public static void main(String args[]){
        // String s  = " -123";
        // System.out.println(myAtoi(s));
        // System.err.println(s);

        String s1 = "1101";
        String s2 = "111";
        System.out.println(addBinary(s1,s2));

        String str = "heart";
        String stri = "earth";
        System.out.println(areAnagrams(str, stri));
    }
}
