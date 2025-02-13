package ca.ubc.cpsc210.paddleball.test;

import ca.ubc.cpsc210.paddleball.model.PBG;
import ca.ubc.cpsc210.paddleball.model.Paddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Paddle class.
 */
class TestPaddle {
	private static final int XLOC = PBG.DIMENSIONX / 2;
	private Paddle p;
	
	@BeforeEach
	void runBefore() {
		p = new Paddle(XLOC);
	}
	
	@Test
	void testGetX() {
		assertEquals(XLOC, p.getPosX());
	}
	
	@Test
	void testUpdate() {
		final int NUM_UPDATES = 8;
		
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getPosX());
		
		for(int count = 1; count < NUM_UPDATES; count++) {
			p.move();
		}
		
		assertEquals(XLOC + NUM_UPDATES * Paddle.DX, p.getPosX());
	}
	
	@Test
	void testFlipDirection() {
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getPosX());
		p.moveLeft();
		p.move();
		assertEquals(XLOC, p.getPosX());
		p.moveRight();
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getPosX());
	}
	
	@Test 
	void testLeftBoundary() {
		p.moveLeft();
		for(int count = 0; count < (PBG.DIMENSIONX / 2 - Paddle.WIDTH / 2) / Paddle.DX + 1; count++)
			p.move();
		assertEquals(Paddle.WIDTH / 2, p.getPosX());
		p.move();
		assertEquals(Paddle.WIDTH / 2, p.getPosX());
	}
	
	@Test
	void testRightBoundary() {
		p.moveRight();
		for(int count = 0; count < (PBG.DIMENSIONX / 2 - Paddle.WIDTH / 2) / Paddle.DX + 1; count++)
			p.move();
		assertEquals(PBG.DIMENSIONX - Paddle.WIDTH / 2, p.getPosX());
		p.move();
		assertEquals(PBG.DIMENSIONX - Paddle.WIDTH / 2, p.getPosX());
	}
}
