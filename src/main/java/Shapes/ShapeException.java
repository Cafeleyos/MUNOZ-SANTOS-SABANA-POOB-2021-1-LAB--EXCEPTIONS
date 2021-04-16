package Shapes;

public class ShapeException extends Exception{

    public static final String BAD_DIMENSION_SIDE = "The dimension of a shape must be greater than 0.";
    public static final String INCOHERENT_SIDES = "The given dimensions does not have physical coherence";
    public ShapeException(String message) {
        super(message);
    }
}
