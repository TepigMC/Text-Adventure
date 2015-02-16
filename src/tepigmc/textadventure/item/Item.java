package tepigmc.textadventure.item;

public class Item {
  private String itemName;
  
  public Item(String name) {
    this.itemName = name;
  }

  public String getName() { return this.itemName; }

  public void setName(String name) { this.itemName = name; }
};