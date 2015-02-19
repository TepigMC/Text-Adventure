package tepigmc.textadventure.action;

import tepigmc.textadventure.entity.Player;

public interface Action {
  public void executeAction(Player player);
}