import java.util.ArrayList;
import java.util.Collections;

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


    public static int searchInSortedAndRot(int arr[],int key){   ////o(nlogn)
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid]>=arr[start]){
                if(key>=arr[start] && key<arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(key>arr[mid] && key<=arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }return -1;
    }

    public static int search(int[] arr, int key) {

        for(int i = 0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
        
    }

     public static int peakElement(int[] arr) {
        
        int n = arr.length;
        if(n==1){
            return 0;
        }
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[n-1]>arr[n-2]){
            return n-1;
        }
        int start = 1;
        int end = n-2;
        while(start<=end){
            int mid  = (start+end)/2;
            if(arr[mid] >arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid]<arr[mid+1]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }return -1;
    }

    public static int kthElement(int a[], int b[], int k) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i:a){
            arr.add(i);
        }
        for(int j:b){
            arr.add(j);
        }
        Collections.sort(arr);
        return arr.get(k-1);
        
    }

    public static void main(String[] args) {
        // int arr[] = {1, 1, 2, 2, 2, 2, 3};
        // int target = 2;
        // System.out.println(countFreq(arr, target));

        // int arr[] = {5, 6, 1, 2, 3, 4};
        // System.out.println(findMin(arr));

        // int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        // int key1 = 3;
        // System.out.println(searchInSortedAndRot(arr1, key1));

        // int arr [] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        // int key = 3;
        // System.out.println(search(arr, key));

        // int arr[] = {1, 2, 4, 5, 7, 8, 3};
        // System.out.println(peakElement(arr));

        int a[] = {2, 3, 6, 7, 9};
        int b[] = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElement(a, b, k));

    }
}
