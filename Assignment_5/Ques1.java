//Create a class Rectangle with length and breadth as it's data members. Create a member function called CalculateArea() which displays the area of the rectangle object.

import java.util.Scanner;
class Rectangle{
    float length, breadth;
    Rectangle(float length, float breadth){
        this.length = length;
        this.breadth = breadth;
    }
    void CalculateArea(){
        System.out.println(length*breadth);
    }
}
public class Area {
    public static void main(String[] args) {
        float length, breadth;
        Scanner xyz = new Scanner(System.in);
        length = xyz.nextFloat();
        breadth = xyz.nextFloat();
        Rectangle obj = new Rectangle(length, breadth);
        obj.CalculateArea();
    }   
}
