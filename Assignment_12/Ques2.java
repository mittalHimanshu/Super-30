import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Ques2 {
    
    public static void main(String... args){
        
        HashMap hm = new HashMap();
        hm.put(1, "Himanshu");
        hm.put(2, "Mittal");
        hm.put(3, "Acadview");
        hm.put(4, "Java");
        hm.put(5, "Development");   
        
        Set set=hm.entrySet();
        
        Iterator i=set.iterator();
        
        while(i.hasNext()){
            Map.Entry me=(Map.Entry)i.next();
            System.out.println(me.getKey() + " ---> " + me.getValue());
        }
    }
}
