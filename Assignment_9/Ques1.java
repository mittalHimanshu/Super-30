/* Make a text file 'abc.txt' and write multiple paths in it(say C:/Users/Test/video.mp4).
   Read the contents of the file and try to print the path from the file. */


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ques1{    
    public static void main(String... arg) throws IOException{
        File f = new File("abc.txt");
        f.createNewFile();
        FileReader fr = new FileReader(f);
        try{
            int ch = fr.read();
            while(ch != -1){
                System.out.print((char)ch);
                ch = fr.read();
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        finally{
            fr.close();
        }
    }
}
