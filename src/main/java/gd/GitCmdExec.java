package gd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by rajani.maski on 6/16/17.
 */
public class GitCmdExec {

    public static void main(String args[]) throws IOException {
        readDownloadTest();
      //  unzip();
    }

    private static void unzip() throws IOException{
        String command = "tar --strip 1 -xvzf search-solr.tar.gz";
        Process p = Runtime.getRuntime().exec(command);

    }



    private static void readDownload() throws IOException {
        System.out.println("started GitCmdExec.readDownload");
        String command = "git archive  --remote git@bitbucket.org:glassdoorcom/search-chef-repo.git --format=tar.gz  develop cookbooks/search-solr --output search-solr.tar.gz";
        Process p = Runtime.getRuntime().exec(command);
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        String text = command + "\n";
        System.out.println(text);
        while ((line = input.readLine()) != null) {
            text += line;
            System.out.println("Line: " + line);
        }
    }


    private static long getFileSize(String filePath){
        File file = new File(filePath);
        return file.length();
    }


    private static void readDownloadTest() throws IOException {
        Path tempDir = Files.createTempDirectory("tempFiles");
       // String outputPath = tempDir.getParent().toString()+"/" + tempDir.getFileName().toString();
        String outputPath  = "/Users/rajani.maski/gd/search-jobs-api/problemsolving/";
        String command = "git archive  --remote git@bitbucket.org:glassdoorcom/search-chef-repo.git --format=tar.gz  " +
                "develop cookbooks/search-solr" +
                " --output " + outputPath +
                "/search-solr.tar.gz";
        Process p = Runtime.getRuntime().exec(command);
        System.out.println(command);
       if(p.getErrorStream().read()!=-1){
           long downloadFileSize = getFileSize("/Users/rajani.maski/gd/search-jobs-api/problemsolving/search-solr.tar.gz");
           if(downloadFileSize==0)
               throw new IOException("File size is zero, download was not successful");
       }
    }
}
