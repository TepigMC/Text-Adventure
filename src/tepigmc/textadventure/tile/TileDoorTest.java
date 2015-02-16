package tepigmc.textadventure.tile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textadventure.location.Coordinates;

public class TileDoorTest {
  TileDoor door0;
  TileDoor door1;

  @Before
  public void setUp() throws Exception {
    door0 = new TileDoor("room", new Coordinates(2, 2));
    door1 = new TileDoor("room", new Coordinates(2, 2));
  }

  @After
  public void tearDown() throws Exception {
    
  }

  @Test
  public void testEquals() {
    assertTrue(door0.equals(door1));
    assertEquals(door0, door1);
  }
}