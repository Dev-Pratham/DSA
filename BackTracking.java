public class BackTracking {

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void arrBackTrack(int arr[], int i) {

        if (i == arr.length) {
            return;
        }
        arr[i] = i + 1;
        arrBackTrack(arr, i + 1);
        arr[i] = arr[i] - 2;
    }

    public static void findSubset(String str, String ans, int level) {

        if (level == str.length()) {

            if (ans.length() == 0) {
                System.out.println("Null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // decision of each character
        // if yes
        findSubset(str, ans + str.charAt(level), level + 1);
        // if no leave it as it is
        findSubset(str, ans, level + 1);

    }

    public static void permutation(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutation(newStr, ans + current);
        }

    }

    public static void main(String args[]) {

        String str = "abc";
        // findSubset(str, "", 0);
        permutation(str, "");

    }
}