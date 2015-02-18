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
  
  public boolean isItem(Item item) { return this.itemStackItem.equals(item); }

  public void changeCount(int count) {
    int newCount = this.itemStackCount - count;
    if (newCount < 0) {
      newCount = 0;
      System.out.println("ItemStack: There aren't enough items to subtract " + count + "!");
    }
    this.itemStackCount = newCount;
  }
}