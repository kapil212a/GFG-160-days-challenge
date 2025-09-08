import java.util.*;
public class prefix_sum {
    public static int findEquilibrium(int arr[]) {
        
        int n = arr.length;
        int start[] = new int [n];
        int end[] = new int[n];
        
        start[0] = arr[0];
        end[n-1] = arr[n-1];
        
        for(int i = 1; i<n; i++){
            start[i] = start[i-1] + arr[i];
        }
        for(int i = n-2; i>=0; i--){
            end[i] = end[i+1] + arr[i];
        }
        for(int i = 0; i<n; i++){
            if(start[i] == end[i]){
                return i;
            }
        }
        return -1;
    }

    public static int longestSubarray(int[] arr, int k) {
        
        int n = arr.length;
        int sum = 0;
        HashMap <Integer , Integer> mp = new HashMap<>();
        int ans =0;
        for(int i = 0; i<n; i++){
            sum +=arr[i];
           
           if(sum == k){
                ans = Math.max(ans , i+1);
                
            }
            if(mp.containsKey(sum - k)){
                int len = i - mp.get(sum - k);
                ans = Math.max(ans , len);
            }
            mp.putIfAbsent(sum , i);
        }
        return ans;
    }

    public static int maxLen(int[] arr) {

        HashMap<Integer , Integer> mp = new HashMap<>();
        int sum = 0;
        int ans = 0;
        
        for(int i = 0 ; i<arr.length; i++){
            if(arr[i] == 0){
                sum += -1;
            }else{
                sum += 1;
            }
            if(sum == 0){
                ans = i+1;
            }
            if(mp.containsKey(sum)){
                ans = Math.max(ans , i-mp.get(sum));
            }else{
                mp.put(sum , i);
            }
        }return ans;
    }

    public static int[] productExceptSelf(int arr[]) {
        
        int n = arr.length;
        int ans[] = new int[n];
        Arrays.fill(ans , 1);
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i != j){
                    ans[i] *= arr[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibrium(arr));

        int arr1[] = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(longestSubarray(arr1, k));

        int arr2[] = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(maxLen(arr2));

        int arr3[] = {10, 3, 5, 6, 2};
        System.out.println(productExceptSelf(arr3));
    }
}
