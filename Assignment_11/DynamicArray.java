public class DynamicArray <T> {
    
    private Object arr[];
    private int index;
    
    public DynamicArray(){
	this.arr = new Object[5];
        index = 0;
    }
    
    public boolean isEmpty(){
	if(arr[0] != null)
            return false;
        else
            return true;
    }
    
    public T removeLast(){
	try{
            T temp = (T) arr[index-1];
            arr[index-1] = null;
            index--;
            return temp;
        }
        catch(Exception e){  }
        
        return (T) "Array is empty";
    }
    
    private void increaseSize(){
        Object temp[] = new Object[(int)(arr.length * 1.5)];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }
    
    public void add(T number){
	if(index == arr.length){
            increaseSize();
        }
        arr[index] = number;
        index++;
    }
    
    public int size(){
	return index;
    }
    
    public T get(int position){
        Object num = -1;
	try{
            return (T) arr[position];
        }
        catch(Exception e){}
        return (T) num;
    }
    
    public void set(int position, int element){
	try{
            if(position <= index){
                arr[position] = element;
            }
            else{
                System.out.println("index could not be found");
            }
        }
        catch(Exception e){
            System.out.println("index could not be found");
        }
    }
    
    public static void main(String[] args){
	DynamicArray obj = new DynamicArray();
        
        System.out.println(obj.isEmpty());
        
        for (int i = 0; i <= 10; i++){
            obj.add(i);
        }
        
        obj.set(101, 75);	
        
        while (!obj.isEmpty()){
            System.out.println(obj.removeLast());
        }	
        
    }
}