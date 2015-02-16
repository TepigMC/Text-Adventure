package tepigmc.textadventure.room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tepigmc.textadventure.tile.Tile;

public class RoomFactory {
  public static Tile[][] generateMap(Object[] data) throws IllegalArgumentException {
    ArrayList<String> rows = new ArrayList<String>();
    HashMap<Character, Tile> hashMap = new HashMap<Character, Tile>();
    for (int i = 0; i < data.length; i++) {
      if (data[i] instanceof String) { rows.add((String) data[i]); }
      if (data[i] instanceof Character) {
        if (!(data[i+1] instanceof Tile)) {
          throw new IllegalArgumentException("'" + data[i] + "' doesn't have a tile to be mapped to");
        }
        hashMap.put((Character) data[i], (Tile) data[i+1]);
        i++;
      }
    }
    return generateMap(rows, hashMap);
  }
  public static Tile[][] generateMap(List<String> rows, HashMap<Character, Tile> hashMap) throws IllegalArgumentException {
    if (rows.size() == 0) { throw new IllegalArgumentException("There cannot be an empty map"); }
    Tile[][] map = new Tile[rows.size()][rows.get(0).length()];
    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[0].length; col++) {
        if (rows.get(row).length() != map[0].length) {
          throw new IllegalArgumentException("The map has irregularly sized rows");
        }
        Character tileChar = (Character) rows.get(row).charAt(col);
        if (!hashMap.containsKey(tileChar)) {
          throw new IllegalArgumentException("'" + tileChar + "' does not have a mapped tile");
        }
        map[row][col] = hashMap.get(tileChar);
      }
    }
    return map;
  }
}