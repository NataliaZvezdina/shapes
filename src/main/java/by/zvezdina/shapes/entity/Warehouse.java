package by.zvezdina.shapes.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();

    private static Warehouse instance;
    private final Map<Integer, EllipseParameter> parameters;

    private Warehouse() {
        parameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public EllipseParameter put(int id, EllipseParameter parameter) {
        return parameters.put(id, parameter);
    }

    public EllipseParameter get(int id) {
        return parameters.get(id);
    }

    public EllipseParameter remove(int id) {
        return parameters.remove(id);
    }
}
