package tepigmc.textadventure.room;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.tile.Tile;
import tepigmc.textadventure.tile.Tiles;

public class RoomTest {
  Tile tile0;
  Room room0;
  
  @Before
  public void setUp() throws Exception {
    tile0 = new Tile('x', true);
    room0 = new Room("room0", new Tile[][] {
      {Tiles.wall, Tiles.wall, Tiles.empty},
      {tile0, Tiles.empty, Tiles.wall}
    });
  }

  @After
  public void tearDown() throws Exception {
    
  }

  @Test
  public void testGetTile() {
    System.out.println(tile0);
    System.out.println(room0.getTile(new Coordinates(0, 1)));
    assertTrue(tile0.equals(room0.getTile(new Coordinates(0, 1))));
  }
}