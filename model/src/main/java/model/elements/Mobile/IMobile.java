package model.elements.Mobile;

import model.elements.IElements;

import java.awt.*;

/**
 * <h1>The Interface IMobile Implement by model.Elements.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public interface IMobile extends IElements {
	
	/** get the location 
	 * @return the location*/
    Point getLocation();
    
    /** set the location
     * @param x X coordinate
     * @param y Y coordinate */
    void setLocation(int x, int y);
}
