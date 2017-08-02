package basics.io;

import java.io.*;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class TestObjectStreamForArray  {

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int[] numbers = {1,2,3,4,5};
        String[] strings = {"john", "abe", "bac"};

        try(
                ObjectOutputStream output  = new ObjectOutputStream(new FileOutputStream("array.dat", true));
                ){

            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"))){
                    int[] nums = (int[])(input.readObject());
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }

        }

    }
}
