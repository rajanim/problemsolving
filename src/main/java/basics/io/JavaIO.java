package basics.io;

import java.io.File;

/**
 * Created by rajani.maski on 6/16/17.
 */
public class JavaIO {

    public static void main(String[] args) {

        //instantiate file
        File file = new File("");

        //check if file exist
        boolean fileFound = file.exists();

        //create dir
        File dir = new File("/Users/rajani.maski/gd/search-jobs-api/problemsolving/io_dir");
        boolean dirExist = dir.exists();
        if(!dirExist){
            dirExist = dir.mkdir();
            if(!dirExist)
                System.err.println("directory not created: " + dir.getAbsolutePath());
            else
                System.out.println("directory created: " + dir.getAbsolutePath());
        }

    }


    public static boolean moveFile(File file, String filePath){

        return file.renameTo(new File(filePath));

    }

    public  static boolean deleteFile(File file){

        return file.delete();
    }

    public static void readDirectory(String dirPath){

        File file = new File(dirPath);
        String [] files = file.list();
        File[] filesList = file.listFiles();

        for(File eachFile : filesList)
            System.out.println(eachFile.getAbsolutePath());
    }
}
