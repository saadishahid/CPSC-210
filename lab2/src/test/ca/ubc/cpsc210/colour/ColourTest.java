package ca.ubc.cpsc210.colour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.*;
import static org.junit.jupiter.api.Assertions.*;

class ColourTest {
Colour c1;
Colour c2;
Colour c3;

	@BeforeEach
	void runBefore() {
c1 = new Colour(0,0,0);
c2 = new Colour(240,77,92);
c3 = new Colour(100,100,100);
	}

	@Test
	void testIsGreyScale() {
        assertTrue(c1.isGreyScale());
		assertFalse(c2.isGreyScale());
		assertTrue(c3.isGreyScale());


	}

	@Test
	void testToHex() {
        assertEquals(Integer.toHexString((0*256+0)*256+0),c1.toHex());
        assertEquals(Integer.toHexString((240*256+77)*256+92),c2.toHex());
        assertEquals(Integer.toHexString((100*256+100)*256+100),c3.toHex());


    }
}