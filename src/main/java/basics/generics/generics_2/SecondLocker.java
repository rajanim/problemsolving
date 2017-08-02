package basics.generics.generics_2;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class SecondLocker<T1, T2> {

    private T1 content1;
    private T2 content2;

    public SecondLocker() {

        this(null, null);
    }

    public SecondLocker(T1 item1, T2 item2) {
        storeItemOne(item1);
        storeItemTwo(item2);
    }

    public void storeItemOne(T1 item) {
        content1 = item;
    }

    public void storeItemTwo(T2 item) {
        content2 = item;
    }

    public T1 retrieveItem1() {
        return content1;
    }

    public T2 retrieveItem2() {
        return content2;
    }
}
