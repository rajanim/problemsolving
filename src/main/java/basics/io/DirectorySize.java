package basics.io;

import java.io.File;
import java.util.Scanner;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class DirectorySize {

    public static void main(String[] args) {
        System.out.println("file path");
        Scanner scanner = new Scanner(System.in);
        String directory = scanner.nextLine();
        System.out.println();
    }

    private static long getSize(File file){
        long size = 0;


        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; files!=null && i<files.length; i++){
                size += getSize(files[i]);
            }
        }
        else{
            size +=file.length();
        }

        return size;
    }
}
