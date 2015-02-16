package tepigmc.textadventure.room;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textadventure.coordinates.Coordinates;
import tepigmc.textadventure.tile.Tile;
import tepigmc.textadventure.tile.TileDoor;
import tepigmc.textadventure.tile.Tiles;
import tepigmc.textadventure.util.Compare;

public class RoomFactoryTest {
  Tile[][] map0;
  Tile[][] map1;
  List<String> rows0;
  List<String> rows1;
  HashMap<Character, Tile> hashMap0;
  HashMap<Character, Tile> hashMap1;

  @Before
  public void setUp() throws Exception {
    map0 = new Tile[][] {
      {Tiles.wall, Tiles.wall, Tiles.wall},
      {Tiles.wall, Tiles.empty, Tiles.wall},
      {Tiles.wall, Tiles.wall, Tiles.wall}
    };
    map1 = new Tile[][] {
      {Tiles.wall, Tiles.wall, Tiles.wall, Tiles.wall, Tiles.wall},
      {Tiles.wall, Tiles.empty, Tiles.empty, Tiles.empty, Tiles.wall},
      {new TileDoor("room_west", new Coordinates(0, 0)), Tiles.empty, Tiles.empty, Tiles.empty, new TileDoor("room_east", new Coordinates(0, 0))},
      {Tiles.wall, Tiles.empty, Tiles.empty, Tiles.empty, Tiles.wall},
      {Tiles.wall, Tiles.wall, Tiles.wall, Tiles.wall, Tiles.wall}
    };
    rows0 = new ArrayList<String>();
    rows0.add("xxx");
    rows0.add("x x");
    rows0.add("xxx");
    rows1 = new ArrayList<String>();
    rows1.add("xxxxx");
    rows1.add("x   x");
    rows1.add("W   E");
    rows1.add("x   x");
    rows1.add("xxxxx");
    hashMap0 = new HashMap<Character, Tile>();
    hashMap0.put('x', Tiles.wall);
    hashMap0.put(' ', Tiles.empty);
    hashMap1 = new HashMap<Character, Tile>();
    hashMap1.put('x', Tiles.wall);
    hashMap1.put(' ', Tiles.empty);
    hashMap1.put('W', new TileDoor("room_west", new Coordinates(0, 0)));
    hashMap1.put('E', new TileDoor("room_east", new Coordinates(0, 0)));
  }

  @After
  public void tearDown() throws Exception {
    
  }

  @Test
  public void testGenerateMap_objectArray() {
    assertTrue(
      Compare.arrayEquals(
        map0,
        RoomFactory.generateMap(
          new Object[] {
            "xxx",
            "x x",
            "xxx",
            'x', Tiles.wall,
            ' ', Tiles.empty
          }
        )
      )
    );
  }
  
  @Test
  public void testGenerateMap_hashMap() {
    assertTrue(Compare.arrayEquals(map0, RoomFactory.generateMap(rows0, hashMap0)));
  }

  @Test
  public void testGenerateMap_objectArray_doors() {
    assertTrue(
      Compare.arrayEquals(
        map1,
        RoomFactory.generateMap(
          new Object[] {
            "xxxxx",
            "x   x",
            "W   E",
            "x   x",
            "xxxxx",
            'x', Tiles.wall,
            ' ', Tiles.empty,
            'W', new TileDoor("room_west", new Coordinates(0, 0)),
            'E', new TileDoor("room_east", new Coordinates(0, 0))
          }
        )
      )
    );
  }
  
  @Test
  public void testGenerateMap_hashMap_doors() {
    assertTrue(Compare.arrayEquals(map1, RoomFactory.generateMap(rows1, hashMap1)));
  }
}
