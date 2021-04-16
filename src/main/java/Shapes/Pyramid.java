package Shapes;

/**
 * Represents a triangle pyramid
 */
public class Pyramid extends Triangle implements GeometricShape3D{
    private double height= 1;

    /**
     *  Constructor without parameters that specifies 1 in all attributes
     */
    public Pyramid() {
        super();
    }

    /**
     *  Constructor for specifying the color of the pyramid
     */
    public Pyramid(String color) {
        super(color);
    }
    /**
     *  Constructor for specifying the sides and height of the pyramid
     */
    public Pyramid(double side1, double side2, double side3, double height) throws ShapeException {
        super(side1,side2,side3);
        if(height<=0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        this.height = height;
    }
    /**
     *  Constructor for specifying the sides, height and color of the pyramid
     */
    public Pyramid(double side1, double side2, double side3, double height, String color) throws ShapeException {
        super(color, side1,side2,side3);
        if(height<=0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        this.height = height;
    }

    /**
     * Calculates the volume of a pyramid
     * @return volume
     */
    @Override
    public double getVolume() {
        return (1.0/3.0)*super.getArea()*this.height;
    }

    /**
     * Calculates de superficial area of a pyramid
     * @return superficial area
     */
    @Override
    public double getSuperficialArea() {
        double sides[] = getSides();
        double result = 0;
        for (int i = 0; i < 3; i++) {
            result += (sides[i]*height)/2;
        }
        return result+ getArea();
    }
}
