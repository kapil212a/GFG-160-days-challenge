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
    
    public static void main(String args[]){
        String s  = " -123";
        System.out.println(myAtoi(s));
    }
}
