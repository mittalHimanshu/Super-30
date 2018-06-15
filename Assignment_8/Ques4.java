/*  Write a Java program to print the following pattern :
    a 
    ab 
    abc  */

public class Ques4 {
    public static void main(String[] args){
        for(int i=1;i<4;i++){
            int ascii=97;
            for(int j=1;j<=i;j++){
		System.out.print((char)ascii);
                ascii++;
            }
            System.out.println();
        }
    }
}
