import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread1 implements Runnable{
    @Override
    synchronized public void run(){  
        for(int i=501; i<=1000; i++){
            System.out.println(i);
            try {
                sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
} 

class MyThread2 extends Thread{    
    @Override
    synchronized public void run(){  
        for(int i=1; i<=500; i++){
            System.out.println(i);
            try {
                sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }     
}  
  
public class Ques1{  
    public static void main(String args[]) throws InterruptedException{   
        MyThread1 t1=new MyThread1();  
        MyThread2 t2=new MyThread2();  
        Thread thread2 = new Thread(t1);
        t2.start(); 
        t2.join();
        thread2.start();
    }  
}  