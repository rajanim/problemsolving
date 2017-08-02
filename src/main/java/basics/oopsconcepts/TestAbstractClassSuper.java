package basics.oopsconcepts;

import javafx.scene.shape.Circle;

/**
 * Created by rajani.maski on 7/10/17.
 */
public abstract class TestAbstractClassSuper {

    String interfaceName = "Interface with default feature";

    abstract int doThis();

      void doNew() {
        Circle circle = new Circle();
        System.out.println(circle.toString());
        System.out.println("I am a new feature");
    }
}


class ConcreteAClass extends TestAbstractClassSuper {

    public int doThis() {

        return 1;
    }

@Override
    public void doNew(){

        System.out.println("I am implementing new");
    }

    public static void main(String[] args) {
        ConcreteAClass concreteAClass = new ConcreteAClass();
        concreteAClass.doNew();
    }
}

