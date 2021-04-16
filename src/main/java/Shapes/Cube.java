package Shapes;

/**
 * Represents a cube. Class inherited by RectangleSolid
 */
public class Cube extends RectangleSolid {
    public Cube() {
    }
    /**
     *  Constructor without parameters that specifies cube of side 1.
     */
    public Cube(String color) {
        super(color);
    }

    /**
     *  Constructor for specifying the side of the cube
     */
    public Cube(double side) throws ShapeException {
        super(side, side, side);
        if (side<=0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
    }
    /**
     *  Constructor for specifying the side and color of the cube
     */
    public Cube(double side, String color) throws ShapeException {
        super(side, side, side, color);
        if (side<=0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
    }

    @Override
    public double getVolume() {
        return super.getVolume();
    }

    @Override
    public double getSuperficialArea() {
        return super.getSuperficialArea();
    }
}



