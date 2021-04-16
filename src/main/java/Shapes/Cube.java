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
    public Cube(double side) {
        super(side, side, side);
    }
    /**
     *  Constructor for specifying the side and color of the cube
     */
    public Cube(double side, String color) {
        super(side, side, side, color);
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



