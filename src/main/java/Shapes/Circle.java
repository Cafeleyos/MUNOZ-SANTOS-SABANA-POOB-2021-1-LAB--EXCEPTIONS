package Shapes;

/**
 * Represents a circle of radius r. Class inherited by Shape
 */
public class Circle extends Shape implements GeometricShape2D {

    public static final double PI = Math.PI;
    private double radius;

    /**
     *  Constructor without parameters that specifies radius=1
     */
    public Circle() {
        this.radius = 1.0;
    }

    /**
     *  Constructor for specifying the radius
     * @param radius
     */
    public Circle(double radius) throws ShapeException {
        if (radius <=0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.radius = radius;
    }

    /**
     * Constructor for specifying the radius and color
     * @param color
     * @param radius
     */

    public Circle(String color, double radius) throws ShapeException {
        super(color);
        if (radius <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        this.radius = radius;
    }


    public double getArea() {
        return PI*radius*radius;
    }


    public double getPerimeter() {
        return 2*PI*radius;
    }

    /**
     *
     * returns the class name, the color and the radius.
     */
    @Override
    public String toString() {
        return String.format("This is a %s with color %s and radius %s"
                , this.getClass().getSimpleName()
                , getColor() == null ? "NONE" : getColor()
                , isDecimal(radius) ? Double.toString(radius) : new java.text.DecimalFormat("#").format(radius));
    }

    public double getDiameter() {
        return 2*radius;
    }
    public double getRadius(){ return this.radius; }
}
