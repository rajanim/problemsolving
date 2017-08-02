package jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gson.overlay.Car;

import java.io.IOException;

/**
 * Created by rajani.maski on 7/19/17.
 */
public class JacksonObjMapper {


    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        try {

            Car car = objectMapper.readValue(carJson, Car.class);

            JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);



        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

    }
}
