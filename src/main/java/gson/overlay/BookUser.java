package gson.overlay;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class BookUser {

    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Book.class, new BookDeserializer());

        Gson gson = gsonBuilder.create();

        String inputJson = "";

        Book book = gson.fromJson(inputJson, Book.class);
        System.out.println(book);

    }
}
