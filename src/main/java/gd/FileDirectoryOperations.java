package gd;

/**
 * Created by rajani.maski on 6/16/17.
 */
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Paths;


public class FileDirectoryOperations {

    //read directory
    // loop files under directory recursively.

    public static void main (String[] args) throws IOException {
        FileDirectoryOperations listFilesUtil = new FileDirectoryOperations();

        // final String directoryLinuxMac ="/Users/rajani.maski/gd/search-jobs-api/problemsolving/cookbooks/";
        //listFilesUtil.listFilesAndFilesSubDirectories(directoryLinuxMac);
        //listFilesUtil.deleteTempDir("/var/folders/5n/lj30wj8559bf4wgkm8_90k8cxw0mgc/T/tempfiles1248711261890388084/");
        //listFilesUtil.createTempDirFile();

        System.out.println(        Paths.get(".").toAbsolutePath().normalize().toString());

    }


    public void createSubDirectories(){

        File file = new File("/Users/rajani.maski/gd/search-jobs-api/problemsolving/temp/test");
        if(!file.exists()){
           boolean created= file.mkdirs();
                    if(created){
                        System.out.println("directory created");
                    }else{
                        System.out.println("not created");
                    }
        }


    }


    public void createTempDirFile() throws IOException{

        Path tempDir = Files.createTempDirectory("tempFiles");
        System.out.println(tempDir.getParent().toString()+ tempDir.getFileName().toString());



       /* Path tempFile = Files.createTempFile(tempDir, "tempfiles", ".tmp");
        List<String> lines = Arrays.asList("Line1", "Line2");
        Files.write(tempFile, lines, Charset.defaultCharset(), StandardOpenOption.WRITE);
        System.out.println("uri : "+ tempFile.getParent().toUri());
        System.out.printf("Wrote text to temporary file %s%n", tempFile.toString());
        deleteTempDir("/var/folders/5n/lj30wj8559bf4wgkm8_90k8cxw0mgc/T/tempfiles1248711261890388084/");

        deleteTempDir(tempDir.getParent().getFileName().toUri().toString());
*/
    }

    public void deleteTempDir(String uri) throws IOException{

        System.out.println("deleting: " + uri);
        Path tempDir = Paths.get(uri);
        boolean deleted = Files.deleteIfExists(tempDir);
        System.out.println(deleted);
    }
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile() && !file.isHidden()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }

    public void listFilesUnderDirUsingDirStream(String dirName){
        Path path = Paths.get(dirName);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file: stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }

    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }

    /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }
    }
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
}
