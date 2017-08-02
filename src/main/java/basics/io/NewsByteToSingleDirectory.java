package basics.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by rajani.maski on 7/7/17.
 */
public class NewsByteToSingleDirectory {

    public static void main(String[] args) throws IOException {

        String rootPath = "/Users/rajani.maski/Downloads/20news-bydate/20news-bydate-test/";
        File commonDir = new File(  "/Users/rajani.maski/Downloads/20news-bydate/test");

        if (!commonDir.isDirectory()) {
            commonDir.mkdirs();
        }
        File dir = new File(rootPath);

        for (File eachDir : dir.listFiles()) {
            if(eachDir.isDirectory())
            FileUtils.copyDirectory(eachDir, commonDir);

        }

    }
}
