/* Write a program to take an array of 10 numbers from the user and arrange the elements in a waveform. 
   For example, if the array is {1,2,3,4,5,6,7,8,9,10} then it should become {2,1,4,3,6,5,8,7,10,9}. */
   
import java.util.Scanner;
public class Ques4 {
    public static void printWaveform(int arr[], int size)
    {
        for(int i=0; i<size; i+=2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) 
    {
        Scanner xyz = new Scanner(System.in);
        int arr[] = new int[10];
        for(int i=0; i<10; i++){
            arr[i] = xyz.nextInt();
        }
        xyz.close();
        printWaveform(arr, 10);
    }
}
