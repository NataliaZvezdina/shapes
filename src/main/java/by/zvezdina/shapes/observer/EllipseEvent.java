package by.zvezdina.shapes.observer;

import by.zvezdina.shapes.entity.Ellipse;

import java.util.EventObject;

public class EllipseEvent extends EventObject {

    public EllipseEvent(Ellipse source) {
        super(source);
    }

    @Override
    public Ellipse getSource() {
        return (Ellipse) super.getSource();
    }
}
