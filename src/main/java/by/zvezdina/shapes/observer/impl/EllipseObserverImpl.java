package by.zvezdina.shapes.observer.impl;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.EllipseParameter;
import by.zvezdina.shapes.entity.Warehouse;
import by.zvezdina.shapes.observer.EllipseEvent;
import by.zvezdina.shapes.observer.EllipseObserver;
import by.zvezdina.shapes.service.CalculationService;
import by.zvezdina.shapes.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseObserverImpl implements EllipseObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(EllipseEvent event) {
        Warehouse warehouse = Warehouse.getInstance();
        CalculationService service = new CalculationServiceImpl();
        Ellipse ellipse = event.getSource();

        double perimeter = service.calculatePerimeter(ellipse);
        double square = service.calculateSquare(ellipse);
        EllipseParameter parameter = new EllipseParameter(perimeter, square);
        int id = ellipse.getEllipseId();
        warehouse.put(id, parameter);
        logger.log(Level.INFO, "Parameters of the ellipse were updated: " + ellipse);

    }
}
