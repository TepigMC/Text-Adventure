package tepigmc.textadventure.location;

public class Coordinates {
  private int xPos;
  private int yPos;
  
  public Coordinates(int x, int y) {
    this.xPos = x;
    this.yPos = y;
  }

  public int getX() { return this.xPos; }
  public int getY() { return this.yPos; }

  public void setX(int x) { this.xPos = x; }
  public void setY(int y) { this.yPos = y; }
  
  public String toString() { return "Coordinates(x:" + this.xPos + ", y:" + this.yPos + ")"; }

  public boolean equals(Coordinates coordinates) {
    if (this.xPos == coordinates.getX() && this.yPos == coordinates.getY()) {
      return true;
    }
    return false;
  }
}