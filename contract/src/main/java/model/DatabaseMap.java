package model;

/**
 * <h1>The Class DatabaseMap return the map from the DB.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public class DatabaseMap {

				/**** ATTRIBUTE ****/
    /** The name of element */
    private String element;
    
    /** The X coordinates of element */
    private int cooX;
    /** The Y coordinates of element */
    private int cooY;

    				/**** CONSTRUCTOR ****/
    /**
     * Instantiates a new example.
     *
     * @param element
     *            the element
     * @param cooX
     *            the X coordinate
     * @param cooY
     *            the Y coordinate
     */
    public DatabaseMap(final String element, final int cooX, final int cooY) {
        super();
        this.element = element;
        this.cooX = cooX;
        this.cooY = cooY;
    }

    				/**** GETTERS and SETTERS ****/
    /**
     * Gets the element.
     *
     * @return the element
     */
    public String getElement() {
        return this.element;
    }
    
        
    /**
     * Gets the X coordinates.
     *
     * @return the X coordinates
     */
    public int getCooX() {
        return this.cooX;
    }
    
    
    /**
     * Gets the Y coordinates.
     *
     * @return the Y coordinates
     */
    public int getCooY() {
        return this.cooY;
    }

    

    /**
     * Sets the element.
     *
     * @param element
     *            the new element
     */
    public void setElement(final String element) {
        this.element= element;
    }
    
    

    /**
     * Sets the X coordinates.
     *
     * @param cooX
     *            the new X coordinates
     */
    public void setCooX(final int cooX) {
        this.cooX = cooX;
    }
    
    
    /**
     * Sets the Y coordinates.
     *
     * @param cooY
     *            the new Y coordinates
     */
    public void setCooY(final int cooY) {
        this.cooY = cooY;
    }
    
    

    /**
     * Get the element with his localisation.
     * 
     * @see java.lang.Object#toString()
     *  
     * @return element with localisation
     */
    @Override
   public String toString() {
        return this.getElement() + ";" + this.getCooX()+ ";" + this.getCooY();
    }
}
