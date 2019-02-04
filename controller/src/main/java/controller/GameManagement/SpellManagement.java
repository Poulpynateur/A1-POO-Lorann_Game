package controller.GameManagement;

import model.IModel;
import model.Types;
import view.IView;

import java.awt.*;


/**
 * <h1>The Class SpellManagement manage spell.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */


public class SpellManagement {

                    /**** ATTRIBUTE ****/
	/** the model*/
    private IModel model;
    
    /** the view*/
    private IView view;

    /** the facing look */
    private Point player_facing_during_casting;
    
    /** the spell's move */
    private Point spell_move;
    
    /** the player's move*/
    private Point player_move;
    
    /** the check if player is casting spell */
    private boolean player_casting_spell;
    
    /** the check if spell is alive */
    private boolean spell_is_alive;

    /** the event */
    public Events event;

    				/**** CONSTRUCTOR ****/
    
    /**
     * Initiate the Events Manager.
     * 
     * @param model the model
     * @param view the view
     */
    public SpellManagement(IModel model, IView view) {
        this.model = model;
        this.view = view;

        this.player_facing_during_casting = new Point(0,0);
        this.spell_move = new Point(0,0);
        this.player_move = new Point(0,0);
        this.player_casting_spell = false;
        this.spell_is_alive = false;

        this.event = new Events( model, view, player_move.x, player_move.y);
    }

    				/**** GETTERS and SETTERS ****/
    
    /**
     * Set the spell state.
     * 
     * Player state is a boolean :
     * @see model.IModel#spellAlive()
     * - Get the current state
     */
    public void setSpell_is_alive() {
        spell_is_alive = model.spellAlive();
    }
    
    				/**** METHODS ****/

    /**
     * Set the direction of the player. Same as setPlayerMove() but is save if player stop move. Make able the player to shoot then he don't move.
     * 
     * @see IView#return_deplacement_player()
     */
    public void setPlayer_facing_during_casting() {
    	player_move = view.return_deplacement_player();
        if ((player_move.x != 0) || (player_move.y != 0)) { // player is moving
            if (spell_is_alive == false) { // spell not exist
                player_facing_during_casting.x = player_move.x; // set new facing (x)
                player_facing_during_casting.y = player_move.y; // set new facing (y)
            }
        }
    }

    /**
     * Check if the player pick up the spell. If so make sure that the player haven't been erase by the spell.
     * 
     * @see IModel#deleteSpell()
     * @see IModel#createElement(int, int, Types)
     */
    public void checkPlayerGetSpell() {
        setSpell_is_alive();
        if ((spell_is_alive == true) && (model.getSpellLocation().x == model.getPlayerLocation().x) && (model.getSpellLocation().y == model.getPlayerLocation().y)) {
            model.deleteSpell();
            model.createElement(model.getPlayerLocation().x,model.getPlayerLocation().y,Types.PLAYER);
        }
    }

    /**
     * Check if a enemy pick up the spell. If so make kill the good one and delete the spell.
     * 
     * @see IModel#deleteSpell()
     * @see IModel#killEnemy(int, int)
     */
    public void checkMobGetSpell() {
        setSpell_is_alive();
        if ((spell_is_alive == true) && model.isThereEnemy(model.getSpellLocation().x,model.getSpellLocation().y)) {
            model.killEnemy(model.getSpellLocation().x,model.getSpellLocation().y);
            model.deleteSpell();
        }
    }

    /**
     * Create a spell in function of the player position and his facing.
     * 
     * @see IView#return_casting_player()
     * @see Events#canCreateSpell(int, int)
     * @see IModel#createElement(int, int, Types)
     * @see controller.GameManagement.SpellManagement#spell_controlling()
     */
    public void createSpell() {
        spell_is_alive = model.spellAlive();
        player_casting_spell = view.return_casting_player(); // is player casting ?
        if ((player_casting_spell == true) && (spell_is_alive == false)) { // Player is able to cast spell
        	spell_move.x = player_facing_during_casting.x;
            spell_move.y = player_facing_during_casting.y;
            if ((event.canCreateSpell(spell_move.x, spell_move.y)) && ((spell_move.x != 0) || (spell_move.y != 0))) { // player have facing
                model.createElement(spell_move.x, spell_move.y,Types.SPELL); // Create spell
            }
        }
        else if ((player_casting_spell == true) && (spell_is_alive == true)) { // Spell already exist -> make it return to Lorann
        	spell_controlling();
        }
    }

    /**
     * Make the spell controllable by Lorann.
     *
     * @see IModel#getPlayerLocation()
     * @see IModel#getSpellLocation()
     */
    private void spell_controlling() {
        int player_location_x = model.getPlayerLocation().x;
        int player_location_y = model.getPlayerLocation().y;

        int spell_location_x = model.getSpellLocation().x;
        int spell_location_y = model.getSpellLocation().y;

    	// X
    	if (player_location_x > spell_location_x) { // Lorann is on the right of the spell
    		spell_move.x = 1;
    	}
    	else if (player_location_x < spell_location_x) { // Lorann is on the left of the spell
    		spell_move.x = -1;
    	}
    	else{ // Lorann is on the same row
    		spell_move.x = 0;
    	}
    	// Y
    	if (player_location_y > spell_location_y) { // Lorann is over the spell
    		spell_move.y = -1;
    	}
    	else if (player_location_y < spell_location_y) { // Lorann is below the spell
    		spell_move.y = 1;
    	}
    	else { // Lorann is on the same column
    		spell_move.y = 0;
    	}
	}

	/**
     * Move the spell (if exist).
     * 
     * @see Events#setFuture_spell(int, int)
     * @see IModel#moveSpell(int, int)
     */
    public void moveSpell() {
        if (spell_is_alive == true) { // spell exist
            event.setFuture_spell(spell_move.x, spell_move.y); // update spell location
            if (event.spellCanReach() == true) { // there is void (can move)
                model.moveSpell(spell_move.x, spell_move.y); // moving spell
            }
            else if (event.spellCanReach() == false) { // there is an obstacle
                spell_move.x = - spell_move.x; // spell rebound (x)
                spell_move.y = - spell_move.y; // spell rebound (y)
            }
        }
    }
}
