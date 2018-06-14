//Take two numbers as string input and convert them into Integers and find the maximum of the two numbers. 

import java.util.Scanner;
public class Ques3 {
    public static void main(String... arg){       
        String num1, num2;
        int n1, n2;
        Scanner xyz = new Scanner(System.in);
        num1 = xyz.next();
        num2 = xyz.next();
        xyz.close();
        n1 = Integer.parseInt(num1);
        n2 = Integer.parseInt(num2);
        int big = (n1>n2)?n1:n2;
        System.out.println("maximum number is : " + big);
    }
}
