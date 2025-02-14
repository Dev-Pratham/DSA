public class Oops1 {

    public static void main(String args[]) {

        Pen p1 = new Pen();
        p1.setColor("blue");
        // System.out.println(p1.color); using getters to get the color of an object
        // as private access modifier cannot be accessed outside class
        // p1.color="blue"; same reason as above...

        System.out.println(p1.getColor());

        BankAccount b1 = new BankAccount();
        b1.userName = "pratham";
        // b1.password="ironmanmark45"; //doesnot works as password is private
        b1.setPassword("ironmanmark45");

        // Student s1=new Student("pratham",25,"ironmanmark45");
        // System.out.println(s1.getPassword());

        // copy constructor callling
        // Student s2=new Student(s1);

        int marks[] = { 90, 100, 110 };
        Student s1 = new Student("pratham", 25, "lavairisx8", marks);
        Student s2 = new Student(s1);
        s1.marks[2] = 1000;
        System.out.println(s2.marks[2]);

        Calculator c1 = new Calculator();
        System.out.println(c1.sum(1, 2));

        Animal a1 = new Dog();
        a1.eats();
        String str = null;
        System.out.println(5 + 10 + "java" + 5 + 10);
        System.out.println(str + "java");

    }
}

// koi vi class public class ke niche hi rahegi

class Pen {

    // has some properties
    private String color;
    private int tip;

    // has some functions
    void setTip(int newTip) {
        tip = newTip;
    }

    // setters
    void setColor(String newColor) {
        color = newColor;
    }

    // getters
    String getColor() {
        return this.color;
    }

}

class BankAccount {

    private String password;
    public String userName;

    void setPassword(String newPassword) {
        password = newPassword;
    }
}

class Student {

    String name;
    int roll;
    private String password;
    int marks[] = new int[3];

    // constructors overloading
    // also it is an example of polymorphism
    // i.e same name but with different meaning

    // non-parameterized constructor
    Student() {
        System.out.println("constructor is called");
    }

    // parameterized constructor
    Student(String name) {
        System.out.println("hello");
        this.name = name;

    }

    // parameterised constructor
    Student(String name, int roll, String password, int marks[]) {
        this.name = name;
        this.roll = roll;
        this.password = password;
        this.marks = marks;

    }

    // copy constructor
    Student(Student copy) {

        this.name = copy.name;
        this.roll = copy.roll;
        // this.password=copy.password; //why copy password to another object hahh
        // this.marks=copy.marks; //shallow constructor

        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = copy.marks[i];
        }
    }

    // getter
    String getPassword() {
        return this.password;
    }

    // setter
    void setPassword(String password) {
        this.password = password;
    }

}

class Calculator {
    // this is the example of method overloading
    // also called compile time polymorphism
    // ability to resolve the method to be invoked at compile time.
    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    float sum(float a, float b) {
        return a + b;
    }

}

// example of method overriding(runtime polymorphism)
// overides the method of parent class
class Animal {
    void eats() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void eats() {
        System.out.println("Dog eats");
    }
}