public class test {

    public static void trackArray(int arr[], int i) {

        if (i == arr.length) {
            return;
        }

        arr[i] = i + 1;
        trackArray(arr, i + 1);
        // backtracking step
        arr[i] = arr[i] - 2;
    }

    public static void print(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {

        int arr[] = new int[5];
        trackArray(arr, 0);
        print(arr);
    }
}