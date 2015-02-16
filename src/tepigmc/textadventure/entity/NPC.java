package tepigmc.textadventure.entity;

import tepigmc.textadventure.coordinates.Coordinates;

public class NPC implements Entity {
  private Coordinates npcCoordinates;
  private char npcIcon;
  
  public NPC(Coordinates coordinates, char icon) {
    this.npcCoordinates = coordinates;
    this.npcIcon = icon;
  }
  
  public Coordinates getCoordinates() { return this.npcCoordinates; }
  public char getIcon() { return this.npcIcon; }
  
  public void setCoordinates(Coordinates coordinates) { this.npcCoordinates = coordinates; }
  public void setIcon(char icon) { this.npcIcon = icon; }
}