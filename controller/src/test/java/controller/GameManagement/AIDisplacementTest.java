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

public class AIDisplacementTest {

    private static IModel model;

    private static AIDisplacement aiDisplacement;

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
            public List<Point> getEnemiesLocation() {
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
                return null;
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
                return null;
            }

            @Override
            public void createElement(int x, int y, Types type) {

            }

            @Override
            public boolean isThereEnemy(int x, int y) {
                return false;
            }
        };

        aiDisplacement = new AIDisplacement(model);
    }

    /**
     * Check that we receive the good type of data and that we have the correct number of movement vector (one per enemy).
     */
    @Test
    public void moveAI() {
        ArrayList<Point> testMoveAI = new ArrayList<Point>();
        testMoveAI.add(new Point(0,0));
        testMoveAI.add(new Point(0,0));

        assertEquals(testMoveAI.getClass(), aiDisplacement.moveAI().getClass());
        assertEquals(testMoveAI.size(), aiDisplacement.moveAI().size());
    }
}