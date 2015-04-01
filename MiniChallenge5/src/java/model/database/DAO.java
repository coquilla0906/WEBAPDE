/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Christian Gabriel
 */
public class DAO {

	private static DAO instance = null;
	private ArrayList<IDBGET> data;

	private DAO() {
		data = new ArrayList<IDBGET>();
                data.add(new UserDAO());
                data.add(new PictureDAO());
              
		
	}

	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}


	public Iterator get(String table) {
		if (table.equalsIgnoreCase("user"))
			return data.get(0).get();
                else if (table.equalsIgnoreCase("picture"))
			return data.get(1).get();
		return null;
	}

	
	public Object get(String table, String key) {
		if (table.equalsIgnoreCase("user"))
			return data.get(0).get(key);
                else if (table.equalsIgnoreCase("picture"))
			return data.get(1).get(key);

		return null;
	}

	/**
	 * returns all objects in the given table with searchStr in its primary key
	 * 
	 * @param table
	 *            table to search
	 * @param searchStr
	 *            search key
	 * @return all objects in this table with searchStr in its primary key
	 */
	public Iterator search(String table, String searchStr) {
		if (table.equalsIgnoreCase("user"))
			return data.get(0).search(searchStr);
                else if (table.equalsIgnoreCase("picture"))
			return data.get(0).search(searchStr);

		return null;
	}



	/**
	 * adds obj to the given table in the database
	 * 
	 * @param table
	 *            table to add to
	 * @param obj
	 *            object to add
	 */
	public void add(String table, Object obj) {
     
		if (table.equalsIgnoreCase("user"))
                {
          
			((IDBCUD) data.get(0)).add(obj);
                      
                }
                else if (table.equalsIgnoreCase("picture"))
                {
          
			((IDBCUD) data.get(1)).add(obj);
                      
                }
		
	
	}

	/**
	 * updates the object with key origKey with the values in obj in given table
	 * 
	 * @param table
	 *            table to update into
	 * @param obj
	 *            new values of object
	 * @param origKey
	 *            original key of object
	 */
	public void update(String table, Object obj, String origKey) {
		if (table.equalsIgnoreCase("user"))
			((IDBCUD) data.get(0)).update(obj, origKey);
                else if (table.equalsIgnoreCase("picture"))
			((IDBCUD) data.get(1)).update(obj, origKey);


	}

	/**
	 * deletes object in given table
	 * 
	 * @param table
	 *            table to delete from
	 * @param obj
	 *            object to delete
	 */
	public void delete(String table, Object obj) {
		if (table.equalsIgnoreCase("user"))
			((IDBCUD) data.get(0)).delete(obj);
                else if (table.equalsIgnoreCase("picture"))
			((IDBCUD) data.get(1)).delete(obj);

	}
        
}
