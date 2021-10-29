package by.zvezdina.shapes.repository.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdRangeSpecificationImplTest {
    private int testMinId = 2;
    private int testMaxId = 4;
    private IdRangeSpecificationImpl specification = new IdRangeSpecificationImpl(testMinId, testMaxId);

    @DataProvider(name = "specifyEllipse")
    public Object[][] createData() {
        return new Object[][]{
                {new Ellipse(new Point(-2.3, -4.5), new Point(2.1, 8.7)), false},
                {new Ellipse(new Point(1.1, 1.1), new Point(4, 4)), true}
        };
    }

    @Test(dataProvider = "specifyEllipse")
    public void testSpecify(Ellipse ellipse, boolean expected) {

        boolean actual = specification.specify(ellipse);

        assertEquals(actual, expected);
    }

}