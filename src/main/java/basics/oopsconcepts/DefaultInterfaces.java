package basics.oopsconcepts;

import javafx.scene.shape.Circle;

/**
 * Created by rajani.maski on 7/10/17.
 */
public interface DefaultInterfaces {

    String interfaceName = "Interface with default feature";

    int doThis();

    default void doNew() {
        Circle circle = new Circle();
        System.out.println(circle.toString());
        System.out.println("I am a new feature");
    }

}

class ConcreteClass implements DefaultInterfaces {

    public int doThis() {

        return 1;
    }

   public void doNew(){
        System.out.println("I am implementing new");
    }

    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.doNew();
    }
}

