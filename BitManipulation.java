public class BitManipulation{

public static void isEven(int n){

    if((n&1)==0){
        System.out.println("Even");
    }
    else{
        System.out.println("odd");
    }
}

public static void getIthBit(int n,int i){

    int bitmask=1<<i;

    if((n & bitmask)==0){
        System.out.println("0");
    }
    else{
        System.out.println("1");
    }

}

public static void setIthBit(int n,int i){

    int bitmask=1<<i;
    System.out.println((n | bitmask));
}

public static void clearIthBit(int n ,int i){

    int bitmask=1<<i;
    System.out.println((n ^ bitmask));
}

public static int clearIthBit2(int n,int i){

    int bitmask=~(1<<i);
    return (n & bitmask);
}

public static void updateIthBit(int n ,int i,int updateValue){

    if(updateValue==0){
        clearIthBit(n, i);
    }
    else{
        setIthBit(n, i);
    }
}

public static int updateIthBit2(int n,int i,int updateValue){

    int bitmask=updateValue<<i;
    n=clearIthBit2(n, i);

    return (n | bitmask);
}

public static int clearLastIthBit(int n,int i){

    int bitmask=~0<<i;

    return (n & bitmask);
    


}

public static int clearRangeOfBits(int n,int i,int j){


//preferred example 100111010011 i=2 to i=7 for simplicity
 int a=(~0)<<(j+1);
 int b=(1<<i)-1;

 int bitmask= a|b;

 return (n & bitmask);

}

public static boolean powerOf2(int n){

     int bitmask=1;

     return ((n & bitmask)!=1);
}
    

public static int countSetBits(int n){

    int count=0;
    int bitmask=1;

    while(n!=0){

        if((n & bitmask)==1){
            count++;
        }

        n=n>>1;
    }

    return count;
}

public static int fastExponentiation(int a,int n){

    
    int ans=1;

    while(n!=0){

        if((n&1)!=0){
          ans=ans*a;
        }
        else{
            ans=ans*1;
        }
       
       a=a*a;
       n=n>>1;
    }

    return ans;

    //simply in modular exponentiation return
    // ans with modulo expression

}

public static int fastModuloExpo(int a,int n,int m){

    //reference gfg

    int res=1;

    a=a%m;
    
    if(a==0){
        return 0;

    }
    while(n>0){

        if((n&1)!=0){
            res=(res*a)%m;
        }

        a=(a*a)%m;
        n=n>>1;

    }


return res;

}

public static void swap(int x,int y){

    //if x is small and y is large addition occurs
    //if opposite substraction occours
x=x^y;
y=x^y;
x=x^y;

    
}

public static int add1UsingBit(int n){

    return -~n;
}

public static void toUppercase(){

    for(char a='a';a<='z';a++){
        System.out.print((char)(a | ' '));
    }

    

}


    public static void main(String args[]){


        int n=3;
        // isEven(n);
        // getIthBit(n, 4);
        // setIthBit(n, 2);
        // clearIthBit2(n, 1);
        // updateIthBit(n, 3, 0);
        // System.out.println(clearLastIthBit(n, 2));
        // System.out.println(clearRangeOfBits(n, 2, 7));
        // System.out.println(powerOf2(n));
        // System.out.println(countSetBits(n));
        // System.out.println(fastExponentiation(n, 5));
        toUppercase();



        

    }
}