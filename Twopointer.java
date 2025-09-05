import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Twopointer {
    public static int countTriplets(int[] arr, int target) {
        // Code Here
        int n = arr.length;
        int res = 0;
        Arrays.sort(arr);
        
        for(int i=0; i<n-2; i++){
            int left = i+1 , right = n-1;
            
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                
                if(sum > target){
                    right-=1;
                }
                else if(sum<target){
                    left+=1;
                }
                else if(sum == target){
                    int ele1 = arr[left] , ele2 = arr[right];
                    int cnt1 = 0 , cnt2 = 0;
                    
                    while(left <= right && arr[left] == ele1){
                        left++;
                        cnt1++;
                    }
                    while(left <= right && arr[right] == ele2){
                        right--;
                        cnt2++;
                    }
                    if(ele1 == ele2){
                        res += (cnt1*(cnt1-1))/2;
                    }
                    else{
                        res +=(cnt1*cnt2);
                    }
                }
                
                
            }
        }
        return res;
        
    }

    public static int countPairs(int arr[], int target) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int count =0;
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum < target){
                count += right - left;
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }

    public  static ArrayList<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        ArrayList<Integer> ls = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        while(left<right){
            int sum = arr[left] + arr[right];
            int abslt = Math.abs(target -sum);
            
            if(abslt < min){
                min = abslt;
                ls = new ArrayList<>(Arrays.asList(arr[left] , arr[right]));
                
            }
            else if(sum == target){
                return new ArrayList<>(Arrays.asList(arr[left] , arr[right]));
            }
            else if(sum <target){
                left++;
            }
            else{
                right--;
            }
        }
        return ls;
    }

    public static int countPairs2(int arr[], int target) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int res  = 0;
        int left = 0;
        int right = n-1;
        
        
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum > target){
                right--;
            }
            else if(sum < target){
                left++;
            }
            else{
                int ele1 = arr[left] , ele2 = arr[right];
                int cnt1 = 0 , cnt2 = 0;
                
                while(left <= right && arr[left] == ele1){
                    left++;
                    cnt1++;
                }
                while(left <=right && arr[right] == ele2){
                    right--;
                    cnt2++;
                }
                if(ele1 == ele2){
                    res += (cnt1 * (cnt1 -1))/2;
                }
                else{
                    res += (cnt1*cnt2);
                }
            }
        }
        return res;
    }

    public static int countTriangles(int arr[]) {
        
        int res = 0;
        Arrays.sort(arr);
        
        for(int i = 0; i<arr.length;i++){
            int left = 0 , right = i-1;
            
            while(left < right){
                if(arr[left] + arr[right] >arr[i]){
                    res += right-left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

     public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        
        ArrayList <Integer> ans = new ArrayList<>();
        
        int s = 0 ,e = 0;
        int curr = 0;
        
        for(int i = 0; i<arr.length; i++){
            curr += arr[i];
        
            if(curr >= target){
                e = i;
            
                while(curr > target && s < e){
                    curr -= arr[s];
                    ++s;
                }
                if(curr == target){
                    ans.add(s+1);
                    ans.add(e+1);
                    return ans;
                }
            }
        }
        ans.add(-1);
        return ans;
    }

    public static ArrayList<Integer> countDistinct(int arr[], int k) {

        int n = arr.length;
        ArrayList <Integer> ans = new ArrayList<>();
        
        for(int i = 0; i<=n-k; i++){
            HashSet<Integer> hs = new HashSet<>();
            
            for(int j = i; j<i+k;j++){
                hs.add(arr[j]);
                
            }
            ans.add(hs.size());
        }
        return ans;
    }

    public static int longestUniqueSubstr(String s) {
        
        int n = s.length();
        int ans = 0;
        
        int arr[] = new int[26];
        for(int i=0; i<26; i++){
            arr[i] = -1;
        }
        
        int start = 0;
        
        for(int j = 0; j<n; j++){
             start = Math.max(start , arr[s.charAt(j) - 'a'] +1);
             
             ans = Math.max(ans , j-start + 1);
             
             arr[s.charAt(j) - 'a'] = j;
        }
        return ans;
    }

    public static int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int ans = 0;
        
        left[0] = arr[0];
        
        for(int i = 1; i<n; i++){
            left[i] = Math.max(left[i-1] , arr[i]);
        } 
        
        right[n-1] = arr[n-1];
        for(int j = n-2; j>=0;j--){
            right[j] = Math.max(right[j+1] , arr[j]);
        }
        
        for(int k =1; k<n-1; k++){
           int trapWater = Math.min(left[k] , right[k]);
            ans += trapWater - arr[k];
        }
        return ans;
    }

     public static int maxWater1(int arr[]) {
        // Code Here
        int left = 0 , right = arr.length-1;;
        int ans = 0;
        
        while(left < right){
            int minWater = Math.min(arr[right] , arr[left]) * (right-left);
            ans = Math.max(minWater ,ans);
            
            if(arr[left] < arr[right]){
                left += 1;
            }else{
                right -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {-3, -1, -1, 0, 1, 2};
        int target = -2;
        System.out.println(countTriplets(arr, target));

        int arr1[] = {5, 2, 3, 2, 4, 1};
        int target1 = 5;
        System.out.println(countPairs(arr1, target1));

        int arr2[] = {5, 2, 7, 1, 4};
        int target2 = 10;
        System.out.println(sumClosest(arr2, target2));

        int arr3[] = {-1, 1, 5, 5, 7};
        int target3 = 6;
        System.out.println(countPairs2(arr3, target3));

        int arr4[] = {10, 21, 22, 100, 101, 200, 300};
        System.out.println(countTriangles(arr4));

        int arr5[] = {1, 2, 3, 7, 5};
        int target4 = 12;
        System.out.println(subarraySum(arr5, target4));

        int arr6[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println(countDistinct(arr6, k));

        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));

        int arr7[] = {3, 0, 1, 0, 4, 0, 2};
        System.out.println(maxWater(arr7));

        int arr8[] = {1, 5, 4, 3};
        System.out.println(maxWater1(arr8));

    }
}
