package tepigmc.textadventure;

import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.player.Player;
import tepigmc.textadventure.room.Rooms;
import tepigmc.textadventure.ui.UIMain;

public class TextAdventure {
  public static UIMain ui;
  
  public static void main(String[] args) {
    //Player player = new Player("room_center", new Coordinates(3, 3), null, '\u263A'); //smiley face
    Player player = new Player("room_maze", new Coordinates(5, 1), null, '\u263A'); //smiley face
    Rooms.init();

	  ui = new UIMain(player);
  }
}