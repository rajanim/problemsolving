package gson.overlay;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class JsonMerger {

    public static void main(String[] args) throws FileNotFoundException {

        //create a book object and get json object of it
        //read json from file and get json object from it.
        //merge both
        //make new

        Gson gson = new Gson();

        Book book = new Book();
        book.setTitle("default");
        book.setIsbn10("default 10");
        book.setIsbn13("default 13 ");
        book.setAuthors(new String[]{"a", "b"});

        JsonObject defaultBook = gson.toJsonTree(book, Book.class).getAsJsonObject();

        System.out.println(book.toString());

        Reader reader = new FileReader("/Users/rajani.maski/gd/search-jobs-api/problemsolving/src/main/resources/books.json");
        Book customBook = gson.fromJson(reader, Book.class);

        System.out.println(customBook.toString());

        JsonObject customBookJsonObj = gson.toJsonTree(customBook, Book.class).getAsJsonObject();

        JsonObject mergedBook = merge(defaultBook, customBookJsonObj);
        Book newMergebook = gson.fromJson(mergedBook, Book.class);
        System.out.println(mergedBook.toString());
        System.out.println(newMergebook.toString());

    }

    private static JsonObject merge(JsonObject... jsonObjects) throws JSONException {

        JsonObject jsonObject = new JsonObject();

        for (JsonObject temp : jsonObjects) {
            Iterator<Map.Entry<String, JsonElement>> keys = temp.entrySet().iterator();
            while (keys.hasNext()) {
                Map.Entry<String, JsonElement> key = keys.next();
                jsonObject.add(key.getKey(), key.getValue());
            }

        }
        return jsonObject;
    }

}
