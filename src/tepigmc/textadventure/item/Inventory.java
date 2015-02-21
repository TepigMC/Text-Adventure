package tepigmc.textadventure.item;

import java.util.List;

import tepigmc.textadventure.util.Array;

public class Inventory {
  private List<ItemStack> inventoryItemStacks;
  private int inventorySize;
  
  public Inventory(List<ItemStack> itemStacks) {
    setItemStacks(itemStacks);
  }
  
  public Inventory(ItemStack[] itemStacks) {
    setItemStacks(Array.toList(itemStacks));
  }

  public List<ItemStack> getItems() { return this.inventoryItemStacks; }
  public int getSize() { return this.inventorySize; }

  public void setItemStacks(List<ItemStack> itemStacks) {
    this.inventoryItemStacks = itemStacks;
    updateSize();
  }
  private void updateSize() {
    this.inventorySize = this.inventoryItemStacks.size();
  }
  
  public boolean containsItem(Item item) {
    for (ItemStack itemStack : this.inventoryItemStacks) {
      if (itemStack.isItem(item)) { return true; }
    }
    return false;
  }
  
  public boolean containsItemStack(ItemStack itemStack) {
    if (this.inventoryItemStacks.contains(itemStack)) { return true; }
    return false;
  }
  
  public int getCount(Item item) {
    for (ItemStack itemStack : this.inventoryItemStacks) {
      if (itemStack.isItem(item)) { return itemStack.getCount(); }
    }
    return 0;
  }
  
  public void addCount(Item item, int count) {
    for (ItemStack itemStack : this.inventoryItemStacks) {
      if (itemStack.isItem(item)) {
        itemStack.addCount(count);
      }
    }
  }
  
  public boolean subtractCount(Item item, int count) {
    for (ItemStack itemStack : this.inventoryItemStacks) {
      if (itemStack.isItem(item)) {
        if (itemStack.subtractCount(count)) { return true; }
        count -= itemStack.getCount();
      }
    }
    return false;
  }
}