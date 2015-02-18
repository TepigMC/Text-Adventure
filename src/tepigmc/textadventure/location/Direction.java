package tepigmc.textadventure.location;

import java.util.List;

import tepigmc.textadventure.util.Convert;

public enum Direction {
  NORTH(new Coordinates(0, -1), new String[] {"north","n","up"}),
  EAST(new Coordinates(1, 0), new String[] {"east","e","right"}),
  SOUTH(new Coordinates(0, 1), new String[] {"south","s","down"}),
  WEST(new Coordinates(-1, 0), new String[] {"west","w","left"});
  
  private Coordinates relativeCoordinates;
  private List<String> directionAliases;
  
  private Direction(Coordinates relative, String[] aliases) {
    this.relativeCoordinates = relative;
    this.directionAliases = Convert.arrayToList(aliases);
  }
  
  public Coordinates getRelativeCoordinates() { return this.relativeCoordinates; };
  public Coordinates getRelativeCoordinates(int distance) {
    Coordinates relative = getRelativeCoordinates();
    relative.setX(relative.getX() * distance);
    relative.setY(relative.getY() * distance);
    return relative;
  }
  public boolean isDirection(String direction) { return this.directionAliases.contains(direction); }

  public static Direction getDirection(String direction) {
    if (Direction.NORTH.isDirection(direction)) { return Direction.NORTH; }
    if (Direction.EAST.isDirection(direction)) { return Direction.EAST; }
    if (Direction.SOUTH.isDirection(direction)) { return Direction.SOUTH; }
    if (Direction.WEST.isDirection(direction)) { return Direction.WEST; }
    return null;
  }
  
  public String toString() {
    return "Direction." + name();
  }
}