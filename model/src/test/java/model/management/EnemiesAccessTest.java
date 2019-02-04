package model.management;

import model.MapModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

public class EnemiesAccessTest {

    private EnemiesAccess enemiesAccess;
    private MapModel map;
    private Point[] enemiesLoc = {new Point(1,1),new Point(10,1),new Point(11,18)};
    private String mapString[][] =
            {       {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"},
                    {"V","D1","L1","S1"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V","D3"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","D2","V"},
                    {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"}};

    @Before
    public void setUp() throws Exception {
        map = new MapModel(mapString);
        enemiesAccess = new EnemiesAccess(map);
    }

    /**
     * Test if the enemies move to the good location (movement is a number of case to move in x and y).
     */
    @Test
    public void moveEnemies() {
        List<Point> moveTest = new ArrayList<Point>();
        moveTest.add(new Point(0,1));
        moveTest.add(new Point(-1,0));
        moveTest.add(new Point(0,0));
        //Actual enemies location :
            //1,1
            //10,1
            //11,18

        enemiesAccess.moveEnemies(moveTest);
        assertEquals("D1",map.getMap()[1][2].getStringStyle());
        assertEquals("D3",map.getMap()[9][1].getStringStyle());
        assertEquals("D2",map.getMap()[11][18].getStringStyle());
    }

    /**
     * Check if we get the good enemies position.
     */
    @Test
    public void getEnemiesLocation() {
        int i = 0;
        for (Point enemyLoc : enemiesAccess.getEnemiesLocation()) {
            assertEquals(enemiesLoc[i],enemyLoc);
            i++;
        }
    }

    /**
     * Check if we can kill enemies (replace by space)
     */
    @Test
    public void killEnemy() {
        enemiesAccess.killEnemy(1,1);
        assertEquals(" ",map.getMap()[1][1].getStringStyle());

        enemiesAccess.killEnemy(10,1);
        assertEquals(" ",map.getMap()[10][1].getStringStyle());
        /*If deleted only one enemies left in the list*/
        assertEquals(1,map.getEnemies().size());
    }

    /**
     * Check if we can create enemies, in fact enemy can be only created at the map creation.
     * So an enemy can be create only on an another.
     */
    @Test
    public void createEnemy() {
        enemiesAccess.createEnemy(1,1);
        assertEquals("D1",map.getMap()[1][1].getStringStyle());

        enemiesAccess.createEnemy(0,0);
        assertNotSame("D1",map.getMap()[0][0].getStringStyle());

    }

    /**
     * Check if there is an enemy at a specif location
     */
    @Test
    public void isThereEnemy() {
        assertTrue(enemiesAccess.isThereEnemy(1,1));
        assertFalse(enemiesAccess.isThereEnemy(10,10));
    }
}