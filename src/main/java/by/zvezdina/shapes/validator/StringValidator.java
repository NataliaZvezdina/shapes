package by.zvezdina.shapes.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String LINE_REGEXP = "^(-?\\d+(\\.\\d+)?\\s){3}(-?\\d+(\\.\\d+)?)$";

    public static boolean isLineValid(String line) {
        boolean result = line.matches(LINE_REGEXP);
        logger.log(Level.INFO, "Check line on validity: " + line + " - " + result);
        return result;
    }
}
