package view;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomJFrameTest {

	private static CustomJFrame customJFrame;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customJFrame = new CustomJFrame();
	}

	/**
	 * Check if the the returned value correspond to the good default class value.
	 */
	@Test
	public void testReturn_deplacement_player() {
		assertEquals(customJFrame.return_deplacement_player(),new Point(0,0));
	}

	/**
	 * Check if the the returned value correspond to the good default class value.
	 */
	@Test
	public void testReturn_casting_player() {
		assertFalse(customJFrame.return_casting_player());
	}

	/**
	 * Simulate key, check if direction vector is modify in function of keys.
	 */
	@Test
	public void testKeyPressed() {
		KeyEvent key = new KeyEvent(customJFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'Z');
		customJFrame.getKeyListeners()[0].keyPressed(key);

		customJFrame.keyPressed(key);
		assertEquals(1,customJFrame.deplacement_player.y);

		key = new KeyEvent(customJFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_LEFT,'Q');
		customJFrame.getKeyListeners()[0].keyPressed(key);

		customJFrame.keyPressed(key);
		assertEquals(-1,customJFrame.deplacement_player.x);

		key = new KeyEvent(customJFrame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_SPACE,' ');
		customJFrame.getKeyListeners()[0].keyPressed(key);

		customJFrame.keyPressed(key);
		assertTrue(customJFrame.casting_spell);
	}

	/**
	 * Simulate key, check if direction vector is modify in function of keys.
	 */
	@Test
	public void testKeyReleased() {
		KeyEvent key = new KeyEvent(customJFrame, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'Z');
		customJFrame.getKeyListeners()[0].keyReleased(key);

		customJFrame.keyReleased(key);
		assertEquals(0,customJFrame.deplacement_player.y);

		key = new KeyEvent(customJFrame, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0,  KeyEvent.VK_LEFT,'Q');
		customJFrame.getKeyListeners()[0].keyReleased(key);

		customJFrame.keyReleased(key);
		assertEquals(0,customJFrame.deplacement_player.x, 0);

		key = new KeyEvent(customJFrame, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0,  KeyEvent.VK_SPACE,' ');
		customJFrame.getKeyListeners()[0].keyReleased(key);

		customJFrame.keyReleased(key);
		assertFalse(customJFrame.casting_spell);
	}
}
