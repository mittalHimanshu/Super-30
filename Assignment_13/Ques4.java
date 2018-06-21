import java.util.*;

class Employee {
    
    String name; int age;
    public Employee(String name, int age) {
        this.name = name; this.age = age;
    }
}

class CompareName implements Comparator <Employee>{

    @Override
    public int compare(Employee obj1, Employee obj2){
        return obj1.name.compareTo(obj2.name);
    }
}

class CompareAge implements Comparator <Employee>{

    @Override
    public int compare(Employee obj1, Employee obj2){
        if(obj1.age > obj2.age)
            return 1;

        else if(obj1.age == obj2.age)
            return 0;

        else
            return -1;
    }
} 

public class Ques4{

    public static void main(String args[]){
        
        ArrayList<Employee> al=new ArrayList<>();
        
        Employee e1 = new Employee("Kunal", 35);
        Employee e2 = new Employee("Himanshu", 21);
        Employee e3 = new Employee("Jivtesh", 49);
        
        al.add(e1);
        al.add(e2);
        al.add(e3);
        
        System.out.println("Sorting Done By Name : \n");
        
        Collections.sort(al,new CompareName());
        for (Employee st : al) {
            System.out.println(st.name+" "+st.age);
        }
        
        System.out.println("\nSorting Done By Age : \n");
        
        Collections.sort(al,new CompareAge());
        for (Employee st : al) {
            System.out.println(st.name+" "+st.age);
        }
    }
}
