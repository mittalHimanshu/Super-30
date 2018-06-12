// Check if a number is prime or not.

import java.util.Scanner;
public class Prime {
    public static boolean checkPrime(int num){
        int count = 0;
        for(int i=1; i<=num; i++){
            if(num%i == 0){
                count++;
            }
        }
        if(count == 2)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        int num;
        boolean flag;
        Scanner xyz = new Scanner(System.in);
        num = xyz.nextInt();
        flag = checkPrime(num);
        if(flag)
            System.out.println(num + " is a prime number");
        else
            System.out.println(num + " is not a prime number");
    } 
}
