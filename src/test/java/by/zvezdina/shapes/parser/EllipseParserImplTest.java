package by.zvezdina.shapes.parser;

import by.zvezdina.shapes.exception.EllipseException;

import static org.testng.Assert.*;

import by.zvezdina.shapes.parser.impl.EllipseParserImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EllipseParserImplTest {
    private EllipseParserImpl parser = new EllipseParserImpl();
    private String incorrectLine = "bb 9 -2.4 0";

    @DataProvider(name = "dataPr")
    public Object[][] createData() {
        return new Object[][]{
                {"2.3 -1.5 7 6.75", new double[]{2.3, -1.5, 7, 6.75}},
                {"-14.3 8.5 10.15 -9.2", new double[]{-14.3, 8.5, 10.15, -9.2}},
                {"6.8 15.5 -3.4 -1.3", new double[]{6.8, 15.5, -3.4, -1.3}}
        };
    }

    @Test(dataProvider = "dataPr")
    public void testParseLine(String line, double[] expected) throws EllipseException {

        double[] actual = parser.parseLine(line);

        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = EllipseException.class)
    public void testParseLineExceptionExpected() throws EllipseException {

        parser.parseLine(incorrectLine);
    }
}
