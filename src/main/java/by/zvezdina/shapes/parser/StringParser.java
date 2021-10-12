package by.zvezdina.shapes.parser;

import by.zvezdina.shapes.exception.EllipseException;
import by.zvezdina.shapes.validator.StringValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class StringParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMITER = "\\s";

    public double[] parseLine(String line) throws EllipseException {
        if (!StringValidator.isLineValid(line)) {
            logger.log(Level.ERROR, "Cannot parse, incorrect line: " + line);
            throw new EllipseException("Cannot parse, incorrect line: " + line);
        }

        String[] stringDoubles = line.split(DELIMITER);
        double[] doubles = Arrays.stream(stringDoubles).mapToDouble(Double::parseDouble).toArray();
        logger.log(Level.INFO, "Result of parsing line: " + Arrays.toString(doubles));
        return doubles;
    }
}
