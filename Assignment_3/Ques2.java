// Check if a given year is a leap year or not. 

import java.util.Scanner;
public class Leap {
    public static boolean checkLeap(int year){
        if((year%4==0) && (year%100!=0))
		return true;
	else if (year%100==0)
		return false;
        else if (year%400 == 0)
		return true;
        else
            return false;
    }
    public static void main(String[] args) {
        int year;
        boolean flag;
        Scanner xyz = new Scanner(System.in);
        year = xyz.nextInt();
        flag = checkLeap(year);
        if(flag)
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is not a leap year.");
    } 
}
