package tepigmc.textadventure.entity;

import tepigmc.textadventure.item.Inventory;
import tepigmc.textadventure.location.Coordinates;

public class Fighter extends NPC {
  
  public Fighter(char icon, String name, Coordinates coordinates, Inventory inventory) {
    super(icon, name, coordinates, inventory);
  }
}