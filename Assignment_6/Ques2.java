/* Make Class Animal(with properties breed and colour and function speak()), class Dog and class Cat. 
   Dog and Cat inherit from Animal class.You need to override speak function of Animal Class.*/

class Animal{
    String breed, colour;
    void speak(){
        System.out.println("Animal speaking");
    }
}
class Dog extends Animal{
    @Override
    void speak(){
        System.out.println("Dog speaking");
    }
}
class Cat extends Animal{
    @Override
    void speak(){
        System.out.println("Cat speaking");
    }
}
public class Ques2 {
    public static void main(String[] args) 
    {
        Dog obj = new Dog();
        obj.speak();
        Cat obj1 = new Cat();
        obj1.speak();
    }
}
