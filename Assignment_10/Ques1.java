import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Ques1{    
    public static void main(String... arg) throws IOException{
        File f1 = new File("abc.txt");
        File f2 = new File("xyz.txt");
        f2.createNewFile();
        PrintWriter pw = null;
        BufferedReader br = null;
        try{
            pw = new PrintWriter(f2);
            br = new BufferedReader(new FileReader(f1)); 
            int ch = br.read();
            while(ch != -1){               
                pw.print((char)ch);
                ch = br.read();
            }
            br.close();
            pw.close();
            br = new BufferedReader(new FileReader(f2));
            ch = br.read();
            while(ch != -1){
                System.out.print((char)ch);
                ch = br.read();
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        finally{
            br.close();
        }
    }
}