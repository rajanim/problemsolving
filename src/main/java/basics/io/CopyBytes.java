package basics.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by rajani.maski on 7/10/17.
 * copy one byte at a time
 *
 * descendent of File input stream and output stream
 */
public class CopyBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("/Users/" +
                    "rajani.maski/gd/search-jobs-api/problemsolving/src/main/java" +
                    "/basics/io/InputFile");

            out = new FileOutputStream("writeoutagain.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } finally {
            if (in != null)
                in.close();
        }

    }
}
