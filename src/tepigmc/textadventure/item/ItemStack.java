package tepigmc.textadventure.item;

public class ItemStack {
  private Item itemStackItem;
  private int itemStackCount;
  
  public ItemStack(Item item, int count) {
    this.itemStackItem = item;
    this.itemStackCount = count;
  }
  
  public Item getItem() { return this.itemStackItem; }
  public int getCount() { return this.itemStackCount; }
  
  public void setItem(Item item) { this.itemStackItem = item; }
  public void setCount(int count) { this.itemStackCount = count; }
  
  public boolean hasCount(int count) { return this.itemStackCount >= count; }
  
  public boolean isItem(Item item) { return this.itemStackItem.equals(item); }

  public void addCount(int count) {
    this.itemStackCount += count;
  }
  
  public boolean subtractCount(int count) {
    if (!hasCount(count)) { return false; }
    this.itemStackCount -= count;
    return true;
  }
}