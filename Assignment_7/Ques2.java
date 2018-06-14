/* Create an Abstract Class Animals with color, breed and name as variables, 
   along with eat() abstract method and also a speak() method which is not abstract.  */

abstract class Animals{
    String color, breed, name;
    abstract void eat();
    void speak(){
        System.out.println("Animal speaking");
    }
}
class Dog extends Animals{
    @Override
    void eat() {
        System.out.println("Dog eating");
    }
}
public class Ques2 {
    public static void main(String... arg){       
        Dog obj1 = new Dog();
        obj1.speak();
        obj1.eat();
    }
}
