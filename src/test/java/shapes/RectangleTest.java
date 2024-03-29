package shapes;

import Shapes.Cylinder;
import Shapes.Rectangle;
import Shapes.ShapeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    private static Rectangle r1;
    private static Rectangle r2;
    private static Rectangle r3;
    private static Rectangle r4;

    @BeforeAll
    public static void setUp() {
        try {
            r1 = new Rectangle();
            r2 = new Rectangle("red");
            r3 = new Rectangle("red", 5.1, 10);
            r4 = new Rectangle(20, 5);
        }
        catch (ShapeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCalculateDiagonal() {
        assertEquals(1, (int) Math.round(r1.getDiagonal()));
        assertEquals(1, (int) Math.round(r2.getDiagonal()));
        assertEquals(11, (int) Math.round(r3.getDiagonal()));
        assertEquals(21, (int) Math.round(r4.getDiagonal()));
    }

    @Test
    public void shouldCalculateArea(){
        assertEquals(1, (int) r1.getArea());
        assertEquals(1, (int) r2.getArea());
        assertEquals(51, (int) r3.getArea());
        assertEquals(100, (int) r4.getArea());
    }

    @Test
    public void shouldCalculatePerimeter() {
        assertEquals(4, (int) r1.getPerimeter());
        assertEquals(4, (int) r2.getPerimeter());
        assertEquals(30, (int) r3.getPerimeter());
        assertEquals(50, (int) r4.getPerimeter());
    }

    @Test
    public void shouldPrintRectangle() {
        assertEquals("This is a Rectangle with color NONE, width 1 and length 1", r1.toString());
        assertEquals("This is a Rectangle with color red, width 1 and length 1", r2.toString());
        assertEquals("This is a Rectangle with color red, width 5.1 and length 10", r3.toString());
        assertEquals("This is a Rectangle with color NONE, width 20 and length 5", r4.toString());
    }
    @Test
    public void shouldNotCreateRectangleWithWidthNegative() {
        try {
            new Rectangle(-1, 2);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }
    @Test
    public void shouldNotCreateRectangleWithLengthNegative() {
        try {
            new Rectangle(3, -2);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNotCreateRectangleWithLength0() {
        Exception e = assertThrows(ShapeException.class,() -> new Rectangle(5,0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE,e.getMessage());
    }
    @Test
    public void shouldNotCreateRectangleWithWidth0() {
        Exception e = assertThrows(ShapeException.class,() -> new Rectangle(0,6));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE,e.getMessage());
    }
}

