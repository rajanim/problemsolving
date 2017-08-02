package basics.generics.generics_2;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class FifthLocker<T extends Number> {

    private T content;

    public FifthLocker(){
        this(null);
    }
    public FifthLocker(T item){
        store(item);
    }

    public void store(T item){
        content = item;
    }

    public T retrieve(){
        return content;
    }
    public boolean isSameValue(FifthLocker<?> item){
        return this.content.doubleValue() == item.content.doubleValue();

    }

}
