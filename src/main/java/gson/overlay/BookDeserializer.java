package gson.overlay;

import com.google.gson.*;
import com.oracle.javafx.jmx.json.JSONException;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class BookDeserializer implements JsonDeserializer<Book> {

   /* private static JsonObject merge(JsonObject... jsonObjects) throws JSONException {

        JsonObject jsonObject = new JsonObject();

        for (JsonObject temp : jsonObjects) {
            Iterator<Map.Entry<String, JsonElement>> keys = temp.entrySet().iterator();
            while (keys.hasNext()) {
                Map.Entry<String, JsonElement> key = keys.next();
                jsonObject.add(key.getKey(), key.getValue());
            }

        }
        return jsonObject;
    }*/

    @Override
    public Book deserialize(final JsonElement jsonElement, final Type type,
                            final JsonDeserializationContext jsonDeserializationContext) {

        //create a book object and get json object of it
        //read json from file and get json object from it.
        //merge both
        //make new
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        Book book2 = new Book();
        Gson gson = new Gson();
        JsonObject jsonObject1 = gson.toJsonTree(book2, Book.class).getAsJsonObject();

//        JsonObject merged = merge(jsonObject, jsonObject1);

     //   gson.fromJson(merged, Book.class);

        JsonElement titleElement = jsonObject.get("title");
        final String title = titleElement.getAsString();
        final String isbn10 = jsonObject.get("isbn-10").getAsString();
        final String isbn13 = jsonObject.get("isbn-13").getAsString();
        final JsonArray jsonAuthorsArray = jsonObject.get("authors").getAsJsonArray();
        final String[] authors = new String[jsonAuthorsArray.size()];
        for (int i = 0; i < authors.length; i++) {
            final JsonElement jsonAuthor = jsonAuthorsArray.get(i);
            authors[i] = jsonAuthor.getAsString();
        }


        final Book book = new Book();
        book.setTitle(title);
        book.setIsbn10(isbn10);
        book.setIsbn13(isbn13);
        book.setAuthors(authors);
        return book;
    }
}
