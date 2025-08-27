import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static ArrayList<Integer> intersect(int[] a, int[] b) {
        
        HashSet<Integer> sa = new HashSet<>();
        for(int num:a){
            sa.add(num);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int num : b){
            if(sa.contains(num)){
                ans.add(num);
                sa.remove(num);
            }
        }
        return ans;
        
    }

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        
        HashSet<Integer> sa = new HashSet<>();
        
        for(int add : a){
            sa.add(add);
        }
        
        for(int add2 : b){
            sa.add(add2);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int add3 : sa){
            ans.add(add3);
        }
        
        return ans;
    }

    public static int longestConsecutive(int[] arr) {

        Set<Integer> st = new HashSet<>();
        int res = 0;
        for(int val : arr){
            st.add(val);
        }
        for(int val1 : arr){
            if(st.contains(val1) && !st.contains(val1-1)){
                int curr = val1 , cnt = 0;
                while(st.contains(curr)){
                    st.remove(curr);
                    curr++;
                    cnt++;
                }
                
                res = Math.max(res , cnt);
            }
        }
        return res;
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

        int arr3[] = {1, 2, 1, 3, 1};
        int arr4[] = {3, 1, 3, 4, 1};
        System.out.println(intersect(arr3, arr4));

        int arr5[] = {1, 2, 3, 2, 1};
        int arr6[] = {3, 2, 2, 3, 3, 2};
        System.out.println(findUnion(arr5, arr6));

        int arr7[] = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr7));

    }
}
