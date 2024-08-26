import java.util.Arrays;

public class ArrayBasics {
    
    public static void update(int marks[]){

        for(int i=0;i<marks.length;i++){
            marks[i]+=1;
        }
    }
  
     public static int linearSearch(int marks[],int key){

          for(int i=0;i<marks.length;i++){

            if(marks[i]==key){
                return i;
            }
          }
            
          return -1;
     }

     public static int linearSearch(String marks[],String key){


        for(int i=0;i<marks.length;i++){

            if(marks[i]==key){
                return i;
            }
        }
            return -1;

     }

     public static int largest(int arr[]){

        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){

            if(largest<arr[i]){
                largest=arr[i];
            }

            if(smallest>arr[i]){
                smallest=arr[i];
            }
        }
        System.out.println("Smallest value:"+smallest);
        return largest;

     }

     public static int binarySearch(int arr[],int key){

        //works only on sorted array
        int start=0;
        int end=arr.length-1;

        while(start<=end){

          int mid=(start+end)/2;

          if(arr[mid]==key){
            return mid;
          }

          else if(arr[mid]<key){
            start=mid+1;
          }

          else{
            end=mid-1;
          }

        }

        return -1;

     }

     public static void reverse(int arr[]){


         int start=0;
         int end=arr.length-1;

         while(start<end){

            int temp=arr[end];
            arr[end]=arr[start];
            arr[start]=temp;

            start++;
            end--;

         }

     }

     public static void pairs(int arr[]){

        for(int i=0;i<arr.length-1;i++){

            for(int j=i+1;j<arr.length;j++){

                System.out.print("("+arr[i]+","+arr[j]+"), ");
            }
            System.out.println();
        }
     }

     public static void subarray(int arr[]){

         for(int i=0;i<arr.length;i++){

             for(int j=i;j<arr.length;j++){

                 for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                 }
                 
             }

             System.out.println();
         }

     }

     public static int maxSubarr(int arr[]){


        int largest=Integer.MIN_VALUE;
          for(int i=0;i<arr.length;i++){

              for(int j=i;j<arr.length;j++){

                  int sum=0;
                  for(int k=i;k<=j;k++){
                   
                     sum+=arr[k];

                  }

                  if(largest<=sum){
                    largest=sum;
                  }
              }
          }



          return largest;

     }

    
     public static int prefixMaxSubarry(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        // Calculate the prefix sum array
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int smallest = prefix[0];

        // Find the minimum subarray sum using the prefix sum array
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) { 
                int prefixSum;
                if (i == 0) {
                    prefixSum = prefix[j]; // No need to subtract when i is 0
                } else {
                    prefixSum = prefix[j] - prefix[i - 1];
                }
                if (smallest > prefixSum) { // Check for the smallest sum
                    smallest = prefixSum;
                }
            }
        }

        return smallest;
    }
    

    public static boolean isNegative(int arr[]){

//bottleneck case when kadanes has all negative numbers

         for(int i=0;i<arr.length;i++){

            if(arr[i]>0){
                return false;
            }
         }
        return true;
    }

    public static int kadanesAlgo(int arr[]){
//current sum jaise hi negative hoga 
//usko zero kerna hai and max currentsum
//nikalna hain
int currentsum=0;
int maxsum=Integer.MIN_VALUE;

  if(isNegative(arr)){

    for(int i=0;i<arr.length;i++){

        if(maxsum<arr[i]){
            maxsum=arr[i];
        }

    }
}

  else{

     for(int i=0;i<arr.length;i++){

    currentsum+=arr[i];

    if(currentsum<0){
     currentsum=0;
    }

    if(maxsum<currentsum){
        maxsum=currentsum;
    }
}
}

    return maxsum;

    }

    public static int min(int a,int b){

        if(a<b){
            return a;
        }

        return b;
    }

    public static int trappingRainwater(int arr[]){

         int auxleft[]=new int[arr.length];
         int aurright[]=new int[arr.length];

         int largest=Integer.MIN_VALUE;

         int totalTrappedWater=0;
         int width=1;

         for(int i=0;i<auxleft.length;i++){

            if(largest<arr[i]){
                largest=arr[i];
            }

            auxleft[i]=largest;
         }

         largest=Integer.MIN_VALUE;

         for(int i=aurright.length-1;i>=0;i--){

            if(largest<arr[i]){
                largest=arr[i];
            }

            aurright[i]=largest;
         }

         for(int j=1;j<arr.length-1;j++){
            //area of trapped water with bar height
            int trappedWater=min(aurright[j],auxleft[j])*width;
            int acutalWater=trappedWater-arr[j];

            totalTrappedWater+=acutalWater;
         }

        return totalTrappedWater;
    }

    public static int sellStocks(int arr[]){

        int profit;
        int maxprofit=0;
        
       for(int i=0;i<arr.length-1;i++){
         int maxsell=Integer.MIN_VALUE;
         profit=0;
        for(int j=i+1;j<arr.length;j++){
            
              if(maxsell<arr[j]){
                maxsell=arr[j];
              }
        }

        if(arr[i]<maxsell){
            profit=maxsell-arr[i];
        }

        if(maxprofit<profit){
            maxprofit=profit;
        }


       }

       return maxprofit;

    }

    public static int sellStocksOptimized(int arr[]){

        int buy=arr[0];
        int maxprofit=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            int profit=0;
            int curr=arr[i];

            if(curr<buy){
                buy=curr;
            }
            else{
               profit=curr-buy;
            }

            if(maxprofit<profit){
                maxprofit=profit;;
            }
        }

        return maxprofit;
    }

    public static boolean duplicateArray(int arr[]){

        for(int i=0;i<arr.length-1;i++){

            for(int j=i+1;j<arr.length;j++){
                  
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }

        return false;
    }

    public static int binarySearchModified(int arr[],int key){

       int start=0;
       int end=arr.length-1;

       while(start<=end){

        int mid=(start+end)/2;

        if(arr[mid]==key){
            return mid;
        }

     
//checks whether first half is sorted
       if(arr[start]<arr[mid]){
             
         if(arr[start]<=key && key<arr[mid]){
            end=mid-1;
         }
         else{
            start=mid+1;
         }
               
       }
       else{
        if(arr[mid]<key && key<=arr[end]){
             
            start=mid+1;
        }
        else{
            end=mid-1;
        }
       }
       

       }

       return -1;

    }

    public static boolean isDuplicate(int arr[],int index){


        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[index]){
                return true;
            }
        }

        return false;

    }

    public static void duplicateTriplets(int nums[]) {
            // Sort the array to handle duplicates and make it easier to avoid them
            Arrays.sort(nums);

            int n = nums.length;
            for (int i = 0; i < n - 2; i++) {
                // Skip the same element to avoid duplicates
                if (i > 0 && nums[i] == nums[i - 1]) continue;
    
                for (int j = i + 1; j < n - 1; j++) {
                    // Skip the same element to avoid duplicates
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
    
                    for (int k = j + 1; k < n; k++) {
                        // Skip the same element to avoid duplicates
                        if (k > j + 1 && nums[k] == nums[k - 1]) continue;
    
                        // Check if the triplet sums to zero
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            System.out.println("Triplet found: [" + nums[i] + ", " + nums[j] + ", " + nums[k] + "]");
                        }
                    }
                }
            }
        }


    



   public static void main(String args[]){


        //initializing an array
//   int marks[]= new int[50];
//   System.out.println(marks[0]);


//   int marks[]={98,99,100};
// update(marks);

// System.out.println(marks[0]);

// //linear search
// int marlks[]={98,99,89,98,67,88,90};
// int key=90;
// System.out.println(linearSearch(marlks, key));

// String menu[]={"samosa","daal","idli","dosa"};
// String key="dosa";
// System.out.println(linearSearch(menu, key));

//largest fo 2 numbers in an array

// int marks[]={1,2,34,5,6,3,4,2,9,6,10};

// System.out.println(largest(marks));


//binary search
// int marks[]={2,4,6,8,10,12,14};
// int key=10;
// System.out.println(binarySearch(marks, key));

//void reverse
//  int marks[]={2,4,6,8,10,12,14};
//  reverse(marks);


//pairs in an array
// int arr[]={2,4,6,8,10};
// pairs(arr);


//subarray
// int arr[]={2,4,6,8,10};
// subarray(arr);


//max subarray(bruteforce)
// int arr[]={2,4,6,8,10};
// System.out.print(maxSubarr(arr));

//max subarray(prefixsum)
// int arr[]={1,2,-8,4};
// System.out.println(prefixMaxSubarry(arr));

//kadanes algo
// int arr[]={-2,-3,4,-1,-2,1,5,-3};
// System.out.println(kadanesAlgo(arr));

// modified kadanes algo to handle -ve num
// int arr[]={-1,-2,-3,-4};
// System.out.println(kadanesAlgo(arr));

//trapping rainwater code
// int height[]={4,2,0,6,3,2,5};
// System.out.println(trappingRainwater(height));

//buy and sell stocks
// int prices[]={7,1,5,3,6,4};
// System.out.println(sellStocksOptimized(prices));


//to find duplicate array
// int arr[]={1,2,3,4,5,6,7,8,9,11,12,13,14,15,2};
// System.out.println(duplicateArray(arr));


//pivoted binary search
// int pivotedarr[]={4,5,6,7,0,1,2};
// int key=0;
// System.out.println(binarySearchModified(pivotedarr, key));

//duplicate triplets
int arr[]={-1,0,1,2,-1};
duplicateTriplets(arr);

System.out.println(arr[0]==arr[-1]);
    }
}