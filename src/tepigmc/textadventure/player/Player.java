package tepigmc.textadventure.player;

import tepigmc.textadventure.entity.Entity;
import tepigmc.textadventure.entity.Merchant;
import tepigmc.textadventure.entity.NPC;
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
  
  public void handleEntityCollisions() {
    for (Entity entity : getRoom().getEntities()) {
      if (entity.getCoordinates().equals(this.playerCoordinates)) {
        if (entity instanceof NPC) {
          NPC npc = (NPC) entity;
          System.out.println("Move: You collided with " + npc.getName());
          if (entity instanceof Merchant) {
            //TODO activate trade
          }
        }
        //TODO
      }
    }
  }
  
  public boolean canMove(Room room, Coordinates coordinates) {
    int x = coordinates.getX();
    int y = coordinates.getY();
    if (x < 0 || y >= room.getWidth() ||
        x < 0 || y >= room.getHeight()) {
      System.out.println("Move: You can't move outside the room!");
      return false;
    }
    Tile nextTile = room.getTile(coordinates);
    if (nextTile.getSolid()) {
      System.out.println("Move: You can't move into a solid tile!");
      return false;
    }
    return true;
  }
  
  public boolean move(Coordinates coordinates) {
    if (!canMove(getRoom(), coordinates)) { return false; }
    Tile nextTile = getRoom().getTile(coordinates);
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
    handleEntityCollisions();
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
    String[] cmd = command.toLowerCase().split(" ");
    Direction direction = Direction.getDirection(cmd[0]);
    if (direction != null) {
      moveRelative(direction);
      return true;
    }
    return false;
  }
}