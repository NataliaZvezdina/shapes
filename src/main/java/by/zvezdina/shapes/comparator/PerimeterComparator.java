package by.zvezdina.shapes.comparator;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Ellipse> {

    @Override
    public int compare(Ellipse ellipse1, Ellipse ellipse2) {
        CalculationService service = new CalculationServiceImpl();
        double perimeter1 = service.calculatePerimeter(ellipse1);
        double perimeter2 = service.calculatePerimeter(ellipse2);
        return Double.compare(perimeter1, perimeter2);
    }
}
