import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MapRenderer {
    private static final int TILE_SIZE = 32;

    public static void render(GraphicsContext gc, Map map) {
        Tile[][] grid = map.getGrid();
        int height = map.getHeight();
        int width = map.getWidth();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = grid[i][j];
                Image tileImage = TileGraphicFactory.getTileImage(tile.getDescription());
                gc.drawImage(tileImage, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
