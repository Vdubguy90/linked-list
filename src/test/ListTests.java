
package test;

import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;

import list.*;
import model.*;

public class ListTests {

    @Test
    public void TestListConstructor() {
        // Arrange
        LinkedList<Integer> intList = new LinkedList<>();
        
        // Act

        // Assert
        assertNotNull(intList);
        
    }

    @Test
    public void testSizeEmptyList() {
        // Arrange
        LinkedList<String> strList = new LinkedList<String>();

        // Act

        // Assert
        assertEquals(0, strList.size());

    }

    @Test
    public void testIsEmptyEmptyList() {
        // Arrange
        LinkedList<Boolean> booleanList = new LinkedList<>();

        // Act

        // Assert
        assertEquals(true, booleanList.isEmpty());
    }

    @Test
    public void testSizeIncreaseAdd() {
        // Arrange
        LinkedList<Double> doubleList = new LinkedList<>();
        int size = doubleList.size();

        // Act
        doubleList.addLast(0.123);

        // Assert
        assertEquals(size + 1, doubleList.size());
    }

    @Test
    public void testAddElement() {
        // Arrange
        LinkedList<String> strList = new LinkedList<>();

        // Act
        strList.addLast("A");

        // Assert
        assertEquals("[A] size = 1, head: null, tail: A", strList.toString());

    }

    @Test
    public void testAddTwoElements() {
        // Arrange
        LinkedList<String> strList = new LinkedList<>();

        // Act
        strList.addLast("A");
        strList.addLast("B");

        // Assert
        assertEquals("[A, B] size = 2, head: null, tail: B", strList.toString());

    }

    @Test 
    public void testGet() {
        // Arrange
        List<Boolean> boolList = new LinkedList<Boolean>();
        boolList.addLast(true);
        boolList.addLast(false);
        
        // Act
        boolean result = boolList.get(1);

        // Assert
        assertEquals(false, result);
    }

    @Test 
    public void testOutsideBounds() {
        // Arrange
        List<Boolean> blist = new LinkedList<>();
        blist.addLast(true);
        blist.addLast(true);
        blist.addLast(true);

        // Act
        //Boolean res = blist.get(10000);
        //assertNull(res);

        // Assert
        assertThrows(
            
            IndexOutOfBoundsException.class, 
            
            () -> {
                // Act
                Boolean bres = blist.get(10000);
            }
    
        );

    }

    @Test 
    public void testOutOfBoundsReturnsNull() {
        // Arrange
        List<Integer> l = new LinkedList<>();

        // Act
        Integer res = l.get(-2000);

        // Assert
        assertNull(res);
    }

    @Test
    public void testAddFirstToEmptyList() {
        // Arrange
        List<Double> list = new LinkedList<>();

        // Act
        list.addFirst(1.0);

        // Assert
        assertEquals("[1.0] size = 1, head: null, tail: 1.0", list.toString());
    }

    @Test
    public void testAddFirstToNonEmptyList() {
        // Arrange
        List<Double> list = new LinkedList<>();
        list.addLast(1.0);
        list.addLast(1.1);

        // Act
        list.addFirst(0.9);


        // Assert
        assertEquals("[0.9, 1.0, 1.1] size = 3, head: null, tail: 1.1", list.toString());
    }

    @Test
    public void testAddAtIndexToNonEmptyList() {
        // Arrange
        List<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);


        // Act
        list.addAtIndex(2, 4);


        // Assert
        assertEquals("[1, 2, 4, 3] size = 4, head: null, tail: 3", list.toString());
    }

    @Test
    public void testAddAtIndex1() {
        // Arrange
        List<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // Act
        list.addAtIndex(1, 4);

        // Assert
        assertEquals("[1, 4, 2, 3] size = 4, head: null, tail: 3", list.toString());
    }

    @Test
    public void testNodesAfter() {
        // Arrange
        List<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");

        // Act
        int nodesAfterA = list.nodesAfter("A");
        int nodesAfterB = list.nodesAfter("B");
        int nodesAfterC = list.nodesAfter("C");
        int nodesAfterD = list.nodesAfter("D");

        // Assert
        assertEquals(3, nodesAfterA);
        assertEquals(2, nodesAfterB);
        assertEquals(1, nodesAfterC);
        assertEquals(0, nodesAfterD);
    }

    @Test
    public void testCompares() {

        // Arrange
        List<Person> people = new LinkedList<>();

        people.addLast(new Person("Alice", 20));
        people.addLast(new Person("Bob", 21));
        people.addLast(new Person("Alice", 21));

        // Act
        int res1 = people.get(0).compareTo(people.get(1));
        int res2 = people.get(0).compareTo(people.get(2));
        

        // Assert
        assertTrue(people.get(0) instanceof Comparable);
        assertTrue((res1 < 0));
        assertTrue((res2 < 0));


    }

    @Test
    public void testSwapPairs() {

        // Arrange
        List<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        List<String> list2 = new LinkedList<>();
        list2.addLast("A");
        list2.addLast("B");


        List<Boolean> list3 = new LinkedList<>();
        list3.addLast(true);
        list3.addLast(false);
        list3.addLast(true);

        // Act
        list.swapPairs();
        list2.swapPairs();
        list3.swapPairs();

        // Assert
        assertEquals("[2, 1, 4, 3, 5] size = 5, head: null, tail: 5", list.toString());
        assertEquals("[B, A] size = 2, head: null, tail: A", list2.toString());
        assertEquals("[false, true, true] size = 3, head: null, tail: true", list3.toString());
    }


    @Test 
    public void testMergesort() {
        // Arrange
        List<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("C");
        list.addLast("B");
        list.addLast("A");

        // Act
        list.sort();

        // Assert
        String expected = "[A, A, B, C] size = 4, head: null, tail: C";
        String actual = list.toString();

        assertEquals(expected, actual);

    }

    @Test 
    public void testMergeSortEmptyList() {
        // Arrange
        List<Integer> intList = new LinkedList<>();

        // Act
        intList.sort();

        // Assert
        String expected = "[] size = 0, head: null, tail: null";
        String actual = intList.toString();
        assertEquals(expected, actual);
    }

}
