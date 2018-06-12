// Check if a number is a palindrome or not.

import java.util.Scanner;
public class Palindrome {
    public static boolean checkPal(int num){
        int temp = num;
        int rev = 0;
        while(num!=0){
            rev = (num%10) + (rev*10);
            num = num / 10;
        }
        if(rev == temp)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        int num;
        boolean flag;
        Scanner xyz = new Scanner(System.in);
        num = xyz.nextInt();
        flag = checkPal(num);
        if(flag)
            System.out.println(num + " is a palindrome number");
        else
            System.out.println(num + " is not a palindrome number");
    } 
}
