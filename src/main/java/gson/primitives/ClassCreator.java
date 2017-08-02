package gson.primitives;

import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class ClassCreator implements InstanceCreator<Car> {

    public Car createInstance(Type type){
        Car car = new Car();
        car.brand = "Toy";
        car.doors = 6;
        return car;
    }

}

class TestInstanceCreator{
    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Car.class, new ClassCreator());

    }
}




