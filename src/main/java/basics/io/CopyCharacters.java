package basics.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by rajani.maski on 7/10/17.
 *
 *Descendent of Reader and Writer
 */
public class CopyCharacters {

    public static void main(String[] args) throws IOException{

        FileReader reader = null;

        FileWriter writer = null;

        try{
            reader = new FileReader("Inputfile.txt");
            writer = new FileWriter("charactre_op");

            int c;

            while((c = reader.read())!=-1){
                writer.write(c);
            }
        }finally {

        }


    }
}
