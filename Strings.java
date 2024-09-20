public class Strings {
    


    public static boolean isPalindrome(String str){

        int start=0;
        int end=str.length()-1;

        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindrome2(String str){

        int lenght=str.length();

        for(int i=0;i<lenght/2;i++){
            if(str.charAt(i)!=str.charAt(lenght-1-i)){
                return false;
            }
        }
        return true;
    }

    public static Double shortestPath(String str){
  
        int n=str.length();
        int x=0,y=0;

        for(int i=0;i<n;i++){
            
             switch(str.charAt(i)){
                    
                case 'W':x--;
                break;

                case 'N':y++;
                break;

                case 'E':x++;
                break;

                case 'S':y--;
                break;
            }
        }
        double xDisplacement=Math.pow(x, 2);
        double yDisplacement=Math.pow(y, 2);
        double sum=xDisplacement+yDisplacement;

        return Math.sqrt(sum);
    }

    public static void subString(String str,int si,int ei){


        for(int i=si;i<ei;i++){
            System.out.print(str.charAt(i)+" ");
        }
           return;
    }

    public static String largestString(String str[]){

    String largest=str[0];

    for(int i=1;i<str.length;i++){
//.compare to method compares to strings lexicographically
//aaba aabd here string 1 is smaller than string 2
//comparetoignorecase ignores case sensitivity
//time complexity o(x*n)
        if(largest.compareTo(str[i])<0){
            largest=str[i];
        }
    }

    return largest;

    }

    public static String toUpperCase(String name){

     StringBuilder sb = new StringBuilder("");

     char ch=name.toUpperCase().charAt(0);
     sb.append(ch);
     

     for(int i=1;i<name.length();i++){

        if(name.charAt(i)!=' '){
            
            sb.append(name.charAt(i));
             
        }
        else{
            sb.append(name.charAt(i));   

            if(i!=name.length()-1){
            i++;
            ch=name.toUpperCase().charAt(i);
            sb.append(ch);
            }
            
        }
        
     }

     return sb.toString();


    }

    public static String toUpperCase2(String str) {
        StringBuilder sb = new StringBuilder("");
    
        // Convert first character to uppercase if it's not a space
        if (str.length() > 0 && str.charAt(0) != ' ') {
            sb.append(Character.toUpperCase(str.charAt(0)));
        }
    
        // Loop through the string starting from the second character
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == ' ' && str.charAt(i) != ' ') {
                // Convert the character after a space to uppercase
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                // Append the character as it is
                sb.append(str.charAt(i));
            }
        }
    
        return sb.toString();
    }
    

    public static String toUpperCase3(String name) {
//chatgpt complex code
        StringBuilder sb = new StringBuilder();
    
        // Convert first character to uppercase
        char ch = Character.toUpperCase(name.charAt(0));
        sb.append(ch);
    
        // Traverse through the rest of the string
        for (int i = 1; i < name.length(); i++) {
    
            if (name.charAt(i) == ' ') {
                // Append the space
                sb.append(name.charAt(i));
    
                // Check if the next character is valid and convert it to uppercase
                if (i + 1 < name.length()) {
                    ch = Character.toUpperCase(name.charAt(i + 1));
                    sb.append(ch);
                    i++; // Skip the next character as it's already processed
                }
            } else {
                // Append other characters without changing their case
                sb.append(name.charAt(i));
            }
        }
    
        return sb.toString();
    }

    public static String toUpperCase4(String name) {
//chatgpt complex code
        if (name == null || name.isEmpty()) {
            return name; // handle empty or null strings
        }
    
        StringBuilder sb = new StringBuilder();
    
        // Skip leading spaces
        int i = 0;
        while (i < name.length() && name.charAt(i) == ' ') {
            sb.append(' ');
            i++;
        }
    
        // Convert the first character to uppercase if it's a letter
        if (i < name.length()) {
            char ch = Character.toUpperCase(name.charAt(i));
            sb.append(ch);
            i++;
        }
    
        // Traverse through the rest of the string
        for (; i < name.length(); i++) {
    
            if (name.charAt(i) == ' ') {
                // Append the space
                sb.append(' ');
    
                // Check if the next character is valid and convert it to uppercase
                if (i + 1 < name.length() && name.charAt(i + 1) != ' ') {
                    char ch = Character.toUpperCase(name.charAt(i + 1));
                    sb.append(ch);
                    i++; // Skip the next character as it's already processed
                }
            } else {
                // Append other characters without changing their case
                sb.append(name.charAt(i));
            }
        }
    
        return sb.toString();
    }
    

    public static void stringCompression(String str){

        StringBuilder st=new StringBuilder("");
        
        for(int i=0;i<str.length() ;i++){
        
            Integer count=1;
            while( i<str.length()-1 && str.charAt(i)==str.charAt(i+1) ){
        
            count++;
            i++;
            }

            st.append(str.charAt(i));

            if(count>1){
                
                st.append(count.toString());
            }
            
                // sb.append(str.charAt(i));
                 }

           System.out.println(st);
    }
    


    public static void main(String args[]){


     //string is palindrome
    //  String str="noon";
    //  System.out.println(isPalindrome2(str));

//shortest distance directionwise
    // String str="WNEENESENNN";
    // System.out.println(shortestPath(str));

    //printsubstring
    // String name="pratham";
    // subString(name, 0, 6);

    //print largest string 
    // String str[]={"apple","mango","banana"};
    // System.out.println(largestString(str));

    //convert each of the first letter of word
    //to upper case
    // String word="pratham  chauraisa"; 
    // System.out.println(toUpperCase(word));

    //string compression
    String str="aaabbcccdddd";
stringCompression(str);

  
    }
}
        