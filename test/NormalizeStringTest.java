

import org.junit.Test;
import static org.junit.Assert.*;

public class NormalizeStringTest {
    @Test
    public void testNormalize() {
        assertEquals("Hello World This Is A Test", NormalizeString.normalize(" Hello! World@ This is a Test!. "));
    }
}
