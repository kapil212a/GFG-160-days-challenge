package practice;

import java.util.ArrayList;
import java.util.List;

public class gfgarray {
    public static int missing(int arr[]){
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

    public static int getSecondLargest(int[] arr) {
        // code here
        int largest = 0;
        int secondlarge = 0;
        //Arrays.sort(arr);
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

    public static void reverseArray(int arr[]){
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
        // for (int i=0;i<arr.length;i++){
        //     System.out.print(arr[i] + " ");
        // }
        int arr [] = {2,4,1,7,5,0,9};
        permutation(arr);
        for (int i=0;i<arr.length;i++){
             System.out.print(arr[i] + " ");
        }


    }
    
}
