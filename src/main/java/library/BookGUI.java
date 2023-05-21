package library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class BookGUI extends Application {
    @Override
    public void start(Stage bookStage) throws Exception {
        FXMLLoader loader1 = new FXMLLoader();
        URL xmlUrl1 = getClass().getResource("secondary.fxml");
        loader1.setLocation(xmlUrl1);
        Parent root1 = loader1.load();
        loader1.setController(new SecondaryController());
        bookStage.setTitle("Библиотека");
        bookStage.setScene(new Scene(root1));
        bookStage.show();
    }
}
