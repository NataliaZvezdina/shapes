package by.zvezdina.shapes.entity;

import java.util.StringJoiner;

public class EllipseParameter {

    private double perimeter;
    private double square;

    public EllipseParameter() {}

    public EllipseParameter(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseParameter that = (EllipseParameter) o;
        return Double.compare(that.perimeter, perimeter) == 0 && Double.compare(that.square, square) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(perimeter);
        result = prime * result + Double.hashCode(square);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EllipseParameter.class.getSimpleName() + "[", "]")
                .add("perimeter=" + perimeter)
                .add("square=" + square)
                .toString();
    }
}
