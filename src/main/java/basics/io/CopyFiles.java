package basics.io;

import java.io.*;

/**
 * Created by rajani.maski on 6/16/17.
 */
public class CopyFiles {


    public static void main(String[] args) throws IOException{
        if(args.length!=2){
            System.out.println("usage source target");
            System.exit(0);
        }

        File sourceFile = new File(args[0]);

        if(!sourceFile.exists()){
            System.out.println("source file does not exist");
            System.exit(0);
        }

        File targetFile = new File(args[1]);

        if(!targetFile.exists()){
            System.out.println("target file does not exist");
            System.exit(0);
        }

        BufferedInputStream inputStream = new
                BufferedInputStream(new FileInputStream(sourceFile));

        BufferedOutputStream outputStream = new
                BufferedOutputStream(new FileOutputStream(targetFile));

        //Continuously read a byte from input and write it to output
        int r;

        int numberOfBytesCopied = 0;

        while ((r=inputStream.read())!=-1){
            outputStream.write((byte)r);
            numberOfBytesCopied++;
        }

        System.out.println(numberOfBytesCopied + "bytes copied");
    }
}
