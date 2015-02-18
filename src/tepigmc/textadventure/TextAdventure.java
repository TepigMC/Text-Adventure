package tepigmc.textadventure;

import tepigmc.textadventure.entity.Player;
import tepigmc.textadventure.item.Inventory;
import tepigmc.textadventure.item.ItemStack;
import tepigmc.textadventure.item.Items;
import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.room.Rooms;
import tepigmc.textadventure.ui.UIMain;
import tepigmc.textadventure.util.Convert;

public class TextAdventure {
  public static UIMain ui;
  
  public static void main(String[] args) {
    //Player player = new Player("center", new Coordinates(3, 3), null, '\u263A'); //smiley face
    Player player = new Player(
      '\u263A', //smiley face
      "maze",
      new Coordinates(5, 1),
      new Inventory(Convert.arrayToList(new ItemStack[] {
        new ItemStack(Items.banana, 5)
      }))
    );
    Rooms.init();

	  ui = new UIMain(player);
  }
}