package dad.ventanaconmemoria;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.File;

public class VentanaConMemoria extends Application {

    //model

    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    private DoubleProperty width = new SimpleDoubleProperty();
    private DoubleProperty height = new SimpleDoubleProperty();

    private IntegerProperty red = new SimpleIntegerProperty();
    private IntegerProperty green = new SimpleIntegerProperty();
    private IntegerProperty blue = new SimpleIntegerProperty();

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Iniciando...");

        File profileFolder = new File(System.getProperty("user.home"));
        File configFolder = new File(profileFolder, ".VentanaConMemoria");
        File configFile = new File(configFolder, "config.properties");

        if (configFile.exists()) {

            //cargamos el fichero

            FileInputStream fis = new FileInputStream(configFile);

            Properties properties = new Properties();
            properties.load(fis);

            width.set(Double.parseDouble(properties.getProperty("size.width")));
            height.set(Double.parseDouble(properties.getProperty("size.heigth")));
            x.set(Double.parseDouble(properties.getProperty("size.x")));
            y.set(Double.parseDouble(properties.getProperty("size.y")));
            red.set(Integer.parseInt(properties.getProperty("color.red")));
            green.set(Integer.parseInt(properties.getProperty("color.green")));
            blue.set(Integer.parseInt(properties.getProperty("color.blue")));

        } else {
            width.set(320);
            height.set(200);
            x.set(0);
            y.set(0);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Slider redSlider = new Slider();
        redSlider.setMin(0);
        redSlider.setMax(253);
        redSlider.setShowTickLabels(true);
        redSlider.setShowTickMarks(true);
        redSlider.setMinorTickCount(0);
        redSlider.setMajorTickUnit(255);

        Slider blueSlider = new Slider();
        blueSlider.setMin(0);
        blueSlider.setMax(255);
        blueSlider.setShowTickLabels(true);
        blueSlider.setShowTickMarks(true);
        blueSlider.setMinorTickCount(0);
        blueSlider.setMajorTickUnit(255);

        Slider greenSlider = new Slider();
        greenSlider.setMin(0);
        greenSlider.setMax(255);
        greenSlider.setShowTickLabels(true);
        greenSlider.setShowTickMarks(true);
        greenSlider.setMinorTickCount(0);
        greenSlider.setMajorTickUnit(255);

        Label redLabel = new Label("Red:");
        Label greenLabel = new Label("Green:");
        Label blueLabel = new Label("Blue:");

        HBox redBox = new HBox(10, redLabel, redSlider);

        HBox greenBox = new HBox(10, greenLabel, greenSlider);

        HBox blueBox = new HBox(10, blueLabel, blueSlider);

        VBox root = new VBox();
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(redBox, greenBox, blueBox);
        Color color = Color.rgb(red.get(), green.get(), blue.get());
        root.setBackground(Background.fill(color));

        Scene scene = new Scene(root, width.get(), height.get());

        primaryStage.setX(x.get());
        primaryStage.setY(y.get());
        primaryStage.setTitle("Ventana con memoria");
        primaryStage.setScene(scene);
        primaryStage.show();

        //bindings

        x.bind(primaryStage.xProperty());
        y.bind(primaryStage.yProperty());
        width.bind(primaryStage.widthProperty());
        height.bind(primaryStage.heightProperty());

        redSlider.valueProperty().bindBidirectional(red);
        greenSlider.valueProperty().bindBidirectional(green);
        blueSlider.valueProperty().bindBidirectional(blue);

        red.addListener((o, ov, nv) -> {
            Color c = Color.rgb(red.get(), green.get(), blue.get());
            root.setBackground(Background.fill(c));
        });

        green.addListener((o, ov, nv) -> {
            Color c = Color.rgb(red.get(), green.get(), blue.get());
            root.setBackground(Background.fill(c));
        });

        blue.addListener((o, ov, nv) -> {
            Color c = Color.rgb(red.get(), green.get(), blue.get());
            root.setBackground(Background.fill(c));
        });
    }

    @Override
    public void stop() throws Exception {

        File profileFolder = new File(System.getProperty("user.home"));
        File configFolder = new File(profileFolder, ".VentanaConMemoria");
        File configFile = new File(configFolder, "config.properties");

        if (!configFolder.exists()) {
            configFolder.mkdir();
        }

        System.out.println("Saving config: " + configFile);

        FileOutputStream fos = new FileOutputStream(configFile);

        Properties properties = new Properties();
        properties.setProperty("size.width", "" + width.get());
        properties.setProperty("size.heigth", "" + height.get());
        properties.setProperty("size.x", "" + x.get());
        properties.setProperty("size.y", "" + y.get());
        properties.setProperty("color.red", "" + red.get());
        properties.setProperty("color.green", "" + green.get());
        properties.setProperty("color.blue", "" + blue.get());
        properties.store(fos, "Estado de la ventana");


    }
}
