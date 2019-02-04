package view;

import java.awt.*;

/**
 * <h1>The Interface IView Implement by view.viewFacade.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public interface IView {

	/** refresh the window */
    void showElements();
    /** print message on screen 
     *  @param message The message
     */
    void displayMessage(String message);
    /** get player location 
     * @return the deplacement of the player*/
    Point return_deplacement_player();
    /** check if player is casting spell 
     * @return If player is currently casting*/
    boolean return_casting_player();

    /** set score
     * @param score The score
     */
    void setScore(int score);
    /** get score 
     * @return The score*/
    int getScore();
    /** set the array of image 
     * @param map The map
     */
    void setImageMap(Image[][] map);
    /** update (observable */
	void update();
}
