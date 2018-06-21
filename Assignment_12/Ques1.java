import java.util.HashSet;
import java.util.Set;


public class Ques1 {
    
    public static void main(String... args){
        
        Set s = new HashSet();
        s.add("Himanshu");
        s.add("Mittal");
        s.add("Acadview");
        s.add("Java");
        
        Set m = new HashSet();
        m.add("Himanshu");
        m.add("C++");
        m.add("Java");
        m.add("Python");
        
        Set a = new HashSet(s);
        a.retainAll(m);
        
        System.out.println(a);
    }
}
