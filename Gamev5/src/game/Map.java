/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to instantiate all locations and set links with hashmap
 * 
 */

public class Map implements Serializable {
    // list and araylist liskov method
    
    private List<Location> locations;
    private Location start;
    
    
    //constructor
    public Map(){
        locations = new ArrayList<>();
        Location start = new Location("start");
        Location mountain = new Location("mountain");
        Location canyon = new Location("canyon");
        Location ravine = new Location("ravine");
        Location slope = new Location("slope");
        Location kiosk = new Location("kiosk");
        
        start.setLink(Location.Direction.EAST, mountain);
        mountain.setLink(Location.Direction.WEST, start);
        mountain.setLink(Location.Direction.NORTH, canyon);
        mountain.setLink(Location.Direction.SOUTH, ravine);
        mountain.setLink(Location.Direction.EAST, slope);
        slope.setLink(Location.Direction.SOUTH, kiosk);
        kiosk.setLink(Location.Direction.NORTH, slope);
        kiosk.setLink(Location.Direction.WEST, start);
        
        locations.add(start);
        locations.add(mountain);
        locations.add(canyon);
        locations.add(ravine);
        locations.add(slope);
        locations.add(kiosk);    
    }

    boolean moveCharacter(Player player, Location.Direction direction) {
        // TODO locate/identify the player
        // look at player current location
        Location currentLocation = player.getLocation();
        //check to see if move is possible
        Location destination = currentLocation.compass(direction);
        if (destination != null)
        {
            currentLocation.exit(player);
            destination.enter(player);
            return true;
        }
        else{
            return false;
        }                  
    }
    
}
