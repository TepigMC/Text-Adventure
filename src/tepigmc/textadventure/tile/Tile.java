package tepigmc.textadventure.tile;

public class Tile {//previously abstract
  private char tileIcon;
  private boolean tileSolid;

  //http://www.theasciicode.com.ar/
  public Tile(char icon, boolean solid) {
    tileIcon = icon;
    tileSolid = solid;
  }

  public char getIcon() { return this.tileIcon; }
  public boolean getSolid() { return this.tileSolid; }

  public void setIcon(char icon) { this.tileIcon = icon; }
  public void setSolid(boolean solid) { this.tileSolid = solid; }

  public String toString() {
    return getClass().getName() +
      " { icon: '" + this.tileIcon + "', solid: " + this.tileSolid + " }";
  }

  public boolean equals(Tile tile) {
    if (this.getIcon() == tile.getIcon() && this.getSolid() == tile.getSolid()) {
      return true;
    }
    return false;
  }
}