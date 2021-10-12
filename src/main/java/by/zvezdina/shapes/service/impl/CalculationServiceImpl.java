package by.zvezdina.shapes.service.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;
import by.zvezdina.shapes.service.CalculationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculationServiceImpl implements CalculationService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public double calculatePerimeter(Ellipse ellipse) {
        Point point1 = ellipse.getPoint1();
        Point point2 = ellipse.getPoint2();

        double axisX = Math.abs(point1.getX() - point2.getX());
        double axisY = Math.abs(point1.getY() - point2.getY());

        double perimeter = 2 * Math.PI * Math.sqrt((axisX * axisX + axisY * axisY) / 8);
        logger.log(Level.INFO, ellipse + " Perimeter= " + perimeter);

        return perimeter;
    }

    @Override
    public double calculateSquare(Ellipse ellipse) {
        Point point1 = ellipse.getPoint1();
        Point point2 = ellipse.getPoint2();

        double semiaxisX = Math.abs(point1.getX() - point2.getX()) / 2;
        double semiaxisY = Math.abs(point1.getY() - point2.getY()) / 2;

        double square = Math.PI * semiaxisX * semiaxisY;
        logger.log(Level.INFO, ellipse + " Square= " + square);
        return square;
    }

    @Override
    public boolean checkIfCircle(Ellipse ellipse) {
        Point point1 = ellipse.getPoint1();
        Point point2 = ellipse.getPoint2();

        double semiaxisX = Math.abs(point1.getX() - point2.getX()) / 2;
        double semiaxisY = Math.abs(point1.getY() - point2.getY()) / 2;

        double focalDistance = (semiaxisY * semiaxisY - semiaxisX * semiaxisX);
        boolean result = focalDistance == 0;

        logger.log(Level.INFO, ellipse + " is circle: " + result);
        return result;
    }
}
