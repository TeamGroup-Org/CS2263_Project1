package CS2263_Project1;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Hellwig
 */
public class DataManager {

    @Getter
    @Setter
    private Player playerData;

    @Getter
    @Setter
    private Board boardData;

    @Getter
    @Setter
    private TileTray trayData;

    /**
     *
     * @param p Player
     * @param b Board
     * @param t TileTray
     *          Writes out broad range of data to three files
     */
    public void Write(Player p, Board b, TileTray t){
        FileWriter writer = null;
        try {
            FileWriter writerP = new FileWriter("player.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(p,writerP);
            writerP.flush();
            writerP.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writerB = new FileWriter("board.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(p,writerB);
            writerB.flush();
            writerB.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writerT = new FileWriter("player.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(p,writerT);
            writerT.flush();
            writerT.close();
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

        Type trayInfo = new TypeToken<TileTray>() {}.getType();

        JsonReader playerReader = new JsonReader(new FileReader("player.json"));

        JsonReader boardReader = new JsonReader(new FileReader("board.json"));

        JsonReader trayReader = new JsonReader(new FileReader("tray.json"));

        Gson gson = new Gson();
        playerData = gson.fromJson(playerReader, playerInfo);

        Gson gsonTwo = new Gson();
        boardData = gson.fromJson(boardReader, BoardInfo);

        Gson gsonThree = new Gson();
        trayData = gson.fromJson(trayReader, trayInfo);



    }
}
