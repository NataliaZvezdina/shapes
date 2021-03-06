package by.zvezdina.shapes.parser.impl;

import by.zvezdina.shapes.parser.EllipseParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class EllipseParserImpl implements EllipseParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMITER = "\\s";

    public double[] parseLine(String line) {

        String[] stringDoubles = line.split(DELIMITER);
        double[] doubles = Arrays.stream(stringDoubles).mapToDouble(Double::parseDouble).toArray();
        logger.log(Level.INFO, "Result of parsing line: " + Arrays.toString(doubles));
        return doubles;
    }
}
