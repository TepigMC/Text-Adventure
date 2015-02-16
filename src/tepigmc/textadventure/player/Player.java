package tepigmc.textadventure.player;

import tepigmc.textadventure.entity.Entity;
import tepigmc.textadventure.inventory.Inventory;
import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.location.Direction;
import tepigmc.textadventure.room.Room;
import tepigmc.textadventure.room.Rooms;
import tepigmc.textadventure.tile.Tile;
import tepigmc.textadventure.tile.TileDoor;

public class Player implements Entity {
  private Coordinates playerCoordinates;
  private Inventory playerInventory;
  private char playerIcon;
  private String playerRoomID;

  public Player(String roomID, Coordinates coordinates, Inventory inventory, char icon) {
    this.playerCoordinates = coordinates;
    this.playerInventory = inventory;
    this.playerIcon = icon;
    this.playerRoomID = roomID;
  }

  public Coordinates getCoordinates() { return this.playerCoordinates; }
  public Inventory getInventory() { return this.playerInventory; }
  public char getIcon() { return this.playerIcon; }
  public String getRoomID() { return this.playerRoomID; }
  public Room getRoom() { return Rooms.get(this.playerRoomID); }

  public void setCoordinates(Coordinates coordinates) { this.playerCoordinates = coordinates; }
  public void setInventory(Inventory inventory) { this.playerInventory = inventory; }
  public void setIcon(char icon) { this.playerIcon = icon; }
  public void setRoomID(String roomID) { this.playerRoomID = roomID; }
  public void setRoom(Room room) { this.playerRoomID = room.getID(); }

  public Coordinates getCoordinatesRelative(Coordinates relative) {
    int newX = this.playerCoordinates.getX() + relative.getX();
    int newY = this.playerCoordinates.getY() + relative.getY();
    return new Coordinates(newX, newY);
  }
  
  public void setCoordinatesRelative(Coordinates relative) {
    int newX = this.playerCoordinates.getX() + relative.getX();
    int newY = this.playerCoordinates.getY() + relative.getY();
    setCoordinates(new Coordinates(newX, newY));
  }
  
  public boolean move(Coordinates coordinates) {
    int x = coordinates.getX();
    int y = coordinates.getY();
    if (x < 0 || y >= getRoom().getWidth() ||
        x < 0 || y >= getRoom().getHeight()) {
      System.out.println("Move: You can't move outside the room!");
      return false;
    }
    Tile nextTile = getRoom().getTile(coordinates);
    if (nextTile.getSolid()) {
      System.out.println("Move: You can't move into a solid tile!");
      return false;
    }

    if (nextTile instanceof TileDoor) {
      TileDoor door = (TileDoor) nextTile;
      System.out.println(
        "Teleport: to " + door.getRoomID() + " at " + door.getRoomCoordinates() +
        " from " + getRoomID() + " at " + getCoordinates());
      setRoomID(door.getRoomID());
      setCoordinates(door.getRoomCoordinates());
    }
    else {
      setCoordinates(coordinates);
    }
    return true;
  }
  
  public boolean moveRelative(Coordinates relative) {
    return move(getCoordinatesRelative(relative));
  }

  public boolean moveRelative(Direction direction) {
    return move(getCoordinatesRelative(direction.getRelativeCoordinates()));
  }
  
  public boolean moveRelative(Direction direction, int distance) {
    return move(getCoordinatesRelative(direction.getRelativeCoordinates(distance)));
  }
  
  public boolean executeCommand(String command) {
    String cmd = command.toLowerCase();
    if (cmd.equals("north") || cmd.equals("n") || 
        cmd.equals("up") || cmd.equals("u")) {
      moveRelative(Direction.NORTH);
      return true;
    }
    if (cmd.equals("south") || cmd.equals("s") || 
        cmd.equals("down") || cmd.equals("d")) {
      moveRelative(Direction.SOUTH);
      return true;
    }
    if (cmd.equals("west") || cmd.equals("w") || 
        cmd.equals("left") || cmd.equals("l")) {
      moveRelative(Direction.WEST);
      return true;
    }
    if (cmd.equals("east") || cmd.equals("e") || 
        cmd.equals("right") || cmd.equals("r")) {
      moveRelative(Direction.EAST);
      return true;
    }
    return false;
  }
}