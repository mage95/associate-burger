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
public class Factories {
    private int id;
    private String name;
    private String location;
    private String email;

    public Factories(int id, String name, String location, String email) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.email = email;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
            
}
