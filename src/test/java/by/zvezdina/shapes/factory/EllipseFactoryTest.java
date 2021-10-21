package by.zvezdina.shapes.factory;

import java.util.Optional;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseFactoryTest {

    @DataProvider(name = "positive")
    public Object[][] createData() {
        return new Object[][]{
                {new double[]{2.3, -1.5, 7, 6.75},
                        Optional.of(new Ellipse(new Point(2.3, -1.5), new Point(7, 6.75)))},
                {new double[]{-14.3, 8.5, 10.15, -9.2},
                        Optional.of(new Ellipse(new Point(-14.3, 8.5), new Point(10.15, -9.2)))},
                {new double[]{6.8, 15.5, -3.4, -1.3},
                        Optional.of(new Ellipse(new Point(6.8, 15.5), new Point(-3.4, -1.3)))}
        };
    }

    @Test(dataProvider = "positive")
    public void testCreateEllipse(double[] coordinates, Optional<Ellipse> expected) {
        Optional<Ellipse> actual = EllipseFactory.createEllipse(coordinates);

        assertEquals(actual, expected);
    }

    @DataProvider(name = "incorrectCoordinatesNumber")
    public Object[][] createDataIncorrectInputParameter() {
        return new Object[][]{
                {new double[]{2.3, -1.5},
                        Optional.empty()},
                {new double[]{-14.3, 8.5, 10.15, -9.2, 5.8},
                        Optional.empty()},
                {new double[]{6.8, 15.5, -3.4},
                        Optional.empty()}
        };
    }

    @Test(dataProvider = "incorrectCoordinatesNumber")
    public void testCreateEllipseReturnOptionalEmpty(double[] coordinates, Optional<Ellipse> expected) {
        Optional<Ellipse> actual = EllipseFactory.createEllipse(coordinates);

        assertEquals(actual, expected);
    }

    @DataProvider(name = "invalidDataForCreatingEllipse")
    public Object[][] createDataInvalidEllipse() {
        return new Object[][]{
                {new double[]{2.3, -1.5, 2.3, 6.75},
                        Optional.empty()},
                {new double[]{-14.3, 8.5, 10.15, 8.5},
                        Optional.empty()},
                {new double[]{6.8, 15.5, -3.4, 15.5},
                        Optional.empty()}
        };
    }

    @Test(dataProvider = "invalidDataForCreatingEllipse")
    public void testCreateEllipseReturnOptionalEmptyInvalidEllipse(double[] coordinates, Optional<Ellipse> expected) {
        Optional<Ellipse> actual = EllipseFactory.createEllipse(coordinates);

        assertEquals(actual, expected);
    }
}