import java.util.Arrays;

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

    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int target = -2;
        System.out.println(twoSum(arr,target));
    }
}
