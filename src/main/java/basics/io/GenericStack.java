package basics.io;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class GenericStack<E> {

    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public  int getSize(){
        return list.size();
    }

    public E peek(){
        return list.get(getSize()-1);
    }

        public void push(E ob){
            list.add(ob);
    }


    public  E pop(){
            E ob = list.get(getSize()-1);
            list.remove(getSize()-1);
            return ob;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

}
