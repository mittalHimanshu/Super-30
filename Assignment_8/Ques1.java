// Write a Java program to reverse a String.

import java.util.Scanner;
public class Ques1{ 
    static String onReverse(String str){
        String rev; String old="";
        int i = 0;
        for(int j=0; j<str.length(); j = i+1){
            rev = ""; i=j;
            while(str.charAt(i) != ' '){
                rev += str.charAt(i);
                i++;
                if(i == str.length())
                    break;
            }
            old = rev + " " + old;
        }
        return old;
    }
    
    public static void main(String... arg){
        String str;
        Scanner xyz = new Scanner(System.in);
        str = xyz.nextLine();
        xyz.close();
        System.out.println(onReverse(str));
    }
}
