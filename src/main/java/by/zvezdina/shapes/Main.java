package by.zvezdina.shapes;

import by.zvezdina.shapes.comparator.EllipticityComparator;
import by.zvezdina.shapes.comparator.PerimeterComparator;
import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.EllipseParameter;
import by.zvezdina.shapes.entity.Point;
import by.zvezdina.shapes.entity.Warehouse;
import by.zvezdina.shapes.exception.EllipseException;
import by.zvezdina.shapes.factory.EllipseFactory;
import by.zvezdina.shapes.observer.EllipseObserver;
import by.zvezdina.shapes.observer.impl.EllipseObserverImpl;
import by.zvezdina.shapes.parser.StringParser;
import by.zvezdina.shapes.reader.CustomReader;
import by.zvezdina.shapes.repository.EllipseRepository;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;
import by.zvezdina.shapes.validator.EllipseValidator;
import by.zvezdina.shapes.validator.StringValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String FILE_PATH1 = "data/example1.txt";

    public static void main(String[] args) throws EllipseException {

        CustomReader reader = new CustomReader();
        List<String> lines = reader.readLines(FILE_PATH1);


        StringParser parser = new StringParser();
        List<Ellipse> ellipses = lines.stream()
                .filter(StringValidator::isLineValid)
                .map(parser::parseLine)
                .filter(arr -> EllipseValidator.isEllipseValid(new Point(arr[0], arr[1]), new Point(arr[2], arr[3])))
                .map(EllipseFactory::createEllipse)
                .collect(Collectors.toList());

        CalculationService service = new CalculationServiceImpl();
        ellipses.forEach(service::calculateSquare);
        ellipses.forEach(service::calculatePerimeter);
        ellipses.forEach(service::checkIfDegenerate);

        Warehouse warehouse = Warehouse.getInstance();
        for (Ellipse ellipse : ellipses) {
            double square = service.calculateSquare(ellipse);
            double perimeter = service.calculatePerimeter(ellipse);
            EllipseParameter parameter = new EllipseParameter(perimeter, square);
            warehouse.put(ellipse.getEllipseId(), parameter);
        }



        EllipseObserver observer1 = new EllipseObserverImpl();
        EllipseObserver observer2 = new EllipseObserverImpl();

        Ellipse ellipse = ellipses.get(0);
        ellipse.attach(observer1);
        ellipse.attach(observer2);

        System.out.println(warehouse.get(ellipse.getEllipseId()));

        ellipse.setPoint1(new Point(3.5, 4.5));
        EllipseParameter parameterUpdated = warehouse.get(ellipse.getEllipseId());
        System.out.println(parameterUpdated);

        System.out.println();

        EllipseRepository repository = EllipseRepository.getInstance();
        repository.addAll(ellipses);
        List<Ellipse> sortedByPerimeter = repository.sort(new PerimeterComparator());
        System.out.println("After sorting by perimeter: ");
        sortedByPerimeter.forEach(System.out::println);

        List<Ellipse> sortedByEllipticity = repository.sort(new EllipticityComparator());
        System.out.println("After sorting by ellipticity: ");
        sortedByEllipticity.forEach(System.out::println);

    }
}
