package tepigmc.textadventure.entity;

import tepigmc.textadventure.coordinates.Coordinates;

public interface Entity {
  Coordinates getCoordinates();
  char getIcon();
  
  void setCoordinates(Coordinates coordinates);
  void setIcon(char icon);
}