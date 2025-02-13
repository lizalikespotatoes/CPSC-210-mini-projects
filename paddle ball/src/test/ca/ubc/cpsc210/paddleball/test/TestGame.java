package ca.ubc.cpsc210.paddleball.test;

import ca.ubc.cpsc210.paddleball.model.PBG;
import ca.ubc.cpsc210.paddleball.model.Paddle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Game class.
 */
class TestGame {
	private PBG g;
	
	@BeforeEach
	void runBefore() {
		g = new PBG();
	}
	
	@Test
	void testInit() {
		Paddle t = g.getPaddle();
		assertEquals(PBG.DIMENSIONX / 2, t.getPosX());
	}
	
	@Test
	void testUpdate() {
		Paddle t = g.getPaddle();
		assertEquals(PBG.DIMENSIONX / 2, t.getPosX());
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 + Paddle.DX, t.getPosX());
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 + 2 * Paddle.DX, t.getPosX());
	}
	
	@Test
	void testNonKeyPadKeyEvent() {
		Paddle t = g.getPaddle();
		g.keyPressed(KeyEvent.VK_LEFT);
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 - Paddle.DX, t.getPosX());
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 - 2 * Paddle.DX, t.getPosX());
		g.keyPressed(KeyEvent.VK_RIGHT);
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 - Paddle.DX, t.getPosX());
		g.update();
		assertEquals(PBG.DIMENSIONX / 2, t.getPosX());
	}
	
	@Test
	void testKeyPadKeyEvent() {
		Paddle t = g.getPaddle();
		g.keyPressed(KeyEvent.VK_KP_LEFT);
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 - Paddle.DX, t.getPosX());
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 - 2 * Paddle.DX, t.getPosX());
		g.keyPressed(KeyEvent.VK_KP_RIGHT);
		g.update();
		assertEquals(PBG.DIMENSIONX / 2 - Paddle.DX, t.getPosX());
		g.update();
		assertEquals(PBG.DIMENSIONX / 2, t.getPosX());
	}
}
