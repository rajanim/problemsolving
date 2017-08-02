package gson.primitives;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class GsonExample1 {


    void serialization(){
        Gson gson  = new Gson();
        gson.toJson(1);
        gson.toJson("abcd");
        gson.toJson(new Long(19));
        int[] nums = {1,2};
        gson.toJson(nums);
        Integer[] integers = {1,2,3,4};
        gson.toJson(integers);

    }
    void deserilazation(){
        Gson gson = new Gson();
        int one = gson.fromJson("1", int.class);
        Boolean falseT = gson.fromJson("false", Boolean.class);
        String[] fromJsonStrings = gson.fromJson("[\"abc\"]", String[].class);
    }

    void collectionExample(){
        Gson gson = new Gson();
        Collection<Integer> integers = new ArrayList<>();
        integers.add(1);
        String json = gson.toJson(integers);

        Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
        Collection<Integer> ints2 = gson.fromJson(json, collectionType);


    }
}

class BagOfPrimitives{

    private int value1 = 1;
    private String value2 = "abc";
    private transient int value3 = 3;
    BagOfPrimitives(){}

    public static void main(String[] args) {
        BagOfPrimitives bagOfPrimitives = new BagOfPrimitives();
        Gson gson = new Gson();
        String json = gson.toJson(bagOfPrimitives);

    }
}
