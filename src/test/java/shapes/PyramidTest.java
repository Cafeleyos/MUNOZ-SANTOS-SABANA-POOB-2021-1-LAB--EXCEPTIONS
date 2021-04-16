package shapes;

import Shapes.Pyramid;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PyramidTest {

    private static Pyramid c1;
    private static Pyramid c2;
    private static Pyramid c3;
    private static Pyramid c4;

    @BeforeAll
    public static void setUp() {
        c1 = new Pyramid();
        c2 = new Pyramid("red");
        c3 = new Pyramid(5.0,5.0,5.0,20.0);
        c4 = new Pyramid(3.0,4.0,5.0,40,"blue");

    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(0.4, Round(c1.getArea()));
        assertEquals(0.4, Round(c2.getArea()));
        assertEquals(10.8, Round(c3.getArea()));
        assertEquals(6.0, Round(c4.getArea()));
    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(3.0, Round(c1.getPerimeter()));
        assertEquals(3.0, Round(c2.getPerimeter()));
        assertEquals(15.0, Round(c3.getPerimeter()));
        assertEquals(12.0, Round(c4.getPerimeter()));

    }

    @Test
    public void shouldCalculateVolume() {

        assertEquals(0.1, Round(c1.getVolume()));
        assertEquals(0.1, Round(c2.getVolume()));
        assertEquals(72.2, Round(c3.getVolume()));
        assertEquals(80.0, Round(c4.getVolume()));

    }

    @Test
    public void shouldCalculateSuperficialArea() {
        assertEquals(1.9, Round(c1.getSuperficialArea()));
        assertEquals(1.9, Round(c2.getSuperficialArea()));
        assertEquals(160.8, Round(c3.getSuperficialArea()));
        assertEquals(246.0, Round(c4.getSuperficialArea()));

    }

    public Double Round(double number) {
        return Math.round(number*10.0)/10.0;
    }
}

