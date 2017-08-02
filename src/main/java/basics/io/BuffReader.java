package basics.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rajani.maski on 7/11/17.
 */
public class BuffReader {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new
                    BufferedReader(new FileReader("/Users/rajani.maski/gd/search-jobs-api/problemsolving/src/main/resources/io.csv"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                  String [] strings =  line.split("\\t");

                for (int i = 0; i < strings.length; i++) {
                    System.out.println(strings[i]);
                 }
            }
        } finally {
            bufferedReader.close();
            System.out.println("done");

        }
    }
}
