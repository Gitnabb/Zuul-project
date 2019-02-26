package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Class src.Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "src.Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private Item item;
    private String description;
    private HashMap<String, Room> exits;
    ArrayList<Item> itemsInRoom;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        itemsInRoom = new ArrayList<>();
    }

    public void createItem(String itemName, double itemWeight){

        item = new Item(itemName, itemWeight);
        itemsInRoom.add(item);

    }


    public Room getExit(String direction){

        return exits.get(direction);
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExit(String direction, Room neighborRoom)
    {
       exits.put(direction, neighborRoom);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Get description of the room and the available exits
     * @return description and exits
     */
    public String getLongDescription(){

        return "You are " + getDescription() +".\n" + getExitString() + getItemString();
    }

    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit + " ";
        }
        return returnString;
    }

    public String getItemString(){
       String itemReturnString = "Items: ";
            for(Item item : itemsInRoom) {
                itemReturnString += item.getName() + " , ";

            }
            return itemReturnString;
    }

}
