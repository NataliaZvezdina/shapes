package by.zvezdina.shapes.reader;

import by.zvezdina.shapes.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readLines(String filePath) throws EllipseException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filePath);
        File file = new File(resource.getFile());
        Path path = file.toPath();

        logger.log(Level.INFO, "Read file " + filePath);
        List<String> lines = new ArrayList<>();
        try(Stream<String> streamLines = Files.lines(path)) {
            lines = streamLines.peek(line -> logger.log(Level.INFO, line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file " + filePath);
            throw new EllipseException("Error while reading file " + filePath, e);
        }
        return lines;
    }
}
