/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.Serializable;
import java.util.ArrayList;


//Contains all character values
public class Player{
    private String name;
    private int health;
    private int stamina;
    private int strength;
    public Location location;
    
    public void setUp(String name, int health, int stamina, int strength)
    {
        this.name = name;
        this.health = health;
        this.stamina = stamina;
        this.strength = strength; 
        
    }
    public String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health;
    }
    public int getStamina()
    {
        return stamina;
    }
    public int getStrength()
    {
        return strength;
    }

    public Location getLocation() {
        return this.location;
    }
    public void setLocation(Location location){
        this.location = location;
    }
}


