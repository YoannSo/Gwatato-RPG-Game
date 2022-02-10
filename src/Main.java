

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        primaryStage.setTitle("Gwatato");
        primaryStage.setScene(new Scene(root, 1500, 900));
        primaryStage.setMinHeight(720);
        primaryStage.setMinWidth(1280);
        primaryStage.setMaxHeight(1080);
        primaryStage.setMaxWidth(1920);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
