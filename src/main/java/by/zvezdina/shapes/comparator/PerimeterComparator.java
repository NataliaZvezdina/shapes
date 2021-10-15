package by.zvezdina.shapes.comparator;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        CalculationService service = new CalculationServiceImpl();
        double perimeter1 = service.calculatePerimeter(o1);
        double perimeter2 = service.calculatePerimeter(o2);
        return Double.compare(perimeter1, perimeter2);
    }
}
