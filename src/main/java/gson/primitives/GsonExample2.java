package gson.primitives;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class GsonExample2 {

    void jsonToGson() {
        String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
        Gson gson = new Gson();
        Car car = gson.fromJson(json, Car.class);
    }


    void GsonToJson() {
        Car car = new Car();
        car.brand = "Rover";
        car.doors = 6;
        Gson gson = new Gson();
        gson.toJson(car);
    }

    void serializingNullFields() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
    }

}

class Car {
    public String brand = null;
    public int doors = 0;
}
