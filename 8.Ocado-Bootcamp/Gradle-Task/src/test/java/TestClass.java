import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;


public class TestClass {

    private FibonacciTask fibonacciTask;


    @Test
    public void testShouldReturnFibNumberForValidInput() {
        long expected = 5;
        Assertions.assertEquals(expected, FibonacciTask.getFibNumber(5, new HashMap<>()));
    }

    @Test
    public void testShouldThrowExceptionForNegativeNumberInput() throws IllegalArgumentException {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,() -> FibonacciTask.tryParseToNumber("-1"));
        assertTrue(thrown.getMessage().contains("Number must be positive!"));
    }
}
