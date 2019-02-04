package model.elements.Mobile;

import model.elements.ElementsList;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private static Player player;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Player.setInstance("L1",0,0);
    }

    @Before
    public void setUp() throws Exception {
        this.player = Player.getInstance();
    }

    /**
     * Test if the animate change the char of the player (In the good order).
     */
    @Test
    public void animate() {
        for (int i=0; i < 8; i++) {
            player.animate(0,0);
            assertEquals(ElementsList.values()[i].getCharacter(),player.getStringStyle());
        }
    }
}