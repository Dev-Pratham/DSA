import java.util.*;
public class JavaBasics2 {
    
    //This function has no return type and no input parameters
    public static void printHello(){

        System.out.println("HelloWorld!");
        return;
    }

    public static int calculateSum(int a,int b){// formal parameters or parameters

        return a+b;
    }

    public static int product(int a,int b){
        return a*b;
    }

    public static int factorial(int n){

        int fact=1;
        while(n>1){
            fact*=n;
            n--;
        }

        return fact;

    }

    public static int factorial2(int n){

        int fact=1;
        for(int i=2;i<=n;i++){
            fact*=i;
        }
        return fact;
    }

    public static int binomialCofficient(int n,int r){//parameters or formal parameter

        return factorial(n)/(factorial(n-r)*factorial(r));

    }

    //function overloading 
    //function with same name but with different parameter
    //depends on type and number of parameter but not with the
    //return type of function

    // public static int sum(int a,int b){
    //     return a+b;
    // }

    // public static float sum(float a,float b){

    //     return a+b;
    // }

    public static boolean isPrime(int n){

        if(n<2){
            return false;
        }

        boolean isPrime=true;
        int div=2;

        while(div<=Math.sqrt(n)){  //we have optimized code and reduced
                                   //its time and space complexity

            if(n%div==0){
                isPrime=false;
                break;
            }
            div++;
        }

        return isPrime;
    }

    public static boolean isPrime2(int n){

        if(n<2){
            return false;
        }

        boolean isprime=true;
        for(int div=2;div<=Math.sqrt(n);div++){

            if(n%div==0){
                isprime=false;
                break;
            }
        }

        return isprime;
    }

    public static void printPrime(int a,int b){

        int count=0;
        for(int i=a;i<=b;i++){

            if(isPrime(i)==true){
                System.out.println(i);
                count++;
            }
            
        }
        System.out.println("Total no of prime number:"+count);
    }

    public static int pow(int a,int b){

    int pow=1;

    while(b>0){
         
        pow=pow*a;
        b--;
    }

    return pow;


    }

    public static void b2d(int n){

        int pow=0;
        int sum=0;
        while(n>0){
          
            int lastdigit=n%10;
            sum=sum+(lastdigit*pow(2,pow));
            pow++;
            n/=10;

        }
        System.out.println(sum);
    }

    public static void d2b(int n){

        int pow=0;
        double dec=0;
        while(n>0){

            int mod=n%2;
            dec=dec+(mod*Math.pow(10,pow));
            pow++;
            n/=2;

        }
        
        System.out.println(dec);

    }

    public static int avg(int a ,int b, int c){

        return (a+b+c)/3;
    }

    public static boolean isEven(int n){

        if(n%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    public static int reverse(int n){

       int rev=0;
       while(n>0){
         int lastdigit=n%10;
         rev=(rev*10)+lastdigit;
         n/=10;
       }
              
          return rev;
    }
    public static boolean isPalindrome(int n){

      
        if(n==reverse(n)){
            return true;
        }

        return false;

    }

    public static int  sumOfDigits(int n){


        int sum=0;

        while(n>0){
            int lastdigit=n%10;
            sum+=lastdigit;
            n/=10;
        }

        return sum;

    }

    public static void hollowRectangle(int n){


         for(int i=1;i<=n;i++){

             for(int j=1;j<=n;j++){
                   
                 if(j==1 || j==n || i==1 || i==n){
                    System.out.print("* ");
                 }
                 else{
                    System.out.print("  ");
                 }
             }
             System.out.println();
         }


    }

    public static void invertedTriangle(int n){


        for(int i=1;i<=n;i++){

             for(int j=1;j<=n;j++){

                 if((i+j)>n){
                    System.out.print("* ");
                 }
                 else{
                    System.out.print("  ");
                 }
             }

             System.out.println();
        }
    }

    public static void invertedHalfPyramid(int n){


        for(int i=1;i<=n;i++){
             
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void floydsTriangle(int n){


         int itr=1;

         for(int i=1;i<=n;i++){

             for(int j=1;j<=i;j++){

                 System.out.print(itr+" ");
                 itr++;
                 
             }
             System.out.println();
         }

    }

    public static void triangle(int n){

        for(int i=1;i<=n;i++){

             for(int j=1;j<=i;j++){
                 
                if((i+j)%2==0){
                    System.out.print(1+" ");
                }
                else{
                    System.out.print(0+" ");
                }
             }
             System.out.println();
        }
    }

    public static void butterfly(int n){


        if(n%2!=0){
            n+=1;
        }

        int half=n/2;
        //butterfly first half

        for(int i=1;i<=half;i++){

            for(int j=1;j<=i;j++){

                 System.out.print("* ");
                  
            }

            for(int k=1;k<=n-2*i;k++){

                System.out.print("  ");
            }

            for(int l=1;l<=i;l++){

                System.out.print("* ");
            }

            System.out.println();
        }

        //butterfly 2nd half
        for(int i=1;i<=half;i++){

            for(int j=1;j<=half-i+1;j++){

                 System.out.print("* ");
                  
            }

            for(int k=1;k<=2*i-2;k++){

                System.out.print("  ");
            }

            for(int l=1;l<=half-i+1;l++){

                System.out.print("* ");
            }

            System.out.println();
        }

    }

    public static void solidRhombus(int n){

 
         for(int i=1;i<=n;i++){
              
             for(int j=1;j<=n-i;j++){

                System.out.print("  ");
             }

             for(int k=1;k<=n;k++){
                System.out.print("* ");
             }

             System.out.println();
         }

    }

    public static void hollowSolidRhombus(int n){


        for(int i=1;i<=n;i++){
              
            for(int j=1;j<=n-i;j++){

               System.out.print("  ");
            }

            for(int k=1;k<=n;k++){

                if((i==1 || i==n) || (k==1 || k==n)){
                      System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }

            }

            System.out.println();
        }


    }

    public static void diamond(int n){

        if(n%2!=0){
            n+=1;
        }

        int half=n/2;

        for(int i=1;i<=half;i++){

            for(int j=1;j<=half-i;j++){
                System.out.print("  ");
            }

            for(int k=1;k<=2*i-1;k++){
                System.out.print("* ");
            }

            System.out.println();
        }
       //for other half of diamond
        for(int i=1;i<=half;i++){
            
        
            for(int j=1;j<=i-1;j++){

                System.out.print("  ");
            }


            for(int k=1;k<=n+1-2*i;k++){
                System.out.print("* ");
            }

            System.out.println();

        }
    }
    public static void main(String args[]){


        Scanner sc=new Scanner(System.in);
        // printHello(); //function call


        //to calculate sum of 2 numebers using function
        //  Scanner sc=new Scanner(System.in);
        //  System.out.print("Enter a and b:");
        //  int a=sc.nextInt();
        //  int b=sc.nextInt();
        //  sc.close();
        //  System.out.println(calculateSum(a, b));     // actual parameters or arguements

        //java always passes parameter by call by value 
        //to find product 
        // int a=10;
        // int b=5;
        // System.out.println(product(a, b));

        //factorial
        // int n=4;
        // System.out.println(factorial2(n));

        //binomial cofficient
        // int n=5;
        // int r=2;

        // int nCr=binomialCofficient(n, r);
        // System.out.println(nCr);

        // int n=2;
        // boolean res=isPrime2(n);
        // System.out.println(res);

        //prime in range
        // int a=100;
        // int b=1000;
        // printPrime(a, b);

        //binary to decimal

        // int n=111;
        // b2d(n);

        //decimal to binary
        // int n=2;
        // d2b(n);

        //This is the sample question from the course
        //to compute avegage of 3 numbers
        // int a,b,c;
        // a=10;
        // b=20;
        // c=30;

        // int avg=avg(a, b, c);
        // System.out.println("The average is :"+avg);

        //func to check whether a number is odd or even
        // int n=-10;
        // System.out.println(isEven(n));
       

        //func to check whether a number is palimdrome
        //simply we reverse a number then compare the 2 numbers if 2 numbers are same
        // then it is palimdrome or else it not as it`s simple

        // System.out.print("Enter number to compare:");
        // int n=sc.nextInt();
        // sc.close();
        // System.out.print(isPalindrome(n));


        //write a method to compute the sum of digits is an integer

        //pattern to print hollow rectamgle
        // hollowRectangle(10);

        // //pattern to print inverted and rotated half pyramid
        // invertedTriangle(10);

        //inverted half pyramid with numbers 
        // invertedHalfPyramid(5);

        //floyd`s triangle
        // floydsTriangle(5);

        //0-1 triangle
        // triangle(10);

        //butterfly
        // butterfly(7);

       //solidrhombus
    //    solidRhombus(5);


    //hollow solid rhoumbus
    // hollowSolidRhombus(25);

    //diamond
    diamond(11);
    }
}
