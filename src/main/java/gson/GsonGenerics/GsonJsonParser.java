package gson.GsonGenerics;

import com.google.gson.Gson;
import gson.overlay.Book;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class GsonJsonParser {

    public static <T> T populateFromJson(String jsonPath, Class<T> thisClass) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(jsonPath), thisClass);
    }


/*    public static Car populateFromJson(String jsonPath, Class<Car> thisClass) {
        Gson gson = new Gson();
        return gson.fromJson(jsonPath, thisClass);
    }*/


    public static void main(String[] args) throws FileNotFoundException {

        Book book = populateFromJson("/Users/rajani.maski/gd/search-jobs-api/problemsolving/src/main/resources/books.json", Book.class);
        //Car car = populateFromJson("/Users/rajani.maski/gd/search-jobs-api/problemsolving/src/main/resources/cars.json", Car.class);
        System.out.println(book.toString());

    }
}
