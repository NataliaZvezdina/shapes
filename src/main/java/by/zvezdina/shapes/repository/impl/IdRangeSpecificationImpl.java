package by.zvezdina.shapes.repository.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.repository.EllipseSpecification;

public class IdRangeSpecificationImpl implements EllipseSpecification {
    private int minId;
    private int maxId;

    public IdRangeSpecificationImpl(int minId, int maxId) {
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipse.getEllipseId() >= minId && ellipse.getEllipseId() <= maxId;
    }
}
