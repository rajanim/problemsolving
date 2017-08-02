package basics.generics.generics_2;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class Locker<T> {
    private T content;

    public Locker() {
        store(null);
    }

    public void store(T item) {
        content = item;
    }

    public T retrieve() {
        return content;
    }
}
