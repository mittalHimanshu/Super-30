// Write a Java program to reverse a String.

import java.util.Scanner;
public class Ques1{ 
    static String onReverse(String str){
        String rev="";
        for(int j=str.length()-1; j>=0; j--){
            rev += str.charAt(j);
        }
        return rev;
    }
    
    public static void main(String... arg){
        String str;
        Scanner xyz = new Scanner(System.in);
        str = xyz.nextLine();
        xyz.close();
        System.out.println(onReverse(str));
    }
}
