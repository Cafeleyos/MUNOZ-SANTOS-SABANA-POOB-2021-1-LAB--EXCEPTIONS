package Shapes;

/**
 * Represents a rectangular prism
 */
public class RectangleSolid extends Rectangle implements GeometricShape3D {
    private double depth = 1.0;

    /**
     * Constructor without parameters that specifies 1 in all attributes
     */
    public RectangleSolid() {
        super();
    }
    /**
     *  Constructor for specifying the color of the rectangular prism
     */
    public RectangleSolid(String color) {
        super(color);
    }
    /**
     *  Constructor for specifying the sides of the rectangular prism
     */
    public RectangleSolid(double width, double length, double depth) {
        super(width, length);
        this.depth = depth;
    }
    /**
     *  Constructor for specifying the sides and color of the rectangular prism
     */
    public RectangleSolid(double width, double length, double depth, String color) {
        super(color, width, length);
            this.depth = depth;
    }

    /**
     * Calculates the volume of a rectangular prism
     * @return volume
     */
    @Override
    public double getVolume() {
        return getArea()*this.depth;
    }

    /**
     * Calculates the superficial area of a rectangular prism
     * @return superficial area
     */
    @Override
    public double getSuperficialArea() {
        return (2*getArea())+(2*getWidth()*this.depth)+(2*getLength()*this.depth);
    }
}
