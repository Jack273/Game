/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
// This call is used to control the game
// It handles user inputs, player settings
//
public class MortalQuest {
    // reference variables
    private Map map;
    private Player player;
    private Scanner sc = new Scanner (System.in);
    
    private boolean playing = true;
    
    private int option;
    
    public void start(){
        
        Player player = new Player();
        player.setUp("Jack", 100, 50, 25);
        map = new Map();
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("default.map");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Serialization failed"+ ex.getMessage());
        }catch (Exception ex) {
            System.out.println("Some other error"+ ex.getMessage());
        }
               
        while (playing){
            userInput();
            //get user input
            processWorld();
            //proccess world
            outputWorld();
            //output world
        }
    }

    private void userInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose an option 1) move");
        option = in.nextInt();
        move();
        
    }
        

    private void processWorld() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void outputWorld() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void move() {
        
        System.out.println("Please choose a direction 1) North, 2) South, 3) East, 4) West ");
        int option = sc.nextInt();
        //final direction
        switch (option) {
            case 1:
                map.moveCharacter(player, Location.Direction.NORTH);
                break;
            case 2:
                map.moveCharacter(player, Location.Direction.SOUTH);
                break;
            case 3:
                map.moveCharacter(player, Location.Direction.EAST);
                break;
            case 4:
                map.moveCharacter(player, Location.Direction.WEST);
                break;
            default:
                throw new AssertionError();
        }
       //method move player
        
    }
        
    
}
