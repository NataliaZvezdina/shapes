package by.zvezdina.shapes.reader;

import by.zvezdina.shapes.exception.EllipseException;
import  static org.testng.Assert.*;

import by.zvezdina.shapes.reader.impl.EllipseReaderImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class EllipseReaderImplTest {
    private EllipseReaderImpl reader = new EllipseReaderImpl();
    private static final String PATH1 = "test1.txt";
    private static final String PATH2 = "test2.txt";
    private static final String PATH3 = "test3.txt";

    @DataProvider(name="read test files")
    public Object[][] dataProvider() {
        return new Object[][] {
                {PATH1, List.of("-2.4 5 7.5 1.25", "3 5.4 2.1 -1.5", "3 4.1 -3.5 0")},
                {PATH2, List.of("23 4 5 6", "1 3 -1 2", "3.1 7.5 -5 8", "-4.3 9.1 0.5 3")},
                {PATH3, List.of("9 -11 2 2.3", "4.2 5 6.6 7", "3 -5 9 1")}
        };
    }

    @Test(dataProvider = "read test files")
    public void testReadLines(String filePath, List<String> expected) throws EllipseException {

        List<String> actual = reader.readLines(filePath);

        assertEquals(actual, expected);
    }
}
