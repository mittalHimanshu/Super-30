/* Create an Interface called Animals with speak(), eat() methods.
   Create two classes Cat and Dog implementing their own versions of these methods. */
   
interface Animals{
    void speak();
    void eat();
}
class Cat implements Animals{
    @Override
     public void speak() {
        System.out.println("Cat speaking");
    }
    @Override
    public void eat() {
        System.out.println("Cat eating");
    }
}
class Dog implements Animals{
    @Override
    public void speak() {
        System.out.println("Dog speaking");
    }
    @Override
    public void eat() {
        System.out.println("Dog eating");
    }  
}
public class Ques1 {
    public static void main(String... arg){
        Cat obj = new Cat();
        obj.speak();
        obj.eat();
        Dog obj1 = new Dog();
        obj1.speak();
        obj1.eat();
    }
}
