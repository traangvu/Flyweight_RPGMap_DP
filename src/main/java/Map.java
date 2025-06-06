import java.util.Random;

public abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] grid;
    protected Random random = new Random();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Tile[height][width];
        generateMap();
    }

    abstract Tile createTile();

    private void generateMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = createTile();
            }
        }
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
