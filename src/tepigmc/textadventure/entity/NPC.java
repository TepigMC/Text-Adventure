package tepigmc.textadventure.entity;

import tepigmc.textadventure.item.Inventory;
import tepigmc.textadventure.location.Coordinates;

public class NPC implements Entity {
  private char npcIcon;
  private String npcName;
  private Coordinates npcCoordinates;
  private Inventory npcInventory;
  
  public NPC(char icon, String name, Coordinates coordinates, Inventory inventory) {
    this.npcIcon = icon;
    this.npcName = name;
    this.npcCoordinates = coordinates;
    this.npcInventory = inventory;
  }
  
  public char getIcon() { return this.npcIcon; }
  public String getName() { return this.npcName; }
  public Coordinates getCoordinates() { return this.npcCoordinates; }
  public Inventory getInventory() { return this.npcInventory; }

  public void setIcon(char icon) { this.npcIcon = icon; }
  public void setName(String name) { this.npcName = name; }
  public void setCoordinates(Coordinates coordinates) { this.npcCoordinates = coordinates; }
  public void setInventory(Inventory inventory) { this.npcInventory = inventory; }
}