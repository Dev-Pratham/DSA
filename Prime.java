import java.util.*;
public class Prime {
    

    public static boolean isPrime(int n){

    
        int div=2;

        if(n<=1){
            return false;
        }

        while(div<=Math.sqrt(n)){

           if(n%div==0){
            return false;
           }
           div++;

        }
        return true;
    }
    public static void main(String args[]){

     Scanner sc=new Scanner(System.in);

     System.out.print("ENTER NUMBER TO BE CHECKED: ");
     int n=sc.nextInt();
     sc.close();
     boolean res=isPrime(n);
     System.out.println(res);


    }
}
