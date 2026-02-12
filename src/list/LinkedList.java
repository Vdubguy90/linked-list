
package list;

public class LinkedList<T> implements List<T> {

    private int size;

    public LinkedList() {
        this.size = 0;
    }


    @Override 
    public int size() {
        return this.size;
    }

    @Override 
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void add(T element) {
        size++;
    }


}
