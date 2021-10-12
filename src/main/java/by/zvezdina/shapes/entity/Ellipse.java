package by.zvezdina.shapes.entity;

import by.zvezdina.shapes.util.Generator;

public class Ellipse {
    private Point point1;
    private Point point2;
    private int id;

    public Ellipse() {}

    public Ellipse(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.id = Generator.generateId();
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", id=" + id +
                '}';
    }
}
