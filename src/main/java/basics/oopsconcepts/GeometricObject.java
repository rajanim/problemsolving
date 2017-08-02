package basics.oopsconcepts;

import java.util.Date;

/**
 * Created by rajani.maski on 6/16/17.
 */
public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;


    protected GeometricObject(){
        dateCreated = new Date();
    }

    protected GeometricObject(String color, boolean filled){

    }

    public double getArea() {
        return  0.0;
    }

}
