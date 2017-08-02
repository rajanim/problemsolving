package basics.generics.generics_2;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class ThirdLocker<T> {

    private T content1;
    private T content2;

    public ThirdLocker() {
        this(null, null);
    }

    public ThirdLocker(T item1, T item2) {
        storeItem1(item1);
        storeItem2(item2);
    }

    public void storeItem1(T item1) {
        this.content1 = item1;
    }

    public void storeItem2(T item2) {
        this.content2 = item2;
    }
}
