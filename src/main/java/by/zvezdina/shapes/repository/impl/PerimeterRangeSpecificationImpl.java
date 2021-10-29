package by.zvezdina.shapes.repository.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.repository.EllipseSpecification;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

public class PerimeterRangeSpecificationImpl implements EllipseSpecification {
    private double min;
    private double max;

    public PerimeterRangeSpecificationImpl(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        CalculationService service = new CalculationServiceImpl();
        double perimeter = service.calculatePerimeter(ellipse);

        return perimeter >= min && perimeter <= max;
    }
}
