package CS2263_Project1;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.lang.reflect.Type;

/**
 * @author David Hellwig
 * @author Ekow Barlow
 *
 * @version v1.1.0
 */
public class DataManager {

    @Getter
    @Setter
    private Player playerData;

    @Getter
    @Setter
    private Player playerData2;

    @Getter
    @Setter
    private Board boardData;


    /**
     *
     * @param p1 Player
     * @param b Board
     //* @param t TileTray
     *          Writes out broad range of data to three files
     */
    public void Write(Player p1, Player p2, Board b){
        FileWriter writer = null;
        try {
            truncate(new File("player1.json"));
            FileWriter writerP = new FileWriter("player1.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(p1,writerP);
            writerP.flush();
            writerP.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            truncate(new File("player2.json"));
            FileWriter writerP2 = new FileWriter("player2.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(p2,writerP2);
            writerP2.flush();
            writerP2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            truncate(new File("board.json"));
            FileWriter writerB = new FileWriter("board.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(b,writerB);
            writerB.flush();
            writerB.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * @throws FileNotFoundException file not found
     *      Reads data from three files and sets private variables to the data in the files
     */
    public void Read() throws FileNotFoundException {
        Type playerInfo = new TypeToken<Player>() {}.getType();

        Type BoardInfo = new TypeToken<Board>() {}.getType();


        JsonReader playerReader = new JsonReader(new FileReader("player1.json"));

        JsonReader playerReader2 = new JsonReader(new FileReader("player2.json"));

        JsonReader boardReader = new JsonReader(new FileReader("board.json"));


        Gson gson = new Gson();
        playerData = gson.fromJson(playerReader, playerInfo);

        Gson gsonS = new Gson();
        playerData2 = gson.fromJson(playerReader, playerInfo);

        Gson gsonTwo = new Gson();
        boardData = gson.fromJson(boardReader, BoardInfo);


    }

    /**
     *  Truncates a file
     * @param file file
     * @throws IOException throws exception when file doesn't exist
     */
    public void truncate(File file) throws IOException {
        FileWriter truncater = new FileWriter(file, false);
        truncater.flush();
    }
}
