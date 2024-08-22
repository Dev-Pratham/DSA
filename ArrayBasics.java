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
int arr[]={2,4,6,8,10};
subarray(arr);




    }
}