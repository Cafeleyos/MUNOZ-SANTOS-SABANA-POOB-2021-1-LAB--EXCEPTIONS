package shapes;

import Shapes.Cylinder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CylinderTest {

    private static Cylinder c1;
    private static Cylinder c2;
    private static Cylinder c3;
    private static Cylinder c4;

    @BeforeAll
    public static void setUp() {
        c1 = new Cylinder();
        c2 = new Cylinder(14.5, 20.5);
        c3 = new Cylinder("red", 23.5, 42.1);
        c4 = new Cylinder(1.2,103);
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
}
