/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// This class holds values for locations
//
public class Location implements Serializable{

    public enum LocationConsequence {
        NOTHING, WIN, LOSE
    }

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    };

    private String name;
    private LocationConsequence consequence;
    private java.util.Map<Direction, Location> compass;
    private transient List<Player> characters;

    // Location constructor method one parameter
    public Location(String name) {
        this(name, LocationConsequence.NOTHING);
// how does this constructor work? Should be ?
// this.name = name
// this.consequence = LocationConsequence.NOTHING

    }
    //location constructor method 2 parameters
    // instantiates a HashMap under compass variable
    public Location(String name, LocationConsequence consequence) {
        this.consequence = consequence;
        this.name = name;
        compass = new HashMap<>();
        characters = new ArrayList<>();
    }
    // puts direction to location when called for 2 locations in Map package
    public void setLink(Direction direction, Location location) {
        compass.put(direction, location);
    }
    
    public void enter( Player character){
        character.setLocation(this);
        this.characters.add(character);
    }
    public void exit( Player character){
        this.characters.remove(character);
    }
    public Location compass(Direction direction) {
        return compass.get(direction);
    }
}
