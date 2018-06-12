/* Overload Print function to accept Null arguments , one integer , one float. */

/* 1. Null arguments can be passed as a parameter to print function by typecasting to Object, String or Integer */

public class Ques3 {
    public static void main(String[] args) 
    {
        int integer = 5;
        float decimal = 12.34f;
        System.out.print((Object)null + "\n");
        System.out.print((String)null + "\n");
        System.out.print((Integer)null + "\n");
        System.out.print(integer + "\n");
        System.out.print(decimal + "\n");
    }
}
