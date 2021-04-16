package shapes;

import Shapes.Cube;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {

    private static Cube c1;
    private static Cube c2;
    private static Cube c3;
    private static Cube c4;

    @BeforeAll
    public static void setUp() {
        c1 = new Cube();
        c2 = new Cube("red");
        c3 = new Cube(5.0);
        c4 = new Cube(2.0, "yellow");

    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(1.0, Round(c1.getArea()));
        assertEquals(1.0, Round(c2.getArea()));
        assertEquals(25.0, Round(c3.getArea()));
        assertEquals(4.0, Round(c4.getArea()));
    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(4.0, Round(c1.getPerimeter()));
        assertEquals(4.0, Round(c2.getPerimeter()));
        assertEquals(20.0, Round(c3.getPerimeter()));
        assertEquals(8.0, Round(c4.getPerimeter()));

    }

    @Test
    public void shouldCalculateVolume() {

        assertEquals(1.0, Round(c1.getVolume()));
        assertEquals(1.0, Round(c2.getVolume()));
        assertEquals(125.0, Round(c3.getVolume()));
        assertEquals(8.0, Round(c4.getVolume()));

    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(6.0, Round(c1.getSuperficialArea()));
        assertEquals(6.0, Round(c2.getSuperficialArea()));
        assertEquals(150.0, Round(c3.getSuperficialArea()));
        assertEquals(24.0, Round(c4.getSuperficialArea()));

    }

    public Double Round(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}