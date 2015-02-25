package tepigmc.textadventure;

import tepigmc.textadventure.entity.Player;
import tepigmc.textadventure.item.Inventory;
import tepigmc.textadventure.item.ItemStack;
import tepigmc.textadventure.item.Items;
import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.room.Rooms;
import tepigmc.textadventure.util.Array;

public class TextAdventure {
  public static TextAdventureUI gameUI;
  public static Player gamePlayer;
  
  public static void main(String[] args) {
    Rooms.init();
    
    gameUI = new TextAdventureUI();
    //gamePlayer = new Player('\u263A', "center", new Coordinates(3, 3), null); //smiley face
    gamePlayer = new Player(
      '\u263A', //smiley face
      "maze",
      new Coordinates(5, 1),
      new Inventory(Array.toList(new ItemStack[] {
        new ItemStack(Items.banana, 5)
      }))
    );
  }
  
  public static TextAdventureUI getUI() { return gameUI; }
  public static Player getPlayer() { return gamePlayer; }
  
  public static void setUI(TextAdventureUI ui) { gameUI = ui; }
  public static void setPlayer(Player player) { gamePlayer = player; }
}