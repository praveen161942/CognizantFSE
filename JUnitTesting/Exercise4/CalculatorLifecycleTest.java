import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorLifecycleTest {

    private Calculator calc;

    @Before
    public void setUp() {
        // Arrange - Before each test
        calc = new Calculator();
        System.out.println("Setting up...");
    }

    @After
    public void tearDown() {
        // Teardown - After each test
        calc = null;
        System.out.println("Tearing down...");
    }

    @Test
    public void testAdd() {
        // Act
        int result = calc.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        int result = calc.subtract(10, 5);
        assertEquals(5, result);
    }
}