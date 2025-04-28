import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, TileGraphic> tileGraphics = new HashMap<>();

    public static TileGraphic getTileGraphic(String description) {
        if (!tileGraphics.containsKey(description)) {
            tileGraphics.put(description, new TileGraphic(description));
        }
        return tileGraphics.get(description);
    }
}