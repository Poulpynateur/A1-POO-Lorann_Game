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

public class EventsManagerTest {


    private static IModel model;
    private static IView view;

    private static EventsManager eventsManager;

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
                return new Point(0,0);
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

        eventsManager = new EventsManager(model,view);
    }

    /**
     * Check if we can move the player.
     */
    @Test
    public void setPlayer_move() {
        eventsManager.setPlayer_move();
        assertEquals(new Point(0,0),eventsManager.getPlayer_move());
    }

    /**
     * Check if we can get the player movement (vector).
     */
    @Test
    public void getPlayer_move() {
        assertEquals(new Point(0,0),eventsManager.getPlayer_move());
    }
}