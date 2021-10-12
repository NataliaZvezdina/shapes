package by.zvezdina.shapes.util;

public class Generator {
    private static int count;

    public static int generateId() {
        return ++count;
    }
}
