public class test {

    public static String getCurrentString(char number) {
        char ch = number;
        String str = "";

        switch (ch) {
            case '2':
                str = "abc";

                break;
            case '3':
                str = "def";

                break;
            case '4':
                str = "hij";

                break;
            case '5':
                str = "klm";

                break;
            case '6':
                str = "nop";

                break;
            case '7':
                str = "qrs";

                break;
            case '8':
                str = "tuv";

                break;
            case '9':
                str = "wxyz";

                break;

            default:
                break;
        }

        return str;
    }

    public static String getinputString(String number) {

        String str = "";

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            str = str + getCurrentString(ch);
        }

        return str;

    }

    public static int getDigitLength(String str) {
        return str.length();
    }

    public static void printString(String str) {

        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");

        }

    }

    public static void printPermutation(String str) {

        String input = getinputString(str);
        printString(input);
    }

    public static void main(String args[]) {

        String digit = "23";
        printPermutation(digit);

    }
}