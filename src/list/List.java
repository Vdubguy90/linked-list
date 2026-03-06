
package list;

public interface List<T extends Comparable<T>> {

    int size();
    boolean isEmpty();
    void addLast(T element);
    void addFirst(T element);
    void addAtIndex(int index, T element);
    T get(int i);
    int nodesAfter(T target);
<<<<<<< HEAD
    void printList();
    void swapPairs();

    /**
     * Sort the list using Mergesort
     */
    void sort();
=======

    /**
     * Sort the list using mergSort()
     */
    void sort();


}
