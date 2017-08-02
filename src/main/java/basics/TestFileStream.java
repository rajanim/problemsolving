package basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * Created by rajani.maski on 6/14/17.
 */
public class TestFileStream {
    public static void main(String[] args)  {
        try{
            FileOutputStream outputStream = new FileOutputStream("temp.dat");
            for (int i = 0; i < 10; i++) {
                outputStream.write(i);
            }
        }catch (IOException e){
            System.err.println(e.getLocalizedMessage());
        }
       try{
            FileInputStream inputStream = new FileInputStream("temp.dat");
            int value;
            while((value = inputStream.read())!=-1){
                System.out.println(value);
            }
       }catch (Exception e){

       }
    }
}
