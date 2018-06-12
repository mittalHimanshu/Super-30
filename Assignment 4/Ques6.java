// Given the array {1,1,1,1,0,0,1,0}. Sort it in ascending order as {0,0,0,1,1,1,1,1} in least computation.

public class Sort {
    public static void sortArray(int arr[], int size){
        int count = 0;     
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0)
                count++;
        }
        for (int i = 0; i < count; i++)
            arr[i] = 0;
        for (int i = count; i < size; i++)
            arr[i] = 1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{ 1, 1, 1, 1, 0, 0, 1, 0 };
        int size = arr.length;
        sortArray(arr, size);
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " "); 
    } 
}
