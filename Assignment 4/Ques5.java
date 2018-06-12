//Take a number from the user and print its reverse.

import java.util.Scanner;
public class Reverse {
    public static int rev(int num){
        int rev = 0;
        while(num!=0){
            rev = (num%10) + (rev*10);
            num = num / 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int num, reverse;
        Scanner xyz = new Scanner(System.in);
        num = xyz.nextInt();
        reverse = rev(num);
        System.out.println("Reverse of " + num + " is " + reverse);
    } 
}
