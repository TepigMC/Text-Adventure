package tepigmc.textadventure.room;

import java.util.HashMap;

import tepigmc.textadventure.entity.NPC;
import tepigmc.textadventure.entity.Trader;
import tepigmc.textadventure.item.Inventory;
import tepigmc.textadventure.item.ItemStack;
import tepigmc.textadventure.item.Items;
import tepigmc.textadventure.item.Trade;
import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.tile.TileDoor;
import tepigmc.textadventure.tile.Tiles;
import tepigmc.textadventure.util.Convert;

public class Rooms {
  public static HashMap<String, Room> roomHashMap = new HashMap<String, Room>();
  public static Room maze = new Room(
    "maze",
    RoomFactory.generateMap(new Object[] {
      "xxxxxNxxxxxxxxxxxxxxx",
      "x x   x x       x   x",
      "x x x x x x xxx xxx x",
      "x   x x   x x x     x",
      "xxxxx xxxxx x xxxxx x",
      "x   x       x     x x",
      "x x xxxxxxxxx x xxx x",
      "x x x         x x   x",
      "x x x xxxxx x x x xxx",
      "x x   x   x x x   x x",
      "x xxxxxxx x x xxxxx x",
      "x x       x x   x   x",
      "x xxxxx x x xxx xxx x",
      "x     x x x   x   x x",
      "xxxxx x xxx xxxxx x x",
      "x   x x     x     x x",
      "x x x xxxxx x xxxxx x",
      "x x   x   x x     x x",
      "x xxxxx x xxxxxxx x x",
      "x       x           E",
      "xxxxxxxxxxxxxxxxxxxxx",
      'x', Tiles.wall,
      ' ', Tiles.empty,
      'N', new TileDoor('\u2591', "north", new Coordinates(3, 5)),
      'E', new TileDoor('\u2591', "east", new Coordinates(1, 3))
    }),
    new String[] {
      "Welcome to the land of Text Adventuring!",
      "I Like Pie.",
      "Do You?"
    }
  );
  public static Room center = new Room(
    "center",
    RoomFactory.generateMap(new Object[] {
      "xxxNxxx",
      "x     x",
      "x     x",
      "W     E",
      "x     x",
      "x     x",
      "xxxSxxx",
      'x', Tiles.wall,
      ' ', Tiles.empty,
      'N', new TileDoor('\u2591', "north", new Coordinates(3, 5)),
      'S', new TileDoor('\u2591', "south", new Coordinates(3, 1)),
      'W', new TileDoor('\u2591', "west", new Coordinates(5, 3)),
      'E', new TileDoor('\u2591', "east", new Coordinates(1, 3))
    })
  );
  public static Room west = new Room(
    "west",
    RoomFactory.generateMap(new Object[] {
      "xxxxxxx",
      "x     x",
      "x     x",
      "x     A",
      "x     x",
      "x     x",
      "xxxxxxx",
      'x', Tiles.wall,
      ' ', Tiles.empty,
      'A', new TileDoor('\u2591', "center", new Coordinates(1, 3))
    })
  );
  public static Room east = new Room(
    "east",
    RoomFactory.generateMap(new Object[] {
      "xxxxxxx",
      "x     x",
      "x     x",
      "B     x",
      "x     x",
      "x     x",
      "xxxxxxx",
      'x', Tiles.wall,
      ' ', Tiles.empty,
      'B', new TileDoor('\u2591', "center", new Coordinates(5, 3))
    })
  );
  public static Room north = new Room(
    "north",
    RoomFactory.generateMap(new Object[] {
      "xxxxxxx",
      "x     x",
      "x     x",
      "x     x",
      "x     x",
      "x     x",
      "xxxCxxx",
      'x', Tiles.wall,
      ' ', Tiles.empty,
      'C', new TileDoor('\u2591', "center", new Coordinates(3, 1))
    })
  );
  public static Room south = new Room(
    "south",
    RoomFactory.generateMap(new Object[] {
      "xxxDxxx",
      "x     x",
      "x     x",
      "x     x",
      "x     x",
      "x     x",
      "xxxxxxx",
      'x', Tiles.wall,
      ' ', Tiles.empty,
      'D', new TileDoor('\u2591', "center", new Coordinates(3, 5))
    })
  );

  public static void init() {
    Rooms.registerRoom(Rooms.maze);
    Rooms.registerRoom(Rooms.center);
    Rooms.registerRoom(Rooms.west);
    Rooms.registerRoom(Rooms.east);
    Rooms.registerRoom(Rooms.north);
    Rooms.registerRoom(Rooms.south);
    
    Rooms.maze.addEntity(
      new NPC(
        'N', "Fredrich",
        new Coordinates(1, 1),
        new Inventory(Convert.arrayToList(new ItemStack[] {
          new ItemStack(Items.apple, 5)
        }))
      )
    );
    Rooms.maze.addEntity(
      new Trader(
        'T', "Trader Joe", 
        new Coordinates(7, 1),
        new Inventory(Convert.arrayToList(new ItemStack[] {
          new ItemStack(Items.apple, 5)
        })),
        new Trade(
          new ItemStack(Items.apple, 2),
          new ItemStack(Items.banana, 3)
        )
      )
    );
  }

  public static void registerRoom(Room room) {
    roomHashMap.put(room.getID(), room);
  }
  
  public static Room get(String roomID) {
    return roomHashMap.get(roomID);
  }
}