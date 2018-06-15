// Write a Java program to remove all vowels from the String. 

import java.util.Scanner;
public class Ques3{       
    public static boolean checkVowel(char str){
        switch(str) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return true;
            default:
                return false;
    }
}
    public static void main(String... arg){
        String s;
        String notVowel = "";
        Scanner xyz = new Scanner(System.in);
        s = xyz.nextLine();
        xyz.close();
        int size = s.length();
        for(int i=0; i<size; i++){
            if(!checkVowel(s.charAt(i))){
                notVowel += s.charAt(i);
            }
        }
        System.out.println(notVowel);
    }
}
