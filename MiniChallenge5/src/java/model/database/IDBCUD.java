/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

/**
 *
 * @author User
 */
public interface IDBCUD extends IDBGET {
    
    /**
	* adds object to the database
	* @param object object to add
	*/
	public void add( Object object );
	
	/**
	* updates the object with key origKey with the values in object
	* @param object new values of object
	* @param origKey original key of object
	*/
	public void update( Object object, String origKey );
	
	/**
	* deletes object
	* @param object object to delete
	*/
	public void delete( Object object );
    
}
