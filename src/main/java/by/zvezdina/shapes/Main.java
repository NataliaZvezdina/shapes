package by.zvezdina.shapes;

import by.zvezdina.shapes.comparator.PerimeterComparator;
import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.EllipseParameter;
import by.zvezdina.shapes.entity.Point;
import by.zvezdina.shapes.entity.Warehouse;
import by.zvezdina.shapes.exception.EllipseException;
import by.zvezdina.shapes.factory.EllipseFactory;
import by.zvezdina.shapes.observer.EllipseObserver;
import by.zvezdina.shapes.observer.impl.EllipseObserverImpl;
import by.zvezdina.shapes.parser.impl.EllipseParserImpl;
import by.zvezdina.shapes.reader.impl.EllipseReaderImpl;
import by.zvezdina.shapes.repository.EllipseRepository;
import by.zvezdina.shapes.repository.EllipseSpecification;
import by.zvezdina.shapes.repository.impl.DegenerateEllipseSpecificationImpl;
import by.zvezdina.shapes.repository.impl.IdRangeSpecificationImpl;
import by.zvezdina.shapes.repository.impl.IdSpecificationImpl;
import by.zvezdina.shapes.repository.impl.PerimeterRangeSpecificationImpl;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    private static final String FILE_PATH1 = "data/example1.txt";

    public static void main(String[] args) throws EllipseException {

        EllipseReaderImpl reader = new EllipseReaderImpl();
        List<String> lines = reader.readLines(FILE_PATH1);


        EllipseParserImpl parser = new EllipseParserImpl();
        List<Ellipse> ellipses = lines.stream()
                .map(parser::parseLine)
                .map(EllipseFactory::createEllipse)
                .filter(Optional::isPresent)
                .map(Optional::get)
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


        EllipseSpecification specification1 = new PerimeterRangeSpecificationImpl(20, 25);
        List<Ellipse> selectByPerimeter = repository.query(specification1);
        System.out.println("Query -> select by perimeter from 20 to 25:");
        selectByPerimeter.forEach(System.out::println);

        EllipseSpecification specification2 = new IdRangeSpecificationImpl(3, 6);
        List<Ellipse> selectedWithinIdRange = repository.query(specification2);
        System.out.println("Query -> select by id from 3 to 6");
        selectedWithinIdRange.forEach(System.out::println);

        EllipseSpecification specification3 = new IdSpecificationImpl(4);
        List<Ellipse> selectedById = repository.query(specification3);
        System.out.println("Query -> selected by id = 4");
        selectedById.forEach(System.out::println);

        EllipseSpecification specification4 = new DegenerateEllipseSpecificationImpl();
        List<Ellipse> selectedDegenerate = repository.query(specification4);
        System.out.println("Query -> degenerate ellipses selected");
        selectedDegenerate.forEach(System.out::println);

    }
}
