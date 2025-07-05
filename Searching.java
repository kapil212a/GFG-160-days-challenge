public class Searching {
    public static int countFreq(int[] arr, int target) {
        
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target){
                count++;
            }
        }return count;
    }

    public static int findMin(int[] arr) {
        
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            if(arr[start]<arr[end]){
                return arr[start];
            }
            
            int mid = (start+end)/2;
            
            if(arr[mid]>arr[end]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return arr[start];
        
    }

    public static void main(String[] args) {
        // int arr[] = {1, 1, 2, 2, 2, 2, 3};
        // int target = 2;
        // System.out.println(countFreq(arr, target));

        int arr[] = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}
