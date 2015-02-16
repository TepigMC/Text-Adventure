package tepigmc.textadventure.location;

public enum Direction {
  NORTH(new Coordinates(0, -1)),
  EAST(new Coordinates(1, 0)),
  SOUTH(new Coordinates(0, 1)),
  WEST(new Coordinates(-1, 0));
  
  private Coordinates relativeCoordinates;
  
  private Direction(Coordinates relative) {
    this.relativeCoordinates = relative;
  }
  
  public Coordinates getRelativeCoordinates() { return this.relativeCoordinates; };
}