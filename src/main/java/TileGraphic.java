import javafx.scene.image.Image;

public class TileGraphic {
    private final Image image;

    public TileGraphic(String description) {
        String path = "/images/" + description + ".png";
        this.image = new Image(TileGraphic.class.getResourceAsStream(path));
    }

    public Image getImage() {
        return image;
    }
}
