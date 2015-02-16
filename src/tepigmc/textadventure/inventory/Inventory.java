package tepigmc.textadventure.inventory;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textadventure.item.Item;

public class Inventory {
  private List<Item> inventoryItems;
  private int inventorySize;
  
  public Inventory(List<Item> items) {
    this.inventoryItems = items;
    updateSize();
  }
  
  public Inventory(Item[] items) {
    List<Item> itemList = new ArrayList<Item>();
    for (Item item : items) {
      itemList.add(item);
    }
    this.inventoryItems = itemList;
    updateSize();
  }

  public List<Item> getItems() { return this.inventoryItems; }
  public int getSize() { return this.inventorySize; }

  public void setItems(List<Item> items) {
    this.inventoryItems = items;
    updateSize();
  }
  private void updateSize() {
    this.inventorySize = this.inventoryItems.size();
  }
}