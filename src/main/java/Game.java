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
        /*Map cityMap = new CityMap(10, 5);

        int cityMapWidth = cityMap.getWidth();
        int cityMapHeight = cityMap.getHeight();

        Canvas canvas = new Canvas(cityMapWidth * TILE_SIZE, cityMapHeight * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        MapRenderer.render(gc, cityMap);*/
        //Scene scene = new Scene(root, cityMapWidth * TILE_SIZE, cityMapHeight * TILE_SIZE);


        Map wildernessMap = new WildernessMap(10, 5);
        int wildernessMapWidth = wildernessMap.getWidth();
        int wildernessMapHeight = wildernessMap.getHeight();
        Canvas canvas = new Canvas(wildernessMapWidth * TILE_SIZE, wildernessMapHeight * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        MapRenderer.render(gc, wildernessMap);

        Pane root = new Pane(canvas);

        Scene scene = new Scene(root, wildernessMapWidth * TILE_SIZE, wildernessMapHeight * TILE_SIZE);

        primaryStage.setTitle("RPG Map - Flyweight");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
