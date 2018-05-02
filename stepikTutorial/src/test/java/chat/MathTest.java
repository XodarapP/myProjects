package chat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSum() throws Exception {
        // установка
        Math math = new Math(3,2);

        //действие
        int result = math.getSum();

        //проверка
        assertEquals(5, result);
    }

}