package by.zvezdina.shapes.service;

import by.zvezdina.shapes.entity.Ellipse;

public interface CalculationService {

    double calculatePerimeter(Ellipse ellipse);

    double calculateSquare(Ellipse ellipse);

    boolean checkIfCircle(Ellipse ellipse);
}
