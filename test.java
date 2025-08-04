public class test {

    public static String getCurrentString(char number) {
        switch (number) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    public static void generateCombinations(String digits, int index, String current) {
        if (index == digits.length()) {
            System.out.println(current);
            return;
        }

        String mappedStr = getCurrentString(digits.charAt(index));

        for (int i = 0; i < mappedStr.length(); i++) {
            generateCombinations(digits, index + 1, current + mappedStr.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        if (digits.isEmpty()) {
            System.out.println("No combinations possible.");
        } else {
            generateCombinations(digits, 0, "");
        }
    }
}
