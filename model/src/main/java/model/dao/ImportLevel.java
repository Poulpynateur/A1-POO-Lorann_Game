package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.*;

/**
 * <h1>The Class ImportLevel import the level from the DB.</h1>
 *
 * @author Group 13
 * @version 2.0
 */	

public abstract class ImportLevel {
	
	/**
     * Create the map from database.
     *
     * @param levelID ID of the map's level
     * @return a map as a Array of String[][]
     */
	public static String[][] CreateMap(int levelID) {

		// Convert List<Example> to StringBuilder
		try {
	
			// 			Our variables
			// Will store different elements as String type
		     String x; 
		     String y;
		     String element;
		     
		     
		     //Real coordinates as integer
		     int cooX;
		     int cooY;
		     
		     //Our map
		     String[][]map = new String[20][12];
			
		     //Call our procedure and store data into our var 'message'
	
			final List<DatabaseMap> databaseMaps = ProcedureDAO.getLevelByID(levelID);
	
			final StringBuilder message = new StringBuilder();
		    for (final DatabaseMap databaseMap : databaseMaps) {
		        message.append(databaseMap);
		        message.append('\n'); 
		    }
	
		    //Convert StringBuilder type to String type
		    String stringMessage=message.toString();
		    
		   //Separe our different element in an array 
		    String[] ary = stringMessage.split("\n");
	
		     for(int i=0;i<ary.length;i++){	
		     	//Temporary String storing sql recording line per line
		        String provisional = ary[i];
		        //Separe our message from database to real coordinate
		         		//Example : Convert C;1;1
		         		//To Element=C, X=1, Y=1
				 String[] tempo = provisional.split(";"); // Cutting String
				 element=tempo[0];
				 x=tempo[1];
				 y=tempo[2];
	
				 //Convert String coordinates to integer
				 cooX=Integer.parseInt(x);
				 cooY=Integer.parseInt(y);
				 cooX-=1;
				 cooY-=1;
		       	  
				 //Store data into our map
				 map[cooX][cooY]=element;
	
				 }
		     return map;
		
		}
		catch(SQLException e) {e.printStackTrace();}
	   
	    return null;
    }
}

