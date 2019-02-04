package model.elements.Mobile;

import model.elements.ElementsList;

import model.Types;
/**
 * <h1>The Class Player animate player.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public class Player extends Mobile{

    private int animationNumber = 0;
    private static Player INSTANCE = null;

    				/**** CONSTRUCTOR ****/
    
    /**
     * Initiate the player.
     * 
     * @param stringStyle the stringStyle (example : "L1" corresponds to the player)
     * @param x X coordinate
     * @param y Y coordinate
     */
    private Player(String stringStyle, int x, int y) {
        super(stringStyle,Types.PLAYER,x,y);
    }

    public static synchronized void setInstance(String stringStyle, int x, int y)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new Player(stringStyle,x,y);
        }
    }

    public static Player getInstance() {
        return Player.INSTANCE;
    }

    				/**** METHODS ****/
    
    /**
     * Animate an element depends on the coordinates.
     * 
     * @param directionX Relative X coordinate
     * @param directionY Relative Y coordinate
     * 
     * @see model.elements.ElementsList#getCharacter()
     * - Get the character
     *  @see model.elements.ElementsList#getImage()
     * - Get the image
     * @see model.elements.ElementsList#getDirection()
     * - Get the direction
     */
    public void animate (int directionX, int directionY){

        if (directionX == 0 && directionY == 0) {
            if (animationNumber < 7){
                this.sprite = ElementsList.values()[animationNumber].getImage();
                this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
                animationNumber++;
            }
            else {
                this.sprite = ElementsList.values()[animationNumber].getImage();
                this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
                animationNumber = 0;
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                if(ElementsList.values()[i].getDirection().x == directionX && ElementsList.values()[i].getDirection().y == directionY) {
                    this.sprite = ElementsList.values()[i].getImage();
                }
            }
        }
    }
}
