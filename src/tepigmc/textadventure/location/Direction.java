package tepigmc.textadventure.location;

import java.util.List;

import tepigmc.textadventure.util.Array;

public enum Direction {
  NORTH(new Coordinates(0, -1), new String[] {"north","n","up"}),
  EAST(new Coordinates(1, 0), new String[] {"east","e","right"}),
  SOUTH(new Coordinates(0, 1), new String[] {"south","s","down"}),
  WEST(new Coordinates(-1, 0), new String[] {"west","w","left"}),
  NE(new Coordinates(1, -1), new String[] {"northeast","ne"}),
  SE(new Coordinates(1, 1), new String[] {"southeast","se"}),
  SW(new Coordinates(-1, 1), new String[] {"southwest","sw"}),
  NW(new Coordinates(-1, -1), new String[] {"northwest","nw"});
  
  private Coordinates relativeCoordinates;
  private List<String> directionAliases;
  
  private Direction(Coordinates relative, String[] aliases) {
    this.relativeCoordinates = relative;
    this.directionAliases = Array.toList(aliases);
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
    if (Direction.NE.isDirection(direction)) { return Direction.NE; }
    if (Direction.SE.isDirection(direction)) { return Direction.SE; }
    if (Direction.SW.isDirection(direction)) { return Direction.SW; }
    if (Direction.NW.isDirection(direction)) { return Direction.NW; }
    return null;
  }
  
  public String toString() {
    return "Direction." + name();
  }
}