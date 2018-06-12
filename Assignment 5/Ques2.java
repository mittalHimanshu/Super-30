/* Create a class Complex with real and imaginary parts as it's data members. Create a member function called Display() to display the complex number properly. 
   Example : real part = 2 and imaginary part = 5, then the function should show 2+5i. */ 

import java.util.Scanner;
class Complex{
    int real, imaginary;
    Complex(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    void Display(){
        if(imaginary < 0){
            System.out.println(real+""+imaginary+"i");
        }
        else{
            System.out.println(real+"+"+imaginary+"i");
        }
    }
}
public class Ques2 {
    public static void main(String[] args) {
        int real, imaginary;
        Scanner xyz = new Scanner(System.in);
        real = xyz.nextInt();
        imaginary = xyz.nextInt();
        Complex obj = new Complex(real, imaginary);
        obj.Display();
    }   
}
