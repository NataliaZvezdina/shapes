package by.zvezdina.shapes.validator;

import by.zvezdina.shapes.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseValidator {
    private static final Logger logger = LogManager.getLogger();

    public static boolean isEllipseValid(Point point1, Point point2) {
        boolean result = point1.getX() != point2.getX() && point1.getY() != point2.getY();
        logger.log(Level.INFO, "Check points: " + point1 + " and " + point2 + " for valid ellipse : " +
                result);
        return result;
    }
}
