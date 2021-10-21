package by.zvezdina.shapes.repository;

import by.zvezdina.shapes.entity.Ellipse;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepository {

    private static final EllipseRepository instance = new EllipseRepository();
    private List<Ellipse> ellipses;

    private EllipseRepository() {
        ellipses = new ArrayList<>();
    }

    public static EllipseRepository getInstance() {
        return instance;
    }

    public boolean add(Ellipse ellipse) {
        return ellipses.add(ellipse);
    }

    public boolean addAll(List<Ellipse> ellipseList) {
        return ellipses.addAll(ellipseList);
    }

    public void clear() {
        ellipses.clear();
    }

    public boolean contains(Ellipse ellipse) {
        return ellipses.contains(ellipse);
    }

    public int indexOf(Ellipse ellipse) {
        return ellipses.indexOf(ellipse);
    }

    public Ellipse get(int index) {
        return ellipses.get(index);
    }

    public Ellipse remove(int index) {
        return ellipses.remove(index);
    }

    public boolean remove(Ellipse ellipse) {
        return ellipses.remove(ellipse);
    }

    public Ellipse set(int index, Ellipse ellipse) {
        return ellipses.set(index, ellipse);
    }

    public int size() {
        return ellipses.size();
    }

    public List<Ellipse> query(EllipseSpecification specification) {
        return ellipses.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    public List<Ellipse> sort(Comparator<? super Ellipse> comparator) {
        List<Ellipse> ellipsesCopy = new ArrayList<>(ellipses);
        ellipsesCopy.sort(comparator);
        return ellipsesCopy;
    }
}
