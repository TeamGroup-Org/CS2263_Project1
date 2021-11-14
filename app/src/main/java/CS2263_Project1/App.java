package CS2263_Project1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application{
    public App(){}

    public Pane makeGameBoard() {
        char[] charArray = new char[] {'A','B','C','D','E','F','G','H','I'};
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(true);
        for (int i = 1; i<13; i++){
            for (int j = 0; j< 9; j++) {
                Button tile = new Button();
                tile.setText(String.valueOf(i) + charArray[j]);
                tile.setPrefWidth(40);
                pane.add(tile,i,j);
            }
        }
        return pane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setMaxWidth(500); primaryStage.setMaxHeight(500);
        primaryStage.setTitle("Acquire");


        //Buttons
        Button startButton = new Button(); startButton.setWrapText(true);
        Button loadButton = new Button(); loadButton.setWrapText(true);
        Button quitButton = new Button(); quitButton.setWrapText(true);

        startButton.setText("New Game");
        loadButton.setText("Load Game");
        quitButton.setText("Exit to desktop");

        Label label = new Label("Acquire");label.setFont(Font.font(40));
        Pane pane = new Pane(label, startButton, loadButton, quitButton);
        Scene scene1 = new Scene(pane, 500, 500);

        label.setLayoutY(120);label.setLayoutX(175);
        startButton.setLayoutX(150); startButton.setLayoutY(200);
        loadButton.setLayoutX(225); loadButton.setLayoutY(200);
        quitButton.setLayoutX(175); quitButton.setLayoutY(225);

        primaryStage.setScene(scene1);
        primaryStage.show();

        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                Stage acquireStage = new Stage();
                acquireStage.setTitle("Acquire");
                Scene scene2 = new Scene(makeGameBoard(), 450, 300);
                acquireStage.setScene(scene2);
                acquireStage.show();
            }
        });

    }
    public static void main(String[] args) {
        App.launch(args);


    }
}


