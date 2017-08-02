package gson.overlay;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class Car {


    private int doors;

    private String brand;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }


    public String toString() {
        return "brand: " + brand + ", doors: " + doors;
    }


}
