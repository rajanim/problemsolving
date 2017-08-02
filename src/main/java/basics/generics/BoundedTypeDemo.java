package basics.generics;


import javafx.scene.shape.Circle;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class BoundedTypeDemo {

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Circle circle1 = new Circle(15);
        System.out.println("same area? " + equalArea(circle1,circle));

    }
    public static <E extends Circle> boolean equalArea(E object1, E object2){
        return object1.toString()==object2.toString();
    }
}
