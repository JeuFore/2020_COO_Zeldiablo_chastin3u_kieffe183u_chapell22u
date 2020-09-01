import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestApp {

    @Test
    public void test() {
        assertFalse(false);
    }

    @Test
    public void test1() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        assertEquals("expected", 1, 1);
    }

    @Test
    public void test3() {
        assertNotEquals("message", 1, 0);
    }

}