
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UnitTests {

    @Test
    public void TestAdd() {
        // Arrange
        int i = 1;
        int j = 2;
        
        // Act
        int sum = i + j;

        // Assert
        assertEquals(4, sum);
        
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testParams(int i) {
        // Arrange
        int j = 0; 

        // Act
        int sum = i + j;

        // Assert
        assertEquals(2, sum);
    }

}
