package CS2263_Project1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;

/**
 * Menu Controller Class contains all methods used as part of the Main Menu UI stage
 *
 * @author Coby Garner
 *
 * @version v1.1.0
 */

@Log4j2
public class MenuController {

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
     * Starts a new game and then sets the players and board up
     */

    public void loadGame(){
        App.stage1.show();
        App.stage.close();

        App.setLoadFlag(true);
        log.debug("Load Game Flag: " + App.loadFlag);
    }
}

