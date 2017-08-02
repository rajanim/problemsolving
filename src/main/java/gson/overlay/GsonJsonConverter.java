package gson.overlay;

import com.google.gson.Gson;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class GsonJsonConverter {


    public static void main(String[] args) {
        System.out.println(toJsonConverter());
        //toGsonConverter();
    }

    static void toGsonConverter() {
    String json = toJsonConverter();
    Gson gson = new Gson();
    Car car = gson.fromJson(json, Car.class);


        System.out.println(car.toString());

    }

    static String toJsonConverter() {

        Car car = new Car();
        car.setBrand("mazda");
        car.setDoors(4);

        Gson gson = new Gson();
        String json = gson.toJson(car);
        return json;

    }
}
