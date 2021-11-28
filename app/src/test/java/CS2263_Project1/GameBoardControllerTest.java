package CS2263_Project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardControllerTest {
    static Board gameBoard = new Board();
    private int playerTurn = 1;
    private static Player player1;
    private static Player player2;

    @BeforeEach
    public void setUp() {
        player1 = new Player(1,4000, gameBoard.generatePlayerHand(), new ArrayList<>());
        player2 = new Player(1,4000, gameBoard.generatePlayerHand(), new ArrayList<>());
    }

//    @Test
//    public void testUpdateBoard() {
//
//    }

//    @Test
//    public void testPlayTile() {
//
//    }

//    @Test
//    public void testUpdateMoney() {
//        player1.takeMoney(100);
//        player2.spendMoney(200);
//
//        assertTrue(player1.getPlayerInfo() > player2.getPlayerInfo());
//    }
}
