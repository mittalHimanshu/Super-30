public class Ques3 {

    public static <T> void genericFunction(T[] inputArray) {
        for (T object : inputArray){
            System.out.print(object + " ");
        }
    }

    public static void main(String args[]) {

        Integer[] integerType = { 10, 20, 30, 40, 50, 60 };
        Float[] floatType = { 10.2f, 29.3f, 89.4f, 2.99f };
        Double[] doubleType = { 10.23, 29.35, 89.24, 28.99 };
        Character[] characterType = { 'H', 'I', 'M', 'A', 'N', 'S', 'H', 'U' };

        System.out.println("Printing Integer Array : ");
        genericFunction(integerType);
        
        System.out.println("\n\nPrinting Float Array : ");
        genericFunction(floatType);

        System.out.println("\n\nPrinting Double Array : ");
        genericFunction(doubleType);

        System.out.println("\n\nPrinting Character Array : ");
        genericFunction(characterType);
    }
}