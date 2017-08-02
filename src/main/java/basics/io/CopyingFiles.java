package basics.io;

import java.io.*;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class CopyingFiles {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("usage : java copy sourceFile targetFile");
        }
        String sourceFilePath = "";
        String targetFilePath = "";
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        if (!sourceFile.exists()) {
            System.err.println("source file does not exist");
            System.exit(2);
        }

        if (!targetFile.exists()) {
            System.err.println("file exist, no overwrite operation");
            System.exit(3);
        }

        try (

                //create input stream as buffer
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));

                //create op stream
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
        ) {
            int r = 0;

            while ((r = inputStream.read()) != -1) {
                outputStream.write((byte) r);
            }
        }


    }
}
