package by.zvezdina.shapes.reader;

import by.zvezdina.shapes.exception.EllipseException;
import  static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.util.List;

public class CustomReaderTest {
    private CustomReader reader = new CustomReader();
    private static final String PATH1 = "test1.txt";
    private static final String PATH2 = "test2.txt";
    private static final String PATH3 = "test3.txt";

    @DataProvider(name="read test files")
    public Object[][] dataProvider() {
        return new Object[][] {
                {PATH1, List.of("3 5 ff", "er 5 77", "1  3     8", "vfg t")},
                {PATH2, List.of("23 4 5 6", "1 3", "3", "0 bb")}
        };
    }

    @Test(dataProvider = "read test files")
    public void testReadLines(String filePath, List<String> expected) throws EllipseException {

        List<String> actual = reader.readLines(filePath);
        assertEquals(actual, expected);
    }
}
