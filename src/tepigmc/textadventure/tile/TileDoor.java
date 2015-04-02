package tepigmc.textadventure.tile;

import tepigmc.textadventure.location.Coordinates;

public class TileDoor extends Tile {
  private String roomID;
  private Coordinates roomCoordinates;
  
  public TileDoor(char icon, String id, Coordinates coordinates) {
    super(icon, false);
    this.roomID = id;
    this.roomCoordinates = coordinates;
  }
  
  public TileDoor(String id, Coordinates coordinates) {
	  this('O', id, coordinates);
  }
  
  public TileDoor() {
    this(null, null);
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