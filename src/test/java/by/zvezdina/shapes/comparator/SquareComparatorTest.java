package by.zvezdina.shapes.comparator;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class SquareComparatorTest {
    private SquareComparator comparator = new SquareComparator();

    @DataProvider(name = "compareSquare")
    public Object[][] createData() {
        return new Object[][]{
                {new Ellipse(new Point(-2.3, -4.5), new Point(2.1, 8.7)),
                        new Ellipse(new Point(1.2, 2.3), new Point(2.5, 3.5)), 1},
                {new Ellipse(new Point(1.1, 2.3), new Point(2.4, 2.8)),
                        new Ellipse(new Point(2.5, 3.5), new Point(6.8, 8.5)), -1}
        };
    }

    @Test(dataProvider = "compareSquare")
    public void testCompare(Ellipse ellipse1, Ellipse ellipse2, int expected) {

        int actual = comparator.compare(ellipse1, ellipse2);

        assertEquals(actual, expected);
    }
}