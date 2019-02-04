package controller.GameManagement;

import model.IModel;
import model.Types;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.IView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EventsTest {

    private static IModel model;
    private static IView view;

    private static Events events;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        model = new IModel() {
            @Override
            public Image getSpriteFromMap(int x, int y) {
                return null;
            }

            @Override
            public Dimension getMapSize() {
                return null;
            }

            @Override
            public void movePlayer(int moveX, int moveY) {

            }

            @Override
            public Point getPlayerLocation() {
                return new Point(0,0);
            }

            @Override
            public void moveEnemies(java.util.List<Point> enemiesMove) {

            }

            @Override
            public java.util.List<Point> getEnemiesLocation() {
                List<Point> enemiesLoc = new ArrayList<>();
                enemiesLoc.add(new Point(2,0));
                enemiesLoc.add(new Point(0,10));
                return enemiesLoc;
            }

            @Override
            public void killEnemy(int x, int y) {

            }

            @Override
            public int getBehavior(int i) {
                return 0;
            }

            @Override
            public void deleteSpell() {

            }

            @Override
            public void moveSpell(int moveX, int moveY) {

            }

            @Override
            public Point getSpellLocation() {
                return new Point(1,1);
            }

            @Override
            public boolean spellAlive() {
                return false;
            }

            @Override
            public void animate(int directionX, int directionY) {

            }

            @Override
            public Types getType(int x, int y) {
                return Types.OBSTACLE_KILL;
            }

            @Override
            public void createElement(int x, int y, Types type) {

            }

            @Override
            public boolean isThereEnemy(int x, int y) {
                return false;
            }
        };

        view = new IView() {
            @Override
            public void showElements() {

            }

            @Override
            public void displayMessage(String message) {

            }

            @Override
            public Point return_deplacement_player() {
                return null;
            }

            @Override
            public boolean return_casting_player() {
                return false;
            }

            @Override
            public void setScore(int score) {

            }

            @Override
            public int getScore() {
                return 0;
            }

            @Override
            public void setImageMap(Image[][] map) {

            }

            @Override
            public void update() {

            }
        };

        events = new Events(model,view,0,0);
    }

    /**
     * Check that the player can't reach anything : this.model have a map full of obstacle.
     */
    @Test
    public void playerCanReach() {
        assertFalse(events.playerCanReach());
    }

    /**
     * Check that it's not the game end.
     */
    @Test
    public void isGameEnd() {
        assertFalse(events.isGameEnd());
    }

    /**
     * Check that we can move correctly the player.
     */
    @Test
    public void setFuture_player() {
        events.setFuture_player(1,2);
        assertEquals(1,events.futureX_player);
        assertEquals(-2,events.futureY_player);
    }

    /**
     * Check that we can move correctly the spell.
     */
    @Test
    public void setFuture_spell() {
        events.setFuture_spell(1,2);
        assertEquals(2,events.futureX_spell);
        assertEquals(-1,events.futureY_spell);
    }

    /**
     * Check that the spell can't reach anything : this.model have a map full of obstacle.
     */
    @Test
    public void spellCanReach() {
        assertFalse(events.spellCanReach());
    }

    /**
     * Check if we can create spell, always false because we can't create spell in wall and : this.model have a map full of obstacle.
     */
    @Test
    public void canCreateSpell() {
        assertFalse(events.canCreateSpell(1,1));
    }
}