package tepigmc.textadventure.entity;

import tepigmc.textadventure.item.Inventory;
import tepigmc.textadventure.location.Coordinates;

public class NPC implements Entity {
  private Coordinates npcCoordinates;
  private Inventory npcInventory;
  private String npcName;
  private char npcIcon;
  
  public NPC(Coordinates coordinates, Inventory inventory, String name, char icon) {
    this.npcCoordinates = coordinates;
    this.npcInventory = inventory;
    this.npcName = name;
    this.npcIcon = icon;
  }
  
  public Coordinates getCoordinates() { return this.npcCoordinates; }
  public Inventory getInventory() { return this.npcInventory; }
  public String getName() { return this.npcName; }
  public char getIcon() { return this.npcIcon; }

  public void setCoordinates(Coordinates coordinates) { this.npcCoordinates = coordinates; }
  public void setInventory(Inventory inventory) { this.npcInventory = inventory; }
  public void setName(String name) { this.npcName = name; }
  public void setIcon(char icon) { this.npcIcon = icon; }
}