package by.zvezdina.shapes.validator;

import by.zvezdina.shapes.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EllipseValidatorTest {

    @DataProvider(name="dataPr")
    public Object[][] createData() {
        return new Object[][] {
                {new Point(3, 44), new Point(3.1, 11.3), true},
                {new Point(-1, 3), new Point(1, 3), false},
                {new Point(-1.32, 4.5), new Point(6.8, -3.1), true},
                {new Point(6.5, 5), new Point(6.5, -2), false},
                {new Point(2.3, -2.5), new Point(0.3, -2.5), false}
        };
    }

    @Test(dataProvider = "dataPr")
    public void testIsEllipseValid(Point point1, Point point2, boolean expected) {

        boolean actual = EllipseValidator.isEllipseValid(point1, point2);

        assertEquals(actual, expected);
    }

}
