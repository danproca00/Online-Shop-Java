package proiect;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
class Test1 {

	@org.junit.jupiter.api.Test
	void testTipCarne() {
		TipCarne carne = TipCarne.VITA;
		assertEquals(TipCarne.valueOf("VITA"), carne);
	}

}

class Test2 {

	@org.junit.jupiter.api.Test
	void testTipBlat() {
		TipBlat blat = TipBlat.GROS;
		assertEquals(TipBlat.valueOf("GROS"), blat);
	}

}

class Test3 {

	@org.junit.jupiter.api.Test
	void testTipSuc() {
		TipSuc suc = TipSuc.SPRITE;
		assertEquals(TipSuc.valueOf("SPRITE"), suc);
	}

}