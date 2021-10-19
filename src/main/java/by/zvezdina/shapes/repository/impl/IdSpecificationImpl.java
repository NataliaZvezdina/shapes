package by.zvezdina.shapes.repository.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.repository.EllipseSpecification;

public class IdSpecificationImpl implements EllipseSpecification {
    private int id;

    public IdSpecificationImpl(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipse.getEllipseId() == id;
    }
}
