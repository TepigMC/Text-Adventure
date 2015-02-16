package tepigmc.textadventure.item;

public class Trade {
  private ItemStack tradeOfferItemStack;
  private ItemStack tradeWantItemStack;
  
  public Trade(ItemStack offerItemStack, ItemStack wantItemStack) {
    this.tradeOfferItemStack = offerItemStack;
    this.tradeWantItemStack = wantItemStack;
  }
  
  public ItemStack getOfferItemStack() { return this.tradeOfferItemStack; }
  public ItemStack getWantItemStack() { return this.tradeWantItemStack; }
  
  public void setOfferItemStack(ItemStack offerItemStack) { this.tradeOfferItemStack = offerItemStack; }
  public void setWantItemStack(ItemStack wantItemStack) { this.tradeWantItemStack = wantItemStack; }
  
  public boolean trade(Inventory offerInventory, Inventory wantInventory) {
    if (!canTrade(offerInventory, wantInventory)) { return false; }
    ItemStack wantItemStack = this.tradeWantItemStack;
    ItemStack offerItemStack = this.tradeOfferItemStack;
    wantInventory.decreaseCount(wantItemStack.getItem(), wantItemStack.getCount());
    offerInventory.decreaseCount(offerItemStack.getItem(), offerItemStack.getCount());
    //TODO finish trade()
    return true;
  }
  
  public boolean canTrade(Inventory offerInventory, Inventory wantInventory) {
    if (!(offerInventory.getCount(this.tradeOfferItemStack.getItem()) >= this.tradeOfferItemStack.getCount())) {
      System.out.println("Trade: Offering entity cannot trade!");
      return false;
    }
    if (!(wantInventory.getCount(this.tradeWantItemStack.getItem()) >= this.tradeWantItemStack.getCount())) {
      System.out.println("Trade: Wanting entity cannot trade!");
    }
    return true;
  }
}