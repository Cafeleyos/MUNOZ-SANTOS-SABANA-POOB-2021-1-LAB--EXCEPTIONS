package shapes;

import Shapes.Rectangle;
import Shapes.RectangleSolid;
import Shapes.ShapeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleSolidTest {

    private static RectangleSolid c1;
    private static RectangleSolid c2;
    private static RectangleSolid c3;
    private static RectangleSolid c4;

    @BeforeAll
    public static void setUp() {
        try {
            c1 = new RectangleSolid();
            c2 = new RectangleSolid("red");
            c3 = new RectangleSolid(5.0, 6.0, 10);
            c4 = new RectangleSolid(10, 15, 5.0, "yellow");
        }
        catch (ShapeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(1.0, Round(c1.getArea()));
        assertEquals(1.0, Round(c2.getArea()));
        assertEquals(30.0, Round(c3.getArea()));
        assertEquals(150.0, Round(c4.getArea()));
    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(4.0, Round(c1.getPerimeter()));
        assertEquals(4.0, Round(c2.getPerimeter()));
        assertEquals(22.0, Round(c3.getPerimeter()));
        assertEquals(50.0, Round(c4.getPerimeter()));

    }

    @Test
    public void shouldCalculateVolume() {

        assertEquals(1.0, Round(c1.getVolume()));
        assertEquals(1.0, Round(c2.getVolume()));
        assertEquals(300.0, Round(c3.getVolume()));
        assertEquals(750.0, Round(c4.getVolume()));

    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(6.0, Round(c1.getSuperficialArea()));
        assertEquals(6.0, Round(c2.getSuperficialArea()));
        assertEquals(280.0, Round(c3.getSuperficialArea()));
        assertEquals(550.0, Round(c4.getSuperficialArea()));

    }
    @Test
    public void shouldNotCreateSolidRectangleWithDepthNegative() {
        try {
            new RectangleSolid(1, 2,-2);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }
    @Test
    public void shouldNotCreateSolidRectangleWithDepth0() {
        try {
            new RectangleSolid(1,3, 0);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }


    public Double Round(double number) {
        return Math.round(number*100.0)/100.0;
    }
}