<<<<<<< HEAD
package list;

import org.junit.Test;

public class LinkedList<T> implements List<T> {

     private static class Node<T> {
          public T data;        // The state of the inner class
          public Node next;     // Pointer to next element
     }

     private int size;
     
     private Node head;       // Start of the list, 
                              // has to point to the next element in the list

     public LinkedList() {
          this.size  = 0;
     }
     
     @Override
     public int size() {
          return this.size;
     }

     @Override
     public boolean isEmpty(){
          return (size == 0);
     }

     @Override
     public void add(T element){
          size++;
          
     }
=======

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


>>>>>>> 0d500c264eb1b541d05cd79a581c0835eda15a7d
}
