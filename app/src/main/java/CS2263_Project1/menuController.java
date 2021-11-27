package CS2263_Project1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Menu Controller Class contains all methods used as part of the Main Menu UI stage
 *
 * @author Coby Garner
 */

public class menuController {

    @FXML
    private Button quitButton;
    @FXML
    private Button newGameButton;
    @FXML
    private Button loadGameButton;

    /**
     *  Causes the stage to close
     */

    public void quitGame(){
        App.stage.close();
    }

    /**
     *  Closes the menu stage and starts a new game
     */

    public void newGame(){
        App.stage1.show();
        App.stage.close();
    }

    /**
     *
     */

    public void loadGame(){

    }
}

