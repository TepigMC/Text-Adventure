package tepigmc.textadventure.tile;

import tepigmc.textadventure.coordinates.Coordinates;

public class TileDoor extends Tile {
  private String roomID;
  private Coordinates roomCoordinates;
  
  public TileDoor() {
	  super('O', false);
  }

  public TileDoor(String id, Coordinates coordinates) {
	  super('O', false);
  	this.roomID = id;
    this.roomCoordinates = coordinates;
  }
  
  public TileDoor(char icon, String id, Coordinates coordinates) {
    super(icon, false);
    this.roomID = id;
    this.roomCoordinates = coordinates;
  }

  public String getRoomID() { return roomID; }
  public Coordinates getRoomCoordinates() { return this.roomCoordinates; }

  public boolean equals(TileDoor door) {
    if (this.getIcon() == door.getIcon() &&
        this.getSolid() == door.getSolid() &&
        this.roomID.equals(door.getRoomID()) &&
        this.roomCoordinates.equals(door.getRoomCoordinates())) {
      return true;
    }
    return false;
  }

  public String toString() {
    return getClass().getName() +
      " { icon: '" + this.getIcon() + "', solid: " + this.getSolid() + ", id:" + this.getRoomID() + ", coordinates:" + this.getRoomCoordinates() + " }";
  }
}