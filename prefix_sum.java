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

    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibrium(arr));
    }
}
