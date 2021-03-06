package by.zvezdina.shapes.comparator;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

import java.util.Comparator;

public class SquareComparator implements Comparator<Ellipse> {

    @Override
    public int compare(Ellipse ellipse1, Ellipse ellipse2) {
        CalculationService service = new CalculationServiceImpl();
        double square1 = service.calculateSquare(ellipse1);
        double square2 = service.calculateSquare(ellipse2);
        return Double.compare(square1, square2);
    }
}
