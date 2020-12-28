import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testFlik() {
        Flik f = new Flik();
        assertFalse(Flik.isSameNumber(1,2));
        assertTrue(Flik.isSameNumber(500,500));
    }
}
