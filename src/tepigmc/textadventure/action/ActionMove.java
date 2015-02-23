package tepigmc.textadventure.action;

import tepigmc.textadventure.entity.Player;
import tepigmc.textadventure.location.Direction;

public class ActionMove implements Action {
  private Direction actionDirection;
  private int actionDistance;
    
  public ActionMove(Direction direction, int distance) {
    this.actionDirection = direction;
    this.actionDistance = distance;
  }
  
  public ActionMove(Direction direction) {
    this.actionDirection = direction;
    this.actionDistance = 1;
  }

  public Direction getDirection() { return actionDirection; }
  public int getDistance() { return actionDistance; }
  
  public void setDirection(Direction actionDirection) { this.actionDirection = actionDirection; }
  public void setDistance(int actionDistance) { this.actionDistance = actionDistance; }

  public void executeAction(Player player) {
    player.moveRelative(this.actionDirection, this.actionDistance);
  }
}