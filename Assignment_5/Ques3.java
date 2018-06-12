// Write a program to take an array of 10 numbers as input from the user and find the second largest element in the array.

import java.util.Scanner;
public class Ques3 {
    public static int Find2ndLargest(int arr[], int size)
    {
        int i, largest=0, secondLargest=0;  
        for (i = 0; i < size ; i++)
        {
            if (arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] > secondLargest && arr[i] != largest)
                secondLargest = arr[i];
        }
        return secondLargest;
    }
    public static void main(String[] args) 
    {
        Scanner xyz = new Scanner(System.in);
        int arr[] = new int[10];
        for(int i=0; i<10; i++){
            arr[i] = xyz.nextInt();
        }
        xyz.close();
        System.out.println(Find2ndLargest(arr, 10));
    }
}
