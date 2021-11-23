package CS2263_Project1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * App class launches the Application UI
 *
 * @author David Hellwig
 * @uathor Coby Garner
 *
 * @version 1.0.0
 */

public class App extends Application {
    public static Stage stage = new Stage();
    public static Stage stage1 = new Stage();

    public App() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("/menu.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        FXMLLoader loader1 = new FXMLLoader((getClass().getResource("/gameBoard.fxml")));
        Parent root1 = loader1.load();
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
    }

        public static void main (String[] args){
            App.launch();
    }
}


