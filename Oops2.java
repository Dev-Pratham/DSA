//
public class Oops2 {
    
    public static void main(String args[]){

        Chicken c1=new Chicken();
        // c1.changeColor();
        System.out.println(c1.color);

        Beer b1=new Beer();
        System.out.println(Beer.isCarnivorous);

        Horse2 h2=new Horse2();
        System.out.println(h2.color);

    }
}

//animal is an example of abstract class
abstract class Animal{

    String color;
//using the constructor inside abstract class 
//to initialize the child with the variable

//constructor of parent is always called first no 
//matter what
    Animal(){
        color="brown";
    }

    void eats(){
        System.out.println("Animal eats");
    }
 
    abstract void walk();

}

class Horse extends Animal{

    void walk(){
        System.out.println("Horse walks on 4 legs");   
    }
    
    //now we can change color as color is initialized by constructor
    void changeColor(){
        color="dark brown";
    }
}

class Chicken extends Animal{

    void walk(){
        System.out.println("Chicken walks on 2 legs");
    }

    void changeColor(){
        color="light brown";
    }
}
//chess player is an example of total abstraction
interface ChessPlayer{
//total abstraction
//multiple inheritance
void moves();

}

class Queen implements ChessPlayer{

    public void moves(){  // as methods in an interface is public and abstract so we need to make it public
        System.out.println("Queen moves");
    }
}

class Rook implements ChessPlayer{

    public void moves(){ 
        System.out.println("Rook moves");
    }
}


//an example of multiple inheritance
interface Hervibore{

    Boolean isHerbivorous=true;
    void eats();
}

interface Carnivore{

    Boolean isCarnivorous=true;
    void eats();

} 

class Beer implements Hervibore,Carnivore{

    public void eats(){
        System.out.println("eats veg as well as non-veg");
    }

}

//example of static keyword
class student{

    static int percentage(int maths,int chem,int phy){

 //as the defination of percentage will not change we can declare it with 
 //static keywordq
        return (maths+chem+phy)/3;
    }

    String name;
    int roll;
    static String schoolName; //schoolname remains same in all instance of the class
    
}

class Animal2{

    String color="brown";
    Animal2(){
         System.out.println("Animal constructor called");
    }
}

class Horse2 extends Animal2{

    Horse2(){
        // super.color="red"; //even if we dont write super parent construtor is called by default
        System.out.println("horse constructor is called");
    }

    
    

}





