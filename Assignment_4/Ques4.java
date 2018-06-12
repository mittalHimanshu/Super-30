//Take a number as input from the user and check if the given number is armstrong or not. 

import static java.lang.Math.pow;
import java.util.Scanner;
public class Armstrong {
    public static boolean checkArmstrong(int num){
        int totalDigits = 0, temp = num, sum = 0, lastDigit;
        while(num!=0){
            totalDigits++;
            num = num/10;
        }
        num = temp;
        while(num!=0){
            lastDigit = num % 10;
            sum += pow(lastDigit, totalDigits);
            num = num/10;
        }        
       
        if(temp == sum)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        int num;
        boolean flag;
        Scanner xyz = new Scanner(System.in);
        num = xyz.nextInt();
        flag = checkArmstrong(num);
        if(flag)
            System.out.println(num + " is an armstrong number");
        else
            System.out.println(num + " is not an armstrong number");
    } 
}
