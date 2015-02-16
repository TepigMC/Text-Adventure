package tepigmc.textadventure.item;

public class Item {
  private String itemName;
  private int itemCount;
  
  public Item(String name, int count) {
    this.itemName = name;
    this.itemCount = count;
  }

  public String getName() { return this.itemName; }
  public int getCount() { return this.itemCount; }

  public void setName(String name) { this.itemName = name; }
  public void setCount(int count) { this.itemCount = count; } 
};