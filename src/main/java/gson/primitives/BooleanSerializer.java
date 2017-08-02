package gson.primitives;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class BooleanSerializer implements JsonSerializer<Boolean> {

    public JsonElement serialize(Boolean aBoolean, Type type,
                                JsonSerializationContext jsonSerializationContext){
        if(aBoolean)
            return new JsonPrimitive(1);
        else
            return new JsonPrimitive(0);
    }
}
