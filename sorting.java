import java.util.*;
public class sorting{

    public static void printArr(int arr[]){                 //print the array
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
        
        return countMid(arr,0,arr.length-1);
    }

    public static List<int[]> mergeOverlap(int[][] arr) {
        
        Arrays.sort(arr,(a,b) ->Integer.compare(a[0],b[0]));
        
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{arr[0][0],arr[0][1]});
        
        for(int i=1;i<arr.length;i++){
            int[] last = res.get(res.size()-1);
            int[] curr = arr[i];
            
            
            if(curr[0]<=last[1]){
                last[1] = Math.max(curr[1] , last[1]);
            }
            else{
                res.add(new int[]{curr[0],curr[1]});
            }
        }return res;
        
    }

    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> res = new ArrayList<>();
        int i= 0;
        int n = intervals.length;
        
        while(i < n && intervals[i][1]< newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        
        while(i<n && intervals[i][0]<=newInterval[1]){
            
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        
        res.add(newInterval);
        
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res;
    }

    static int minRemoval(int intervals[][]) {
        
        Arrays.sort(intervals , (a,b)-> a[0]-b[0]);
        
        int end = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]< end){
                end = Math.min(intervals[i][1],end);
                
                count++;
            }
            else{
                end = intervals[i][1];
            }
        }
        return count;
    }

    public static void mergeArrays(int a[], int b[]) {
       
        int i = a.length-1;
        int j = 0;
        
        while(i>=0 && j<b.length){
            if(a[i]<b[j]){
                i--;
            }
            else{
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        // int arr[] ={0, 1, 2, 0, 1, 2};
        // sort012(arr);
        // printArr(arr);\

        // int citations[] = {5, 1, 2, 4, 1};
        // System.out.println(hIndex(citations));

        // int arr[] = {2, 4, 1, 3, 5};
        // System.out.println(inversionCount(arr));

        // int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        // List<int[]> res = mergeOverlap(arr);
        // for (int[] interval : res) 
        //     System.out.println(interval[0] + " " + interval[1]);
        // }

        // int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        // int[] newInterval = {5, 6};
        // ArrayList<int[]> res = insertInterval(intervals, newInterval);
        // for (int[] interval : res) {
        //     System.out.println(interval[0] + " " + interval[1]);
        // }

        // int intervals[][] = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        // System.out.println(minRemoval(intervals));~

        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a){
            System.out.print(ele + " ");
        }
        System.out.println();
        for (int ele : b){
            System.out.print(ele + " ");
        }
    }
}
