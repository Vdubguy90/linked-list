
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {

    @Test
    public void TestAdd() {
        // Arrange
        int i = 1;
        int j = 2;
        
        // Act
        int sum = i + j;

        // Assert
        assertEquals(3, sum);
        
    }

}
