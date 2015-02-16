package tepigmc.textadventure.entity;

import tepigmc.textadventure.location.Coordinates;

public class NPC implements Entity {
  private Coordinates npcCoordinates;
  private String npcName;
  private char npcIcon;
  
  public NPC(Coordinates coordinates, String name, char icon) {
    this.npcCoordinates = coordinates;
    this.npcName = name;
    this.npcIcon = icon;
  }
  
  public Coordinates getCoordinates() { return this.npcCoordinates; }
  public String getName() { return this.npcName; }
  public char getIcon() { return this.npcIcon; }
  
  public void setCoordinates(Coordinates coordinates) { this.npcCoordinates = coordinates; }
  public void setName(String name) { this.npcName = name; }
  public void setIcon(char icon) { this.npcIcon = icon; }
}