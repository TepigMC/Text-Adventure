package tepigmc.textadventure.events;

import tepigmc.textadventure.entity.NPC;
import tepigmc.textadventure.entity.Player;

public class Trading {
  private Player tradingPlayer;
  private NPC tradingNPC;
  
  public Trading(Player player, NPC npc) {
    this.tradingPlayer = player;
    this.tradingNPC = npc;
  }
  
  public Player getPlayer() { return this.tradingPlayer; }
  public NPC getNPC() { return this.tradingNPC; }
  
  public void setPlayer(Player player) { this.tradingPlayer = player; }
  public void setNPC(NPC npc) { this.tradingNPC = npc; }
}