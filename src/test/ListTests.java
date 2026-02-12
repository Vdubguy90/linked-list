
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import list.*;

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
        doubleList.add(0.123);

        // Assert
        assertEquals(size + 1, doubleList.size());
    }

}