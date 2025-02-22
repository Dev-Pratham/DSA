import java.util.Arrays;

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

        int i = 0;
        int j = 0;

        while (i < st1.length() && j < st2.length()) {

            if (st1.charAt(i) < st2.charAt(j)) {
                return true;
            } else if (st1.charAt(i) > st2.charAt(j)) {
                return false;
            }

            i++;
            j++;
        }

        if (i == st1.length()) {
            return true;
        } else {
            return false;
        }

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

    public static int absolute(int n) {

        if (n < 0) {
            return n * -1;
        }
        return n;
    }

    public static int returnMajority(int arr[]) {

        // has space complexity issue;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (largest < arr[i]) {
                largest = arr[i];
            }

            if (smallest > arr[i]) {
                smallest = arr[i];
            }

        }

        int freq[] = new int[largest + 1];
        int negFreq[] = new int[absolute(smallest) + 1];
        int bound = arr.length / 2;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {
                negFreq[arr[i] * -1]++;
            } else {
                freq[arr[i]]++;
            }
        }

        int count = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > bound) {
                count = i;
                break;
            }
        }

        for (int i = 0; i < negFreq.length; i++) {
            if (negFreq[i] > bound) {
                count = i * -1;
                break;
            }
        }
        return count;
    }

    public static int returnMajority2(int arr[]) {

        // has more time complexity
        int bound = arr.length / 2;

        for (int i = 0; i < arr.length; i++) {

            int count = 0;
            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > bound) {
                return arr[i];
            }
        }

        return -1;

    }

    public static int returnMajority3(int arr[]) {

        Arrays.sort(arr);

        int bound = arr.length / 2;
        int possiblemajority = arr[bound];

        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == possiblemajority) {
                count++;
            }
        }

        if (count > bound) {
            return possiblemajority;
        } else {
            return -1;
        }
    }

    public static int countInRange(int arr[], int majority, int si, int ei) {

        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] == majority) {
                count++;
            }
        }
        return count;

    }

    public static int returnMajority4(int arr[], int si, int ei) {

        if (si == ei) {
            return arr[si];
        }

        int mid = (si + ei) / 2;

        int leftMajority = returnMajority4(arr, si, mid);
        int rigthMajority = returnMajority4(arr, mid + 1, ei);

        if (leftMajority == rigthMajority) {
            return leftMajority;
        }

        int countLeftMajority = countInRange(arr, leftMajority, si, mid);
        int countRightMajority = countInRange(arr, rigthMajority, mid + 1, ei);

        return countLeftMajority > countRightMajority ? leftMajority : rigthMajority;
    }

    public static int countInversion(int arr[]) {

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int modifiedMerge(int arr[], int si, int mid, int ei) {

        int inversion = 0;

        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                inversion += (mid - i + 1);
                j++;
            }
            k++;

        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
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

        return inversion;

    }

    public static int countInversion2(int arr[], int si, int ei) {

        int invCount = 0;

        if (si < ei) {

            int mid = (si + ei) / 2;
            invCount = countInversion2(arr, si, mid);
            invCount += countInversion2(arr, mid + 1, ei);
            invCount += modifiedMerge(arr, si, mid, ei);

        }

        return invCount;

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

        // String arr[] = { "sun", "earth", "mars", "mercury" };
        // mergesortString(arr, 0, arr.length - 1);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // int arr[] = { 3, 2, 3 };
        // int res = returnMajority4(arr, 0, arr.length - 1);
        // System.out.println(res);

        // count inversion
        int arr[] = { 1, 3, 5, 10, 2, 6, 8, 9 };
        int res = countInversion2(arr, 0, arr.length - 1);
        System.out.println(res);

    }
}
