package tepigmc.textadventure.entity;

import tepigmc.textadventure.location.Coordinates;

public interface Entity {
  char getIcon();
  Coordinates getCoordinates();
  
  void setIcon(char icon);
  void setCoordinates(Coordinates coordinates);
}