/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author RYANDY BAGHASKORO
 * Last Edit : 14-01-2015 by mage95 
 */
public class Reviews {
    private int id;
    private int user_id;
    private String text;

    public Reviews(int id, int user_id, String text) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
