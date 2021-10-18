package by.zvezdina.shapes.reader;

import by.zvezdina.shapes.exception.EllipseException;

import java.util.List;

public interface EllipseReader {

    List<String> readLines(String filePath) throws EllipseException;
}
