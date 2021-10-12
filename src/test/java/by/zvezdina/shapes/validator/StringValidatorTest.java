package by.zvezdina.shapes.validator;

import  static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringValidatorTest {

    @DataProvider(name="testLines")
    public Object[][] createData() {
        return new Object[][] {
                {"3 44 3.1 11.3", true},
                {"ww 3 1 3", false},
                {"-1.32 4.5 6.8 -3.1", true},
                {"s 5 6.5 -2", false},
                {"2.3 5.1  0.3 -2.5", false}
        };
    }

    @Test(dataProvider = "testLines")
    public void testIsLineValid(String line, boolean expected) {

        boolean actual = StringValidator.isLineValid(line);

        assertEquals(actual, expected);
    }
}
