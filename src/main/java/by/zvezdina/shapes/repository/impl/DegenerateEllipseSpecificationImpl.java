package by.zvezdina.shapes.repository.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.repository.EllipseSpecification;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;

public class DegenerateEllipseSpecificationImpl implements EllipseSpecification {

    @Override
    public boolean specify(Ellipse ellipse) {
        CalculationService service = new CalculationServiceImpl();
        return service.checkIfDegenerate(ellipse);
    }
}
