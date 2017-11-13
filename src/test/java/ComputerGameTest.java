import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComputerGameTest {


    ComputerGame game;
    String name;
    String description;
    ArrayList<String> genres;
    Float price;
    Integer ageRestriction;
    ArrayList<String> platforms;
    int id;

    @Before
    public void setUp() throws Exception {

        name = "Half-life 1";
        description = "1st part is awesome. 2nd is awesome as well. 3rd is..";
        genres = new ArrayList<>();
        genres.add("shooter");
        genres.add("action");
        genres.add("horror");
        price = 30.0f;
        ageRestriction = 16;
        platforms = new ArrayList<>();
        platforms.add("PC");
        platforms.add("SteamOS");
        id = 43;

        game = new ComputerGame(name, description, genres, price, ageRestriction, platforms, id);

    }


    @Test
    public void getProperties() throws Exception {
        ComputerGameParams cgp = new ComputerGameParams(name, description, genres, price, ageRestriction, platforms);
        assertEquals(cgp.getTags(), game.getProperties().getTags());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(game.toString(), "Half-life 1");
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