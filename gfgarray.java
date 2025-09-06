import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gfgarray {

    public static void printArray(int arr[]){  //funtion of print arrays
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static int missing(int arr[]){             //finding missing element
        int n = arr.length+1;
        for(int i=1;i<n+1;i++){
            boolean found = false;
            for(int j=0;j<n-1;j++){
                if(arr[j]==i){
                    found = true;
                }
            }
            if(!found){
                return i;
            } 
        }return -1;
    }

    public static int missingArr(int arr[]){
        int n = arr.length+1;
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int total = n*(n+1)/2;
        int y = total - sum;
        return y;

    }

    public static int getSecondLargest(int[] arr) {            //find Second largest element
       
        int largest = 0;
        int secondlarge = 0;
        
        for (int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        for (int j=0;j<arr.length;j++){
            if(arr[j]>secondlarge && arr[j]!=largest){
                secondlarge = arr[j];
            }
        }return secondlarge;
    }

    public static void reverseArray(int arr[]){              //Reverse of Array
        int first = 0;
        int last = arr.length-1;
        while(first<last){
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
    }
    
    
    public static void reverse(int arr[],int start, int end){
        while(start<end){
            swap(arr, start++, end--);
        }
    }
    public static void swap(int arr[] , int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }
    

    public static void permutation(int arr[]){
        int n = arr.length;
        int pivit = -1;
        for(int i = n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                pivit = i;
                break;
            }
        }
        if(pivit == -1){
            reverse(arr,0,n-1);
            return;
        }
        for(int j = n-1;j>=pivit;j--){
            if(arr[j]>pivit){
                swap(arr,j,pivit);
                break;
            }
        }
        reverse(arr,pivit+1,n-1);
    }

    public static void circularArr(int arr[], int rotate){
        int n=arr.length;
        int temp[] = new int[n];
        for(int i=0; i<n;i++){
            temp[i] = arr[i];
        }
        for(int j=0;j<temp.length;j++){
            arr[j]=temp[j] ;
        }
    }

    public List<Integer> findMajority(int[] arr) {
        int n = arr.length;
        int ele1 =-1;
        int ele2 = -1;
        int count1 =0;
        int count2=0;
        for(int i=0;i<n;i++){
            if(arr[i]==ele1){
                count1++;
            }
            else if(arr[i] ==ele2){
                count2++;
            }
            else if(count1==0){
                ele1=arr[i];
                count1++;
            }
            else if(count2==0){
                ele2=arr[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(int j=0;j<n;j++){
            if(arr[j] == ele1){
                count1++;
            }
            else if(arr[j] == ele2){
                count2++;
            }
        }
        List <Integer> result = new ArrayList<>();
        if(count1>n/3){
            result.add(ele1);
        }
        if(count2>n/3){
            result.add(ele2);       
        }
        if(result.size() == 2 && result.get(1) < result.get(0)){
            int temp = result.get(0);
            result.set(0,result.get(1));
            result.set(1,temp);
        }
        return result;
    }

    public static void pushZerosToEnd(int[] arr) {
        
        int n = arr.length;
        int push = 0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i]  = arr[push];
                arr[push] = temp;
                
                push++;
            }
            
        }
    }
    public static int maximumProfit(int prices[]) {         ///Multiple Transition
        
        int maxprofit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxprofit += prices[i]-prices[i-1];
            }
        }return maxprofit;
    }

    public static int maximumProfit2(int prices[]) {        ///Max one Transaction Allowed
       
        int min = prices[0];
        int maxprofit =0;
        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            maxprofit = Math.max(maxprofit,prices[i]-min);
        }
        return maxprofit;
    }

    public static int getMinDiff(int[] arr, int k) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int diff = arr[n-1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-k<0){
                continue;
            }
            int min = Math.min(arr[0]+k,arr[i]-k);
            int max = Math.max(arr[i-1]+k,arr[n-1]-k);
            diff = Math.min(diff,max-min);
        }return diff;
    }

    public static int maxSubarraySum(int[] arr) { ////Kadane's Algorithm
        
        int max = arr[0];
        int sum =arr[0];
        for(int i=1;i<arr.length;i++){
            
            max = Math.max(max+arr[i],arr[i]);
            sum = Math.max(max,sum); 
        }return sum;
    }

    public static int maxProduct(int[] arr) {
        
        int max = Integer.MIN_VALUE;
        int leftToright = 1;
        int rightToleft = 1;
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            if(leftToright==0){
                leftToright = 1;
            }
            if(rightToleft==0){
                rightToleft = 1;
            }
            leftToright *=arr[i];
            
            int j = n-1-i;
            rightToleft *=arr[j];
            
            max = Math.max(leftToright,Math.max(rightToleft,max));
        }
        return max;
    }
    
       
    public static void main(String[] args) {
        // int arr [] = {1,2,3,4,5,7};
        // System.out.println(missingArr(arr));

        // int arr[] = {12,35,1,10,34,1};
        // System.out.println(getSecondLargest(arr));

        // int arr[] = {5,6,4,3,2,1};
        // reverseArray(arr);

        // int arr[] = {1,2,3,4,5};
        // int rotate = 2;
        // circularArr(arr, rotate);
        // printArray(arr);
        
        // int arr [] = {2,4,1,7,5,0,};
        // permutation(arr);
        // printArray(arr);

        // int arr[] = {3,5,0,0,4};
        // pushZerosToEnd(arr);
        // printArray(arr);

        // int arr[] = {100, 180, 260, 310, 40, 535, 695};
        // System.out.println(maximumProfit(arr));
        
        // int arr[] = {7, 10, 1, 3, 6, 9, 2};
        // System.out.println(maximumProfit2(arr));

        // int arr[] = {3, 9, 12, 16, 20};
        // int k = 3;
        // System.out.println(getMinDiff(arr,k));

        int arr[] = {2, 3, -8, 7, -1, 2, 3};
         System.out.println(maxSubarraySum(arr));

        // int arr[] = {-2, 6, -3, -10, 0, 2};
        // System.out.println(maxProduct(arr));
        System.out.println("hello");
    }

}
