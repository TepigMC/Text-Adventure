package tepigmc.textadventure.entity;

import tepigmc.textadventure.location.Coordinates;

public interface Entity {
  Coordinates getCoordinates();
  char getIcon();
  
  void setCoordinates(Coordinates coordinates);
  void setIcon(char icon);
}