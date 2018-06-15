// Write a Java program to check occurrence of a string in another string, where both strings are taken as input from the user. 

import java.util.Scanner;
public class Ques5 {
    public static void main(String[] args){
        String s1, s2;
        int i, j, m, n;
        Scanner xyz = new Scanner(System.in);
        s1 = xyz.nextLine();
        s2 = xyz.nextLine();
        int length = 0;
        xyz.close();
        for(i=0,j=0; i<s1.length(); i++){
            if(s2.charAt(j) == s1.charAt(i)){
                m = i; n = j; length = 0;
                for(int k=1; k<s2.length(); k++){
                    m++; n++;
                    if(s2.charAt(n) == s1.charAt(m))
                        length++;
                    else
                        break;
                }
                if(length+1 == s2.length())
                    break;
            }
        }
        if(length+1 == s2.length()){
            System.out.println("present");
        }
        else{
            System.out.println("not present");
        }
    }
}



