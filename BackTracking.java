public class BackTracking {

    public static void backTracking1(int arr[], int i) {

        if (i == arr.length) {
            System.out.print("Base case array : ");
            print(arr);
            System.out.println();
            System.out.print("Backtracked : ");
            return;
        }
        arr[i] = i + 1;
        backTracking1(arr, i + 1);
        arr[i] = arr[i] - 2;

    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String args[]) {

        int arr[] = new int[10];
        backTracking1(arr, 0);
        print(arr);

    }
}