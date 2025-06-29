public class sorting{

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort012(int[] arr) {
        
        int start = 0;
        int mid = 0;
        int hi = arr.length-1;
        
        while(mid<=hi){
            if(arr[mid]==0){
                swap(arr,mid,start);
                mid++;
                start++;
            }
            else if(arr[mid] ==1){
                mid++;
            }
            else{
                swap(arr,mid,hi);
                hi--;
            }
        }
    }

    public static int hIndex(int[] citations) {
        
        int n = citations.length;
        int freq[] = new int [n+1];
        
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                freq[n] +=1;
            }
            else{
                freq[citations[i]] +=1;
            }
        }
        int idx = n;
        int s = freq[n];
        
        while(s<idx){
            idx--;
            s += freq[idx];
        }
        return idx;
        
    }

    public static void main(String[] args) {
        // int arr[] ={0, 1, 2, 0, 1, 2};
        // sort012(arr);
        // printArr(arr);\

        int citations[] = {5, 1, 2, 4, 1};
        System.out.println(hIndex(citations));
    }
}