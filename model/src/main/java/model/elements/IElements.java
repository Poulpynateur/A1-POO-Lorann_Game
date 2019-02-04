package model.elements;

import model.Types;

import java.awt.*;

/**
 * <h1>The Interface IElements Implement by model.Elements.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public interface IElements {
	
	/** get style 
	 * @return The string style*/
    String getStringStyle();
    /** get the sprite 
     * @return The sprite*/
    Image getSprite();
    /** get the type 
     * @return the type*/
    Types getType();
}
