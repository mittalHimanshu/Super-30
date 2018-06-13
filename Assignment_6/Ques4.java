// Print length of longest increasing sub array.

import java.util.Scanner;
public class Ques4 {
    public static int SubArray(int arr[],int n)
    {
        int max = 1, len = 1;
        for (int i=1; i<n; i++)
        {
            if (arr[i] > arr[i-1])
                len++;
            else
            {
                if (max < len)    
                    max = len;   
                len = 1;    
            }    
        }
        if (max < len)
            max = len;
        return max;
    }
    public static void main(String[] args) 
    {
        Scanner xyz = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size = xyz.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter array elements : ");
        for(int i=0; i<size; i++)
            arr[i] = xyz.nextInt();
        xyz.close();
        System.out.println("Length of longest increasing sub array is : "+SubArray(arr, size));
    }
}
