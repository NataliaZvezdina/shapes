package by.zvezdina.shapes.util;

public class GeneratorId {
    private static int count;

    public static int generateId() {
        return ++count;
    }
}
