package by.zvezdina.shapes.application;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.exception.EllipseException;
import by.zvezdina.shapes.factory.EllipseFactory;
import by.zvezdina.shapes.parser.StringParser;
import by.zvezdina.shapes.reader.CustomReader;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

import java.util.List;

public class Application {
    private static final String FILE_PATH1 = "data/example1.txt";

    public static void main(String[] args) throws EllipseException {

        CustomReader reader = new CustomReader();
        List<String> lines = reader.readLines(FILE_PATH1);
        lines.forEach(System.out::println);

        StringParser parser = new StringParser();
        double[] doubles = parser.parseLine(lines.get(0));

        Ellipse ellipse = EllipseFactory.createEllipse(doubles);

        CalculationService service = new CalculationServiceImpl();
        service.calculateSquare(ellipse);
        service.calculatePerimeter(ellipse);
        service.checkIfCircle(ellipse);

    }
}
