package tepigmc.textadventure.tile;

public class Tiles {
  public static Tile wall = new Tile('\u2588', true);
  public static Tile empty = new Tile(' ', false);
  public static Tile door = new TileDoor();
}