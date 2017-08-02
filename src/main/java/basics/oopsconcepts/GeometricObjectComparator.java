package basics.oopsconcepts;

import java.util.Comparator;

/**
 * Created by rajani.maski on 7/2/17.
 */
public class GeometricObjectComparator implements Comparator<GeometricObject>, java.io.Serializable {
    public int compare(GeometricObject geometricObject1, GeometricObject geometricObject2){
        double area1 = geometricObject1.getArea();
        double area2 = geometricObject1.getArea();

        if(area1<area2)
            return -1;
        else if(area1>area1)
            return 1;
        else
            return 0;


    }

}
