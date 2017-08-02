package basics.generics.generics_2;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class FourthLocker<T extends Number> {

    private Object content;

    public FourthLocker(){
        this(null);
    }

    public FourthLocker(T item){
        store(item);
    }

    public void store(T item){
        content = item;
    }

    public T retrieve(){
        return (T) content;
    }
}
