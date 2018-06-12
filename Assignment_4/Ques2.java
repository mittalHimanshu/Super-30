// Take a number from the user as input and find all even numbers upto that number.

import java.util.Scanner;
public class Even {
    public static boolean findEven(int num){
        if(num %2 == 0)
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
            flag = findEven(i);
            if(flag)
                System.out.print(i + " ");
        }
    } 
}
