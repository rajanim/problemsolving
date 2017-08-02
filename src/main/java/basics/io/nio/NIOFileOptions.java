package basics.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by rajani.maski on 7/11/17.
 */
public class NIOFileOptions {

    public static void main(String[] args) {

        //to move

        Path source = Paths.get("/Users/rajani.maski/Downloads/20news/all/");
        Path target = Paths.get("/Users/rajani.maski/Downloads/20news/all_here/");

        try{
        Files.move(source,target, REPLACE_EXISTING, ATOMIC_MOVE );

        }catch (IOException e){

        }

    }
}
