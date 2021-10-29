package by.zvezdina.shapes.factory;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;
import by.zvezdina.shapes.validator.EllipseValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

public class EllipseFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final int CORRECT_NUMBER_OF_COORDINATES = 4;
    private static final int FIRST_COORDINATE_INDEX = 0;
    private static final int SECOND_COORDINATE_INDEX = 1;
    private static final int THIRD_COORDINATE_INDEX = 2;
    private static final int FOURTH_COORDINATE_INDEX = 3;

    public static Optional<Ellipse> createEllipse(double[] coordinates) {
        if (coordinates.length != CORRECT_NUMBER_OF_COORDINATES) {
            logger.log(Level.INFO, "Cannot create create ellipse from data: " + Arrays.toString(coordinates) +
                    " Incorrect number of coordinates");
            return Optional.empty();
        }

        Point point1 = new Point(coordinates[FIRST_COORDINATE_INDEX], coordinates[SECOND_COORDINATE_INDEX]);
        Point point2 = new Point(coordinates[THIRD_COORDINATE_INDEX], coordinates[FOURTH_COORDINATE_INDEX]);

        if (!EllipseValidator.isEllipseValid(point1, point2)) {
            logger.log(Level.INFO, "Cannot create ellipse from data: " + Arrays.toString(coordinates));
            return Optional.empty();
        }

        Ellipse ellipse = new Ellipse(point1, point2);
        logger.log(Level.INFO, "New ellipse created: " + ellipse);
        return Optional.of(ellipse);
    }
}
