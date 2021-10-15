package by.zvezdina.shapes.entity;

import by.zvezdina.shapes.observer.EllipseEvent;
import by.zvezdina.shapes.observer.EllipseObservable;
import by.zvezdina.shapes.observer.EllipseObserver;
import by.zvezdina.shapes.util.Generator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Ellipse implements EllipseObservable {
    private static final Logger logger = LogManager.getLogger();
    private int ellipseId;
    private Point point1;
    private Point point2;
    private List<EllipseObserver> observers = new ArrayList<>();

    public Ellipse() {}

    public Ellipse(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.ellipseId = Generator.generateId();
    }

    @Override
    public void attach(EllipseObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(EllipseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        EllipseEvent event = new EllipseEvent(this);
        observers.forEach(o -> o.updateParameters(event));
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
        notifyObservers();
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
        notifyObservers();
    }

    public int getEllipseId() {
        return ellipseId;
    }

    public void setEllipseId(int ellipseId) {
        this.ellipseId = ellipseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return ellipseId == ellipse.ellipseId &&
                point1.equals(ellipse.point1) &&
                point2.equals(ellipse.point2) &&
                observers.equals(ellipse.observers);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Integer.hashCode(ellipseId);
        result = prime * result + point1.hashCode();
        result = prime * result + point2.hashCode();
        result = prime * result + observers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ellipse.class.getSimpleName() + "[", "]")
                .add("ellipseId=" + ellipseId)
                .add("point1=" + point1)
                .add("point2=" + point2)
                .toString();
    }
}
