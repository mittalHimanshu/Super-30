// Study about Static blocks and push 1 example code on github. 

/* 1. The code inside static block is executed only once: the first time you make an object of that class or, 
      the first time you access a static member of that class.
   2. Static blocks are executed before constructors.  */
   
class Demo{
    static int num;
    static {
        num = 10;
        System.out.println("Static block called before constructor. Also num = "+ num);
    }
    Demo(){
        System.out.println("Constructor called after static block");
    }
}
public class Ques1 {
    public static void main(String[] args) 
    {
        int number = Demo.num;
        Demo obj = new Demo();
    }
}
