public class DivideNConquer {

    public static void mergeSort(int arr[], int si, int ei) {

        // incase when we have si>ei this will be invalid case
        // and where si==ei we`ll return as the problem can not be further divided
        if (si >= ei) {
            return;
        }

        // each time we calculate mid and mergesort the left part and the
        // right part
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        // after getting the sorted part from above mergesorts we call the merge
        // fucntion and merge the sorted parts
        // into the original array
        merge(arr, si, mid, ei);

    }

    public static void merge(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {

            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;

            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // there can be case where elements are pending in the first or the second part

        while (i <= mid) {

            temp[k] = arr[i];
            k++;
            i++;

        }
        while (j <= ei) {

            temp[k] = arr[j];
            k++;
            j++;
        }

        // copy function

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];

        }
    }

    public static void quickSort(int arr[], int si, int ei) {

        if (si >= ei) {
            return;
        }

        int pivIndx = partition(arr, si, ei);
        quickSort(arr, si, pivIndx - 1);
        quickSort(arr, pivIndx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {

        int i = si - 1;
        int pivot = arr[ei];

        for (int j = si; j < ei; j++) {

            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        // last mein pivot element ko i++ kerke swap kardenge
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp; // ending index mein pivot tha

        return i;

    }

    public static int searchRotated(int arr[], int key, int si, int ei) {

        if (si > ei) {
            return -1;
        }

        int mid = (si + ei) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        // if mid lies on line one
        if (arr[si] <= arr[mid]) {

            if (key <= arr[mid] && key >= arr[si]) {
                return searchRotated(arr, key, si, mid - 1);
            }

            else {
                return searchRotated(arr, key, mid + 1, ei);
            }
        } else {

            if (key <= arr[mid] && key >= arr[si]) {
                return searchRotated(arr, key, si, mid - 1);
            } else {
                return searchRotated(arr, key, mid + 1, ei);
            }

        }

    }

    public static boolean isSmallerAlphabet(String st1, String st2) {

        boolean res = true;

        for (int i = 0; i < st1.length(); i++) {

            if (st1.charAt(i) == st2.charAt(i)) {
                continue;
            }
            if (st1.charAt(i) > st2.charAt(i)) {
                res = false;

            } else {
                res = true;

            }

            return res;
        }

        return res;

    }

    public static void mergesortString(String str[], int si, int ei) {

        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        mergesortString(str, si, mid);
        mergesortString(str, mid + 1, ei);
        mergeString(str, si, mid, ei);

    }

    public static void mergeString(String str[], int si, int mid, int ei) {

        String temp[] = new String[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {

            if (isSmallerAlphabet(str[i], str[j])) {
                temp[k] = str[i];
                i++;
            } else {
                temp[k] = str[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = str[i];
            k++;
            i++;
        }

        while (j <= ei) {
            temp[k] = str[j];
            k++;
            j++;

        }

        // copy back to the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            str[i] = temp[k];
        }

    }

    public static void main(String args[]) {

        // int arr[] = { 6, 3, 9, 5, 2, 8 };
        // quickSort(arr, 0, arr.length - 1);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // rotated array
        // int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        // int res = searchRotated(arr, 0, 0, arr.length);
        // System.out.println(res);

        String arr[] = { "sun", "earth", "mars", "mercury" };
        mergesortString(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
