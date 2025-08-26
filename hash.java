import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hash {
     public static boolean twoSum(int arr[], int target) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                return true;
            }
            else if(sum > target){
                end--;
            }
            else{
                start++;
            }
        }
        return false;
    }

    public static int countPairs(int arr[], int target) {
        Map<Integer,Integer> hs = new HashMap<>();
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(hs.containsKey(target - arr[i])){
                count += hs.get(target - arr[i]);
            }
            hs.put(arr[i] , hs.getOrDefault(arr[i],0) +1);
        }
        return count;
        
    }

    public static  List<List<Integer>> findTriplets(int[] arr) {
        HashMap <Integer ,List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int j =0;j<arr.length;j++){
            for(int k=j+1;k<arr.length;k++){
                int val = -1*(arr[j]+arr[k]);
                if(map.containsKey(val)){
                    for(int i:map.get(val)){
                        ans.add(Arrays.asList(i,j,k));
                    }
                }
            }
            
            map.putIfAbsent(arr[j],new ArrayList<>());
            map.get(arr[j]).add(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int target = -2;
        System.out.println(twoSum(arr,target));

        int arr1[] = {1, 5, 7, -1, 5};
        int target1 = 6;
        System.out.println(countPairs(arr1, target1));

        int arr2[] = {0, -1, 2, -3, 1};
        System.out.println(findTriplets(arr2));

    }
}
