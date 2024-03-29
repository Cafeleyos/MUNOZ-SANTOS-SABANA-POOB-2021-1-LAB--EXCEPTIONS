package Shapes;

/**
 * Represents a rectangle. Class inherited by Shape
 */
public class Rectangle extends Shape implements GeometricShape2D {
    private double width = 1.0;
    private double length = 1.0;

    /**
     * Constructor without parameters that specifies width= 1 and length= 1
     */
    public Rectangle() {
    }

    /**
     * Constructor for specifying the color
     * @param color
     */
    public Rectangle(String color) {
        super(color);
    }

    /**
     * Constructor for specifying the length and width
     * @param width
     * @param length
     */
    public Rectangle(double width, double length) throws ShapeException{
        if(width<=0 || length<=0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor for specifying the length, width and color
     * @param color
     * @param width
     * @param length
     */
    public Rectangle(String color, double width, double length) throws ShapeException {
        super(color);
        if(width<=0 || length<=0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        this.width = width;
        this.length = length;
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(width, 2)+Math.pow(length, 2));
    }


    public double getArea() {
        return width*length;
    }


    public double getPerimeter() {
        return (2*width)+(2*length);
    }

    public double getWidth(){return this.width;}

    public double getLength() { return length; }
    /**
     * returns the class name, the color, the width and length
     */
    @Override
    public String toString() {
        return String.format("This is a %s with color %s, width %s and length %s"
                , this.getClass().getSimpleName()
                , getColor() == null ? "NONE" : getColor()
                , isDecimal(width) ? Double.toString(width) : new java.text.DecimalFormat("#").format(width),
                isDecimal(length) ? Double.toString(length) : new java.text.DecimalFormat("#").format(length));
    }
}
