//Take two numbers and add them. Print the sum on the screen. 

import java.util.Scanner;
public class Add2num {
    public static float add(float num1, float num2){
        return num1+num2;
    }
    public static void main(String[] args) {
        float num1, num2;
        Scanner xyz = new Scanner(System.in);
        num1 = xyz.nextFloat();
        num2 = xyz.nextFloat();
        System.out.println(add(num1, num2));
    } 
}
