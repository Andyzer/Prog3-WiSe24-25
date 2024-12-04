import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class FXGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root =
          FXMLLoader.load(getClass().getResource("FXGUI.fxml"));

        primaryStage.setTitle("Cargo Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
