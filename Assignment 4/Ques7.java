// Given a sorted array {1,4,6,7,8,9,10}. Write a program to take a Number from the user and check if it is in the array or not in least computation. 

import java.util.Scanner;
public class Sort {
    public static int searchArray(int arr[], int num){
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r-l)/2;
            if (arr[m] == num)
                return m;
            if (arr[m] < num)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner xyz = new Scanner(System.in);
        int arr[] = {1, 4, 6, 7, 8, 9, 10};
        int num = xyz.nextInt();
        int result = searchArray(arr, num);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at " + "index " + result); 
    } 
}
