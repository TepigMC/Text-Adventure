package tepigmc.textadventure.room;

import java.util.HashMap;

import tepigmc.textadventure.entity.NPC;
import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.tile.TileDoor;
import tepigmc.textadventure.tile.Tiles;

public class Rooms {
  public static HashMap<String, Room> roomHashMap = new HashMap<String, Room>();
  public static Room roomMaze = new Room(
    "room_maze",
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
      'N', new TileDoor('\u2591', "room_north", new Coordinates(3, 5)),
      'E', new TileDoor('\u2591', "room_east", new Coordinates(1, 3))
    }),
    new String[] {
      "Welcome to the land of Text Adventuring!",
      "I Like Pie.",
      "Do You?"
    }
  );
  public static Room roomCenter = new Room(
    "room_center",
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
      'N', new TileDoor('\u2591', "room_north", new Coordinates(3, 5)),
      'S', new TileDoor('\u2591', "room_south", new Coordinates(3, 1)),
      'W', new TileDoor('\u2591', "room_west", new Coordinates(5, 3)),
      'E', new TileDoor('\u2591', "room_east", new Coordinates(1, 3))
    })
  );
  public static Room roomWest = new Room(
    "room_west",
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
      'A', new TileDoor('\u2591', "room_center", new Coordinates(1, 3))
    })
  );
  public static Room roomEast = new Room(
    "room_east",
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
      'B', new TileDoor('\u2591', "room_center", new Coordinates(5, 3))
    })
  );
  public static Room roomNorth = new Room(
    "room_north",
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
      'C', new TileDoor('\u2591', "room_center", new Coordinates(3, 1))
    })
  );
  public static Room roomSouth = new Room(
    "room_south",
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
      'D', new TileDoor('\u2591', "room_center", new Coordinates(3, 5))
    })
  );

  public static void init() {
    Rooms.registerRoom(Rooms.roomMaze);
    Rooms.registerRoom(Rooms.roomCenter);
    Rooms.registerRoom(Rooms.roomWest);
    Rooms.registerRoom(Rooms.roomEast);
    Rooms.registerRoom(Rooms.roomNorth);
    Rooms.registerRoom(Rooms.roomSouth);
    
    Rooms.roomMaze.addEntity(new NPC(new Coordinates(1, 1), "Fredrich", 'o'));
  }

  public static void registerRoom(Room room) {
    roomHashMap.put(room.getID(), room);
  }
  
  public static Room get(String roomID) {
    return roomHashMap.get(roomID);
  }
}