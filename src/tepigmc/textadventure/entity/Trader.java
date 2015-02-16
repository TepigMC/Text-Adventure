package tepigmc.textadventure.entity;

import tepigmc.textadventure.item.Inventory;
import tepigmc.textadventure.item.Trade;
import tepigmc.textadventure.location.Coordinates;

public class Trader extends NPC {
  private Trade traderTrade;
  
  public Trader(Coordinates coordinates, Inventory inventory, Trade trade, String name, char icon) {
    super(coordinates, inventory, name, icon);
  }
  
  public Trade getTrade() { return this.traderTrade; }
  
  public void setTrade(Trade trade) { this.traderTrade = trade; }
  
  public boolean canTrade(Inventory wantInventory) {
    return this.traderTrade.canTrade(this.getInventory(), wantInventory);
  }
  
  public boolean trade(Inventory wantInventory) {
    return this.getTrade().trade(this.getInventory(), wantInventory);
  }
}