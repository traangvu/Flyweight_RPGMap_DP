import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int TILE_SIZE = 32;

    @Override
    public void start(Stage primaryStage) {
        Map cityMap = new CityMap(10, 5);
        Map wildernessMap = new WildernessMap(10, 5);

        int mapWidth = cityMap.getWidth();
        int mapHeight = cityMap.getHeight();

        Canvas canvas = new Canvas(mapWidth * TILE_SIZE, mapHeight * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        MapRenderer.render(gc, cityMap);

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);

        primaryStage.setTitle("RPG Map - Flyweight Rendering");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
