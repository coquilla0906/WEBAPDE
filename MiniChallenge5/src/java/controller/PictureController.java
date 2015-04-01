/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Iterator;
import model.Picture;
import model.database.DAO;
import model.database.PictureDAO;

/**
 *
 * @author Bryan
 */
public class PictureController {
    
    private static PictureController instance;
    private DAO dao;
    private Picture picture;
    private PictureDAO pictureDAO;
    
    public PictureController() {
        dao = DAO.getInstance();
        picture = new Picture();
        pictureDAO = new PictureDAO();
        
    }
    
    public static PictureController getInstance() {
        if (instance == null) {
            instance = new PictureController();
        }
        return instance;
    }
    
    public int getMaxPicID(){
        return pictureDAO.getPicID();
    }
    
    public void addPicture(Picture p){
        dao.add("picture", p);

    }
    
    public Object getObject(String key) {
        return dao.get("picture", key);
    }

    public Iterator getAll() {
        return dao.get("picture");
    }
    
    
    
    public Picture getPicture(){
        return picture;
    }
    
}
