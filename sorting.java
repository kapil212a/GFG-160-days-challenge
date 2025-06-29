import java.util.*;
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

    static int countMerge(int arr[] , int start,int mid, int end){
        int n1 = mid - start+1;
        int n2 = end-mid;
        
        int left [] = new int[n1];
        int right[] = new int[n2];
        
        for(int i=0;i<n1;i++){
            left[i] = arr[i+start];
        }
        for(int j=0;j<n2;j++){
            right[j] = arr[mid+1+j];
        }
        
        int res = 0;
        int i=0; 
        int j=0;
        int k = start;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
                res += (n1-i);
                
            }
        }
        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
            arr[k++] = right[j++];
        }
        return res;
    }
    
    static int countMid(int arr[],int start,int end){
        int res = 0;
        if(start<end){
            int mid = (start+end)/2;
            
            res += countMid(arr,start,mid);
            res += countMid(arr,mid+1,end);
            
            res += countMerge(arr,start,mid,end);
            
        }
        return res;
    }
    
    static int inversionCount(int arr[]) {
        // Your Code Here
        return countMid(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        // int arr[] ={0, 1, 2, 0, 1, 2};
        // sort012(arr);
        // printArr(arr);\

        // int citations[] = {5, 1, 2, 4, 1};
        // System.out.println(hIndex(citations));

        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }
}