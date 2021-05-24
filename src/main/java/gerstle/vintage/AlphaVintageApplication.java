package gerstle.vintage;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class AlphaVintageApplication extends Application
{
    @FXML
    LineChart chart;
    @Override
    public void start(Stage stage) throws Exception {

        AlphaVintageService service = new AlphaVintageServiceFactory().newInstance();
        AlphaVintageController controller = new AlphaVintageController(service);
        AlphaVintageFeed feed = new AlphaVintageFeed();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AlphaVintage.fxml"));
        loader.setController(controller);


        Parent parent = loader.load();
        Scene scene = new Scene(parent, 800,600);



        stage.setTitle("Stocks");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
