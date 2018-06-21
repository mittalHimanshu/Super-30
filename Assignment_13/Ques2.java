import java.util.ArrayList;
import java.util.Collections;

public class Ques2 {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("Himanshu");
        str.add("Maneel");
        str.add("Jivtesh");
        Collections.sort(str);
        System.out.println(str);
        
        ArrayList<Float> deci = new ArrayList<>();
        deci.add(12.2f);
        deci.add(42.97f);
        deci.add(3.3f);
        Collections.sort(deci);
        System.out.println(deci);

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(12);
        nums.add(42);
        nums.add(3);
        Collections.sort(nums);
        System.out.println(nums);
        
        ArrayList<Double> number = new ArrayList<>();
        number.add(12.282);
        number.add(42.972);
        number.add(3.388);
        Collections.sort(deci);
        System.out.println(deci);
    }
}