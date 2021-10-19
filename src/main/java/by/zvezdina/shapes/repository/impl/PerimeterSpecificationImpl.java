package by.zvezdina.shapes.repository.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.repository.EllipseSpecification;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

public class PerimeterSpecificationImpl implements EllipseSpecification {
    private double perimeter;

    public PerimeterSpecificationImpl(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        CalculationService service = new CalculationServiceImpl();        ;
        return perimeter == service.calculatePerimeter(ellipse);
    }
}
