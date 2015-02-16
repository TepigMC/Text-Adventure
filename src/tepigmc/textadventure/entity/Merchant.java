package tepigmc.textadventure.entity;

import tepigmc.textadventure.inventory.Inventory;
import tepigmc.textadventure.location.Coordinates;

public class Merchant extends NPC {
  private Inventory merchantInventory;
  
  public Merchant(Coordinates coordinates, Inventory inventory, String name, char icon) {
    super(coordinates, name, icon);
    this.merchantInventory = inventory;
  }
  
  public Inventory getInventory() { return this.merchantInventory; }
  
  public void setInventory(Inventory inventory) { this.merchantInventory = inventory; }
}