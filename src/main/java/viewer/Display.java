package viewer;

import image.Image;
import image.ImageFactory;
import image.RasterImageType;
import image.RasterUniformImageFactory;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class Display implements Initializable {
    @javafx.fxml.FXML
    @FXML
    private Canvas canvas;

    private Image image;
    private ImageFactory imageFactory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // TODO : rajouter la création d'une fabrique d'image pour initialiser imageFactory
        imageFactory = new RasterUniformImageFactory(200,
                200, Color.RED, RasterImageType.BRUTE);
        this.image = imageFactory.makeImage();

        render();
    }

    private void render() {
        int pixelWidth = image.getWidth();
        int pixelHeight = image.getHeight();

        canvas.setWidth(pixelWidth);
        canvas.setHeight(pixelHeight);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int i = 0; i < pixelWidth; i++) {
            for (int j = 0; j < pixelHeight; j++) {
                renderPixel(i, j, pixelWriter);
            }
        }
    }

    private void renderPixel(int x, int y, PixelWriter pixelWriter) {
        pixelWriter.setColor(x, y, image.getPixelColor(x, y));
    }

    @Override
    public void initialize() throws InitializationException {

    }
}
