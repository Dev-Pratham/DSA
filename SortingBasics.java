import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
//code also contains questions of 2d arrays 
public class SortingBasics {
    
public static void printArr(int arr[]){

    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
}

public static void bubbleSort(int arr[]){


    for(int turns=0;turns<arr.length-1;turns++){

         for(int j=0;j<arr.length-1-turns;j++){

            //swap
            if(arr[j]>arr[j+1]){
                int temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
            }
         }
    }
     printArr(arr);

}

public static void selectionSort(int arr[]){


    for(int i=0;i<arr.length-1;i++){

        int smallest=i;
         for(int j=i+1;j<arr.length;j++){
              
            if(arr[smallest]>arr[j]){
                smallest=j;
            }
             
         }

         //swap
         int temp=arr[smallest];
         arr[smallest]=arr[i];
         arr[i]=temp;
         

    }
     printArr(arr);
}

public static void insertionSort(int arr[]){

    for(int i=1;i<arr.length;i++){

          int curr=arr[i];
          int prev=i-1;

          while(prev>=0 && curr<arr[prev]){
             
            arr[prev+1]=arr[prev];
            prev--;

          }
          arr[prev+1]=curr;

            
          }
           printArr(arr);
    }

    public static void countingSort(int arr[]){

        int length=100;
        int count[] = new int[length];
//created an count array
        for(int i=0;i<arr.length;i++){
              
             count[arr[i]]++;
        }

        int index=0;
        for(int j=0;j<length;j++){

              while(count[j]>0){
                  
                arr[index]=j;
                count[j]--;
                index++;
              }
        }

        printArr(arr);
//have too many exceptions cases 
//but if handled is much faster than previous sorting
// methods like bobble selection and insertion sorts
    }

    public static void input2dMatrix(int matrix[][]){

        Scanner sc= new Scanner(System.in);

        for(int i=0;i<matrix.length;i++){
    
             for(int j=0;j<matrix[0].length;j++){
    
                System.out.print("Enter value of : matrix["+i+"]"+"["+j+"] : ");
                matrix[i][j]=sc.nextInt();
             }
        }

    }

    
    
    public static void output2dMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Calculate maximum width for formatting
        int maxWidth = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                maxWidth = Math.max(maxWidth, String.valueOf(element).length());
            }
        }
        maxWidth = Math.max(maxWidth, 2); // Ensure indices fit

        // Print column indices
        System.out.print("    "); // Space for row indices
        for (int col = 0; col < cols; col++) {
            System.out.printf("%" + maxWidth + "s ", col);
        }
        System.out.println();

        // Create a horizontal border line
        System.out.print("   +");
        for (int i = 0; i < cols; i++) {
            System.out.print("-".repeat(maxWidth + 1) + "+");
        }
        System.out.println();

        // Print the matrix with row indices, borders, and padding
        for (int i = 0; i < rows; i++) {
            System.out.printf("%-2d |", i); // Row index
            for (int j = 0; j < cols; j++) {
                System.out.printf("%" + maxWidth + "d |", matrix[i][j]);
            }
            System.out.println();

            // Print border line after each row
            System.out.print("   +");
            for (int j = 0; j < cols; j++) {
                System.out.print("-".repeat(maxWidth + 1) + "+");
            }
            System.out.println();
        }
    }

    public static int search(int matrix[][],int key){

       int row=matrix.length;
       int col=matrix[0].length;

       for(int i=0;i<row;i++){

         for(int j=0;j<col;j++){

            if(matrix[i][j]==key){
                System.out.println("key found at index : "+i+" "+j);
            }
         }
       }


return -1;

    }

    



    public static void main(String args[]){

//    Integer arr[]={5,4,1,3,2};
//    Arrays.sort(arr,Collections.reverseOrder());

//2d array with 3 rows and 3 columns
     int matrix[][]=new int[3][3];

      input2dMatrix(matrix);
      search(matrix, 3);
      output2dMatrix(matrix);
    




         
    }
}
