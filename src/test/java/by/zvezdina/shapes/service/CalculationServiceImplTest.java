package by.zvezdina.shapes.service;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;
import  static org.testng.Assert.*;

import by.zvezdina.shapes.service.impl.CalculationServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculationServiceImplTest {
    CalculationServiceImpl service = new CalculationServiceImpl();
    private double delta = 0.001;

    @DataProvider(name = "perimeterTest")
    public Object[][] createDataPerimeterTest() {
        return new Object[][] {
                {new Ellipse(new Point(2.4, 5.8), new Point(3.8, 10)), 9.835},
                {new Ellipse(new Point(-3.5, 2.3), new Point(2.4, 5.45)), 14.858}
        };
    }

    @Test(dataProvider = "perimeterTest")
    public void testCalculatePerimeter(Ellipse ellipse, double expected) {

        double actual = service.calculatePerimeter(ellipse);

        assertEquals(actual, expected, delta);
    }

    @DataProvider(name = "squareTest")
    public Object[][] createDataSquareTest() {
        return new Object[][] {
                {new Ellipse(new Point(2.4, 5.8), new Point(3.8, 10)), 4.618},
                {new Ellipse(new Point(-3.5, 2.3), new Point(2.4, 5.45)), 14.596}
        };
    }

    @Test(dataProvider = "squareTest")
    public void testCalculateSquare(Ellipse ellipse, double expected) {

        double actual = service.calculateSquare(ellipse);

        assertEquals(actual, expected, delta);
    }

    @DataProvider(name = "checkIfCircleTest")
    public Object[][] createDataCircleTest() {
        return new Object[][] {
                {new Ellipse(new Point(-1.4, -1.4), new Point(1.4, 1.4)), true},
                {new Ellipse(new Point(-3.5, 2.3), new Point(2.4, 5.45)), false}
        };
    }

    @Test(dataProvider = "checkIfCircleTest")
    public void testCheckIfCircle(Ellipse ellipse, boolean expected) {

        boolean actual = service.checkIfDegenerate(ellipse);

        assertEquals(actual, expected);
    }

}
