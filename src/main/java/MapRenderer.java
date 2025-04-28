import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MapRenderer {

    public static void render(GraphicsContext gc, Map map) {
        Tile[][] grid = map.getGrid();
        int height = map.getHeight();
        int width = map.getWidth();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = grid[i][j];
                TileGraphic graphic = TileGraphicFactory.getTileGraphic(tile.getDescription());
                gc.drawImage(graphic.getImage(), j * 32, i * 32, 32, 32);
            }
        }
    }
}
