//class name should be same as file name
import java.util.*;
public class JavaBasics{


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
/* 
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println(name);
        */

     /*    
      System.out.print("Enter a and b:");
      int a=sc.nextInt();
      int b=sc.nextInt();
      sc.close();
      int sum=a+b;
      System.out.println("sum of "+a+" and "+b+" is:"+sum);
*/


    // int rad=sc.nextInt();
    // float area=3.14f*rad*rad;
    // System.out.println(area);
    
/* 
    float a=sc.nextFloat();
    float b=sc.nextFloat();

    float c=sc.nextFloat();

    float tax=0.18f*(a+b+c);
    System.out.println(tax+(a+b+c));
*/
/* 
    int n=sc.nextInt();

    if(n%2==0){
        System.out.println("even");
    }
    else{
        System.out.println("odd");
    }
    */

    /* 
    int age=18;
    if(age>=18){
        System.out.println("adult");
    }
    else if(age==18){
        System.out.println("child");
    }
    else{
    System.out.print("teenager");
}
*/

/* 
int income=sc.nextInt();
int tax;

if(income<500000){
    tax=0;
}
else if(income>=500000 && income<1000000){
    tax=(int)(income*0.2f);
}
else{
    tax=(int)(income*0.3f);
}

System.out.println("Your tax is "+tax);
*/

/* 
//to find greatest of 3 numbers
int a,b,c;
a=1;
b=81;
c=3;

if(a>=b && a>=c){
    System.out.print(a);
}
else if(b>=c){
    System.out.print(b);
}
else{
    System.out.print(c);
}
*/


// int marks=33;

// String res=(marks>=33)?"Pass":"Fail";
// System.out.println(res);


/* 
int number=3;

switch(number){

    case 1:System.out.println("samosa");
    break;
    case 2:System.out.println("burger");
    break;
    default:System.out.println("we were dreaming");
}
*/

//calculator using switch

// System.out.print("Enter value of a:");
// int a=sc.nextInt();
// System.out.print("Enter value of b:");
// int b=sc.nextInt();
// System.out.print("Enter operation to be performed:");

// char operator=sc.next().charAt(0);

// switch(operator){

//     case '+':System.out.println(a+b);
//     break;
//     case '-':System.out.println(a-b);
//     break;
//     case '/':System.out.println(a/b);
//     break;
//     case '%':System.out.println(a%b);
//     break;
//     default:System.out.println("still under beta version");
// }

// int num =sc.nextInt();
// String res=(num>0)?"positive":"negative";
// System.out.println(res);

// double temp=50;
// if(temp>100){
//     System.out.print("you have a fewer");
// }
// else{
//     System.out.print("you dont have fever");
// }


// System.out.print("Enter week day:");
// int wday=sc.nextInt();
// switch(wday){
// case 1:System.out.println("monday");
// break;

// case 2:System.out.println("tuesday");
// break;

// case 3:System.out.println("wednesday");
// break;

// case 4:System.out.println("thursday");
// break;

// case 5:System.out.println("friday");
// break;

// case 6:System.out.println("saturday");
// break;

// case 7:System.out.println("sunday");
// break;

// default:System.out.println("enter 1-7 only");

// }


//leap year
// System.out.print("Enter year:");
// int y=sc.nextInt();

// if( (y%4==0 && y%100!=0) || y%400==0){
//     System.out.print("Leap year");
// }
// else{
//     System.out.print("not a leap");
// }


// int cntr=1;
// while(cntr<=10){
//     System.out.println(cntr);
//     cntr++;
// }


// int count=1;
// System.out.print("ENTER NUMBERS TO BE PRINT:");
// int n=sc.nextInt();
// while(count<=n){
//     System.out.print(count+" ");
//     count++;
// }



// //to print sum of n natural numbers
// int n=sc.nextInt();
// int sum=0;
// while(n>0){
//     sum+=n;
//     n--;
// }
// System.out.println(sum);

// int line=0;
// // printing pattern problem
// while(line<4){
//     System.out.println("****");
//     line++;
// }

//printing reverse of a number 1234

// int n=20020730;

// while(n>0){
//     //where x gives last digit
//     int x=n%10;
//     System.out.print(x);
//     n/=10;
// }

//print the reverse of original number


// int n=1089;
// int rev=0;

// while(n>0){
//     int lastdigit=n%10;
//     rev=(rev*10)+lastdigit;
//     n/=10;
// }
// System.out.println(rev);


// int counter=1;
// do{
//     System.out.println("Hello world");
//     counter++;
// }while(counter<=10);


//print numbers until user enters multiple of 10
// while(true){
    
//     System.out.print("Enter number:");
//     int n=sc.nextInt();
//     if(n%10==0){
//         break;
//     }
//     System.out.println(n);
// }
// System.out.println("Entered multiple of 10");

//example of continue
// for(int i=0;i<5;i++){

//     if(i==3){
//         continue;
//     }
//     System.out.println(i);
// }

//display all numbers entered by user expect multiple of 10

// while(true){

//     System.out.print("Enter numebr");
// int n=sc.nextInt();
// if(n%10==0){
//     continue;
// }
// System.out.println(n);

// }


//check if a number is prime or not
//straight forward implementation
// System.out.print("Enter number:");
// int n=sc.nextInt();
// int div=2;
// if(n<=1){
//     System.out.print("Not Prime");
    
    
// }
// while(div<n){

//     if(n%div==0){
//         System.out.println("Not prime");
    
//         break;
//     }
//     else{
//         div++;
//     }
// }
// if(div==n){
//     System.out.print("Prime");
    
// }


//more logical approach
// System.out.print("Enter number:");
// int n=sc.nextInt();
// boolean isPrime=true;

// if(n<=1){
//     isPrime=false;
// }
// else{

//     for(int i=2;i<=Math.sqrt(n);i++){
//         if(n%i==0){
//             isPrime=false;
//             break;
//         }
//     }
// }

// if(isPrime){
//     System.out.print("prime");
// }
// else{
//     System.out.print("Not prime");
// }

// Write a program that reads a set of integers, and then prints the sum of the
//even and odd integers.

// System.out.print("Enter a and b:");
// int a=sc.nextInt();
// int b=sc.nextInt();
// int oddSum,evenSum;
// oddSum=evenSum=0;
// for(int i=a;i<=b;i++){
//     if(i%2==0){
//         evenSum+=i;
//     }
//     else{
//         oddSum+=i;
//     }
// }
// System.out.println("oddsum:"+oddSum);
// System.out.println("evensum:"+evenSum);


 //factorial
// int n=sc.nextInt();
// int fact=1;
// if(n==0){
//     fact=1;
// }
// else{
//     for(int i=n;i>1;i--){
//         fact*=i;
//     }
// }

// System.out.println(fact);


//printing multiplication table
// System.out.print("ENTER table to be calculated:");
// int n=sc.nextInt();

// for(int i=1;i<=10;i++){
//     System.out.println(n+"*"+i+"="+i*n);
// }

//pattern code
// for(int i=1;i<=8;i++){

//      for(int j=1;j<=i;j++){
//         System.out.print("*");
//      }
//      System.out.println();
// }



// for(int i=1;i<=4;i++){

//     for(int j=i;j<=4;j++){
//         //  **for(int j=1;j<=n-i+1;j++)  above for loop
//         //can also be replaced 
//         System.out.print("*");
//     }
//     System.out.println();  
// }



for(int i=1;i<=4;i++){

     for(int j=1;j<=i;j++){
        System.out.print(j);
     }
     System.out.println();
}

// char letter='A';
// for(int i=1;i<=6;i++){

//      for(int j=1;j<=i;j++,letter++){
//        System.out.print(letter);
//      }
//      System.out.println();
// }

// int n=sc.nextInt();
// int fact=1;
// for(int i=2;i<=n;i++){
//     fact*=i;
// }
// System.out.println(fact);


//revision completed on 23/06/2024
//sunday
    }}

