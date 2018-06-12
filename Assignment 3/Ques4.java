// Given three numbers a b c, write a Java program to find the biggest out of three numbers.

import java.util.Scanner;
public class BigNumber {
    public static float big(float a, float b, float c){
        return (a>b && a>c)?a:(b>c?b:c);
    }
    public static void main(String[] args) {
        float a, b, c;
        Scanner xyz = new Scanner(System.in);
        a = xyz.nextFloat();
        b = xyz.nextFloat();
        c = xyz.nextFloat();
        System.out.println(big(a, b, c) + " is the biggest of given three numbers");
    } 
}
