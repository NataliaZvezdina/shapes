package by.zvezdina.shapes.repository.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.repository.EllipseSpecification;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

public class PerimeterRangeSpecificationImpl implements EllipseSpecification {
    private double from;
    private double to;

    public PerimeterRangeSpecificationImpl(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        CalculationService service = new CalculationServiceImpl();
        double perimeter = service.calculatePerimeter(ellipse);

        return perimeter >= from && perimeter <= to;
    }
}
