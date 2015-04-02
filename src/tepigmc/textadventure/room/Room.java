package tepigmc.textadventure.room;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textadventure.entity.Entity;
import tepigmc.textadventure.entity.Player;
import tepigmc.textadventure.location.Coordinates;
import tepigmc.textadventure.tile.Tile;
import tepigmc.textadventure.util.Array;

public class Room {
  private String roomID;
  private Tile[][] roomTiles;
  private List<Entity> roomEntities;
  private List<String> roomSetting;
  private int roomWidth;
  private int roomHeight;

  public Room(String id, Tile[][] tiles, List<Entity> entities, List<String> setting) {
    this.roomID = id;
    setTiles(tiles);
    this.roomEntities = entities;
    this.roomSetting = setting;
  }

  public Room(String id, Tile[][] tiles, String[] setting) {
    this(id, tiles, new ArrayList<Entity>(), Array.toList(setting));
  }

  public Room(String id, Tile[][] tiles) {
    this(id, tiles, new ArrayList<Entity>(), new ArrayList<String>());
  }

  public String getID() {	return roomID; }
  public Tile[][] getTiles() { return this.roomTiles; }
  public Tile getTile(Coordinates coordinates) {
    return this.roomTiles[coordinates.getY()][coordinates.getX()];
  }
  public List<Entity> getEntities() { return this.roomEntities; }
  public Entity[] getEntitiesArray() { return Array.toArray(this.roomEntities); }
  public Entity getEntity(int index) { return this.roomEntities.get(index); }
  public List<String> getSetting() { return this.roomSetting; }
  public String[] getSettingArray() { return Array.toArray(this.roomSetting); }
  public String getSetting(int index) { return this.roomSetting.get(index); }
  public int getWidth() { return this.roomWidth; }
  public int getHeight() { return this.roomHeight; }

  public void setID(String roomID) { this.roomID = roomID; }
  public void setTiles(Tile[][] tiles) {
    this.roomTiles = tiles;
    this.roomWidth = this.roomTiles[0].length;
    this.roomHeight = this.roomTiles.length;
  }
  public void setTile(Tile tile, Coordinates coordinates) {
    this.roomTiles[coordinates.getY()][coordinates.getX()] = tile;
  }
  public void setEntities(List<Entity> entities) { this.roomEntities = entities; }
  public void setEntities(Entity[] entities) { this.roomEntities = Array.toList(entities); }
  public void setEntities(Entity entity, int index) { this.roomEntities.set(index, entity); }
  public void addEntity(Entity entity) { this.roomEntities.add(entity); }
  public void addEntity(Entity entity, int index) { this.roomEntities.add(index, entity); }
  public void setSetting(List<String> setting) { this.roomSetting = setting; }
  public void setSetting(String[] setting) { this.roomSetting = Array.toList(setting); }
  public void setSetting(String setting, int index) { this.roomSetting.set(index, setting); }
  public void addSetting(String setting) { this.roomSetting.add(setting); }
  public void addSetting(String setting, int index) { this.roomSetting.add(index, setting); }

  public List<List<Character>> getTileIcons() {
    List<List<Character>> tiles = new ArrayList<List<Character>>();
    for (int i = 0; i < this.roomHeight; i++) {
      List<Character> list = new ArrayList<Character>();
      for (int j = 0; j < this.roomWidth; j++) {
        list.add(this.roomTiles[i][j].getIcon());
      }
      tiles.add(list);
    }
    return tiles;
  }
  
  public char[][] getTileIconsArray() {
    char[][] tiles = new char[this.roomHeight][this.roomWidth];
    for (int i = 0; i < this.roomHeight; i++) {
      for (int j = 0; j < this.roomWidth; j++) {
        tiles[i][j] = this.roomTiles[i][j].getIcon();
      }
    }
    return tiles;
  }

  public String renderRoom(Player player) {
    return renderTiles(renderEntity(renderEntities(getTileIcons(), this.roomEntities), player));
  }
  
  public String renderRoomCropped(Player player, int width, int height) {
    List<List<Character>> tiles = renderEntity(renderEntities(getTileIcons(), this.roomEntities), player);
    int minX = player.getCoordinates().getX() - width/2;
    int minY = player.getCoordinates().getY() - height/2;
    if (minX < 0) { minX = 0; }
    if (minY < 0) { minY = 0; }
    int maxX = minX + width;
    int maxY = minY + height;
    if (maxX >= tiles.get(0).size()) { maxX = tiles.get(0).size(); minX = maxX - width; }
    if (maxY >= tiles.size()) { maxY = tiles.size(); minY = maxY - height; }
    if (minX < 0) { minX = 0; }
    if (minY < 0) { minY = 0; }
    if (tiles.size() >= height || tiles.get(0).size() >= width) {
      for (int i = minY; i < maxY; i++) {
        tiles.set(i, tiles.get(i).subList(minX, maxX));
      }
    }
    return renderTiles(tiles.subList(minY, maxY));
  }
  
  public String renderTiles(List<List<Character>> tiles) {
    String tilesString = "";
    for (int i = 0; i < tiles.size(); i++) {
      for (int j = 0; j < tiles.get(i).size(); j++) {
        tilesString += tiles.get(i).get(j);
      }
      if (i < tiles.size()-1) { tilesString += "\n"; }
    }
    return tilesString;
  }

  public List<List<Character>> renderEntities(List<List<Character>> tiles, List<Entity> entities) {
    for (Entity entity : entities) {
      tiles = renderEntity(tiles, entity);
    }
    return tiles;
  }
  
  public List<List<Character>> renderEntity(List<List<Character>> tiles, Entity entity) {
    Coordinates entityCoords = entity.getCoordinates();
    if (entityCoords.getX() < this.roomWidth && entityCoords.getY() < this.roomHeight) {
      List<Character> list = tiles.get(entityCoords.getY());
      list.set(entityCoords.getX(), entity.getIcon());
      tiles.set(entityCoords.getY(), list);
    }
    else {
      System.err.println("Render: The entity '" + entity.getIcon() + "' cannot be drawn in room " + this.roomID + " at " + entityCoords);
    }
    return tiles;
  }
}