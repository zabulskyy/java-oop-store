import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComputerGameTest {

    ComputerGame game;

    @Before
    public void setUp() throws Exception {

        String name = "Half-life 1";
        String description = "1st part is awesome. 2nd is awesome as well. 3rd is..";
        ArrayList<String> genres = new ArrayList<>();
        genres.add("shooter");
        genres.add("action");
        genres.add("horror");
        Float price = 30.0f;
        Integer ageRestriction = 16;
        ArrayList<String> platforms = new ArrayList<>();
        platforms.add("PC");
        platforms.add("SteamOS");
        int id = 43;

        game = new ComputerGame(name, description, genres, price, ageRestriction, platforms, id);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getProperties() throws Exception {
    }

    @Test
    public void getId() throws Exception {
        assertEquals(game.getId(), 43);
    }

    @Test
    public void setId() throws Exception {
        game.setId(10);
        assertEquals(game.getId(), 10);
    }

}