# Flyweight_RPGMap_DP
* Flyweight pattern is used for tile graphics (images), which are shared across multiple tiles of the same type.
* Factory method is used to create random tiles in the CityMap and WildernessMap.
* JavaFX renders the map on a canvas with images corresponding to each tile.
  This design efficiently handles memory and performance when rendering a large RPG map by reusing tile graphics.


In the context of the RPG map generation and rendering system, the Flyweight Pattern is applied to optimize the storage and management of tile graphics (images). Here's an explanation of how and why the Flyweight Pattern is used in this particular case:

What is the Flyweight Pattern?

The Flyweight Pattern is a design pattern used to reduce the number of objects created by sharing common objects. It is particularly useful when you have many objects that have some common state and would otherwise consume a lot of memory. The idea is to separate the intrinsic state (shared) from the extrinsic state (unique to each instance) and store the intrinsic state in a way that can be reused by many instances.

Intrinsic vs Extrinsic State

* Intrinsic State: This is the part of the object that can be shared across all instances because it is immutable. In this case, it's the tile's graphic (image), which is common for all tiles of the same type (e.g., all ForestTiles share the same image).
* Extrinsic State: This is the part of the object that is unique to each instance. For example, the position of the tile on the map (i.e., which row and column it's in) is extrinsic because it varies from tile to tile.
  How Flyweight Is Applied in This Case
1. Tile Graphics (Intrinsic State): In the context of the game, each tile (e.g., ForestTile, RoadTile, BuildingTile) has a graphic associated with it (such as an image like forest.png, road.png, building.png). These graphics are shared across multiple tiles of the same type because all ForestTiles use the same image, all RoadTiles use the same image, and so on. Without Flyweight, each tile would need to hold its own copy of the image, which would consume a lot of memory, especially if the map is large (e.g., a map with 1000 tiles, all using the same forest image would require 1000 copies of the same image). This is inefficient. The Flyweight pattern addresses this by storing the image once and sharing it across all instances of the tile type.
2. Tile Instances (Extrinsic State): The actual position of the tile on the map (e.g., its location at (row 3, col 5)) is extrinsic because it is different for each tile. Each Tile object will hold the position and other attributes specific to the tile, but it doesn't need to hold a separate copy of the image. Instead, it references the shared image from the Flyweight object.
   How the Flyweight Pattern Is Implemented
* TileGraphic Class: This class represents the intrinsic state (the tile graphic, i.e., the image). It's only created once per unique tile description (like "forest", "road", etc.). It ensures that for any given tile type, the image is loaded only once. If a tile of the same type is created again, it uses the same TileGraphic instance.
* TileGraphicFactory Class: This class acts as the Flyweight Factory, managing the shared tile graphics. It keeps a cache (tileGraphics map) of all previously created tile graphics. When a new tile is created, it checks if the graphic for the tile type already exists in the cache. If it does, it returns the existing graphic; otherwise, it creates a new TileGraphic and stores it in the cache. This ensures that no duplicate images are loaded into memory, thus optimizing memory usage. java    public class TileGraphicFactory {
*     private static final Map<String, TileGraphic> tileGraphics = new HashMap<>();
*
*     public static TileGraphic getTileGraphic(String description) {
*         if (!tileGraphics.containsKey(description)) {
*             tileGraphics.put(description, new TileGraphic(description));  // Load and cache the graphic
*         }
*         return tileGraphics.get(description);
*     }}  
* Shared Graphics Usage: The MapRenderer class uses the TileGraphicFactory to retrieve the shared graphic for each tile. For example, if the map contains many ForestTile objects, each ForestTile will use the same TileGraphic (the same image) rather than loading the image multiple times. java KopioiMuokkaa   public class MapRenderer {
*     public static void render(GraphicsContext gc, Map map) {
*         Tile[][] grid = map.getGrid();
*         for (int i = 0; i < grid.length; i++) {
*             for (int j = 0; j < grid[i].length; j++) {
*                 Tile tile = grid[i][j];
*                 TileGraphic graphic = TileGraphicFactory.getTileGraphic(tile.getDescription());
*                 gc.drawImage(graphic.getImage(), j * TILE_SIZE, i * TILE_SIZE);
*             }
*         }
*     }}  
  Why Flyweight Is Important Here
* Memory Efficiency: Without the Flyweight pattern, each tile would hold its own reference to a TileGraphic, resulting in multiple copies of the same image. If you have a large map, this would waste a lot of memory. The Flyweight pattern ensures that only one instance of each unique tile graphic is kept in memory, regardless of how many tiles of that type exist on the map.
* Performance: The Flyweight pattern also improves performance when rendering the map, as the system avoids redundant image loading. It reduces the cost of object creation, especially for large maps with many identical tiles.
* Scalability: As the map grows, this pattern allows you to handle larger maps efficiently. You can have thousands of tiles, and each tile will share the same image for a given type, making it possible to render the map with minimal memory overhead.
  Example
  Imagine you have a map with 1000 tiles. 


Without Flyweight:
* Each tile has its own image reference, so you have 1000 unique image objects in memory (even though many of these images are the same, like "forest.png" or "road.png").
* This leads to a high memory consumption.
  
With Flyweight:
* All ForestTile objects reference the same TileGraphic (the "forest.png" image), so there is only one image object for all ForestTile instances, even if there are thousands of them.
* This significantly reduces memory usage.
  

  The Flyweight Pattern in this situation ensures that the tile images are efficiently shared among all tiles of the same type, reducing memory usage and improving performance. The main idea is to avoid the duplication of graphics by storing them once and reusing them across all instances of a tile type, thus making the application more scalable and efficient, especially for large RPG maps.
