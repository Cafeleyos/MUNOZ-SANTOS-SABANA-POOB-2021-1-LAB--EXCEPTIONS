package shapes;

import Shapes.Cylinder;
import Shapes.ShapeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CylinderTest {

    private static Cylinder c1;
    private static Cylinder c2;
    private static Cylinder c3;
    private static Cylinder c4;

    @BeforeAll
    public static void setUp() {
        try {
            c1 = new Cylinder();
            c2 = new Cylinder(14.5, 20.5);
            c3 = new Cylinder("red", 23.5, 42.1);
            c4 = new Cylinder(1.2, 103);
        } catch (ShapeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(3, (int) c1.getArea());
        assertEquals(660, (int) c2.getArea());
        assertEquals(1734, (int) c3.getArea());
    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(6, (int) c1.getPerimeter());
        assertEquals(91, (int) c2.getPerimeter());
        assertEquals(147, (int) c3.getPerimeter());
    }

    @Test
    public void shouldCalculateDiameter() {

        assertEquals(2, (int) c1.getDiameter());
        assertEquals(29, (int) c2.getDiameter());
        assertEquals(47, (int) c3.getDiameter());
    }

    @Test
    public void shouldCalculateVolume() {

        assertEquals(3, (int) c1.getVolume());
        assertEquals(13540, (int) c2.getVolume());
        assertEquals(73041, (int) c3.getVolume());
        assertEquals(465, (int) c4.getVolume());
    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(12, (int) c1.getSuperficialArea());
        assertEquals(3188, (int) c2.getSuperficialArea());
        assertEquals(9686, (int) c3.getSuperficialArea());
        assertEquals(785, (int) c4.getSuperficialArea());
    }

    @Test
    public void shouldPrintCylinder() {
        assertTrue(c1.toStringGeometricShape2D().contains("This is a Cylinder"));
        assertTrue(c2.toStringGeometricShape2D().contains("This is a Cylinder"));
        assertTrue(c3.toStringGeometricShape2D().contains("This is a Cylinder"));
        assertTrue(c4.toStringGeometricShape2D().contains("This is a Cylinder"));
    }

    @Test
    public void shouldNotCreateCylinderWithRadiusNegative() {
        try {
            new Cylinder(-1, 2);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }
    @Test
    public void shouldNotCreateCylinderWithHeightNegative() {
        try {
            new Cylinder(5, -2);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }
    @Test
    public void shouldNotCreateCylinderWithHeight0() {
        Exception e = assertThrows(ShapeException.class,() -> new Cylinder(5,0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE,e.getMessage());
    }
    @Test
    public void shouldNotCreateCylinderWithRadius0() {
        Exception e = assertThrows(ShapeException.class,() -> new Cylinder(0,6));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE,e.getMessage());
    }
}
