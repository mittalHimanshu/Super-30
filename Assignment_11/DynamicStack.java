/*  Following methods has been implemented in my DynamicStack
    1. push();
    2. pop();
    3. search();
    4. empty();
    5. peek();
    6. size();
*/

public class DynamicStack <T> {
    
    Object arr[];
    int index;
    
    public DynamicStack() {
        this.arr = new Object[5];
        index = 0;
    }
    
    public T pop(){
        try{
            T temp = (T) arr[index-1];
            arr[index-1] = null;
            index--;
            return temp;
        }
        catch(Exception e){}
        
        return (T) "Stack is empty";
    }
    
    public T peek(){
        try{
            return (T) (arr[index-1]);
        }
        catch(Exception e){}
        
        return (T) "Stack is empty";
    }
       
    public boolean empty(){
        if(arr[0] != null)
            return false;
        else
            return true;
    }
    
    public T push(T number){
        if(index == arr.length){
            increaseSize();
        }
        arr[index] = number;
        index++;
        return number;
    }
    
    private void increaseSize(){
        Object temp[] = new Object[(int)(arr.length * 1.5)];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }
    
    public int size(){
        return index;
    }
    
    public int search(T number){
        int j=1;
        for(int i=index-1; i>=0; i--){
            if(arr[i] == number){
                return j;
            }
            else{
                j++;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        DynamicStack obj = new DynamicStack();
        
        //Check empty before adding elements
        System.out.println(obj.empty());
        
        //Check top before adding elements
        System.out.println(obj.peek());
        
        //Check size before adding elements
        System.out.println(obj.size());
        
        //Searching an element before adding any element will return -1
         System.out.println(obj.search("himanshu"));
        
        //Adding elements using push
        obj.push(14);
        obj.push(11);
        obj.push(14);
        obj.push(142);
        obj.push("himanshu");
        obj.push(1143);
        obj.push(143);
        obj.push(14243);
        obj.push("mittal");
        obj.push(21);
        obj.push(141);
        obj.push(786);
        
        //Check size after adding elements
        System.out.println(obj.size());
        
        //Searching an element after adding elements will return its position from top
        System.out.println(obj.search("himanshu"));
        
        //Check empty after adding elements
        System.out.println(obj.empty());
        
        //Check top before removing top element
        System.out.println(obj.peek());
        
        //Removing top element
        obj.pop();
        
        //Check top after removing top element
        System.out.println(obj.peek());
        
        //Printing all elements using pop
        while(!obj.empty()){
            System.out.println(obj.pop());
        }
    }
}