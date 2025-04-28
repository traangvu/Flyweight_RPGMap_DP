import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, Image> tileImages = new HashMap<>();

    public static Image getTileImage(String description) {
        if (!tileImages.containsKey(description)) {
            tileImages.put(description, loadImageForDescription(description));
        }
        return tileImages.get(description);
    }

    private static Image loadImageForDescription(String description) {
        // Assuming images are in /resources/images/ directory
        String path = "/images/" + description + ".png";
        return new Image(TileGraphicFactory.class.getResourceAsStream(path));
    }
}
