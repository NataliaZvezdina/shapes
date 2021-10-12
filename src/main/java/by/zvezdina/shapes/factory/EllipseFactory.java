package by.zvezdina.shapes.factory;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;
import by.zvezdina.shapes.validator.EllipseValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class EllipseFactory {
    private static final Logger logger = LogManager.getLogger();

    public static Ellipse createEllipse(double[] coordinates) {
        Point point1 = new Point(coordinates[0], coordinates[1]);
        Point point2 = new Point(coordinates[2], coordinates[3]);

        if (!EllipseValidator.isEllipseValid(point1, point2)) {
            logger.log(Level.ERROR, "Cannot create ellipse from data: " + Arrays.toString(coordinates));
        }

        Ellipse ellipse = new Ellipse(point1, point2);
        logger.log(Level.INFO, "New ellipse created: " + ellipse);
        return ellipse;
    }
}
