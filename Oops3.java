public class Oops3 {
    
    public static void main(String args[]){

   //   Complex c1=new Complex(3, 2);
   //   Complex c2=new Complex(1, 4);
   //   Complex.product(c1,c2);

   Complex2 c1=new Complex2(3, 2);
   Complex2 c2=new Complex2(1, 4);

   Complex2 sum=c1.add(c2);
   System.out.println(sum);
     

    }
}

class Complex{

double real;
double imag;

 Complex(double real,double imag){
    this.real=real;
    this.imag=imag;
 }

 static void sum(Complex c1,Complex c2){

  System.out.println((c1.real+c2.real)+" + i"+(c1.imag+c2.imag));

 }

 static void difference(Complex c1,Complex c2){

    System.out.println((c1.real-c2.real)+" + i"+(c1.imag-c2.imag));
  
   }

 static void product(Complex c1,Complex c2){

    System.out.println((c1.real*c2.real)-(c1.imag*c2.imag)+" + i"
                      +((c1.real*c2.imag)+(c1.imag*c2.real)));
  
   }


}

//optimized class complex
class Complex2{

double real;
double imaginary;

Complex2(double real,double imaginary){
   this.real=real;
   this.imaginary=imaginary;
}

Complex2 add(Complex2 other){

double sumReal=this.real+other.real;
double sumImaginary=this.imaginary+other.imaginary;

//we using new keyword because we need to create a new object 
return  new Complex2(sumReal,sumImaginary);

}


@Override
   public String toString(){
   return this.real+" + "+this.imaginary+" i";
}
//senarios where to string method is called


}

 class person{

}
