//Take a number from the user as input and find all prime numbers upto that number.

import java.util.Scanner;
public class Prime {
    public static boolean findPrime(int num){
        int count = 0;
        for(int i=1; i<=num; i++){
            if(num%i == 0)
                count++;
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
        for(int i=0; i<=num; i++){
            flag = findPrime(i);
            if(flag)
                System.out.print(i + " ");
        }
    } 
}
