import java.util.ArrayList;
import java.util.Arrays;

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
    }
}
