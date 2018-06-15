//  Write a Java program to generate all substrings of the string.

import java.util.Scanner;
public class Ques2{    
    public static void findSubstring(String s){
	      if(s == null || s.length() == 0){
            return;
	      }		
	      for(int i = 0; i < s.length(); i++){
            for(int j = 1; j <= s.length()-i; j++){
		            System.out.println(s.substring(i, i+j));
            }
	      }
    }
    public static void main(String... arg){
        String str;
        Scanner xyz = new Scanner(System.in);
        str = xyz.nextLine();
        xyz.close();
        findSubstring(str);
    }
}
