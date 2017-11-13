import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComputerStoreTest {


    ComputerStore store;

    String name1, name2, name3;
    String description1, description2, description3;
    ArrayList<String> genres1, genres2, genres3;
    Float price1, price2, price3;
    Integer ageRestriction1, ageRestriction2, ageRestriction3;
    ArrayList<String> platforms1, platforms2, platforms3;
    ArrayList<ComputerGame> allGames;

    ComputerGame game1;
    ComputerGame game2;
    ComputerGame game3;

    @Before
    public void setUp() throws Exception {
        store = new ComputerStore();


        name1 = "Half-life 1";
        name2 = "TESV:Skyrim";
        name3 = "Dota2";

        description1 = "1st part is awesome. 2nd is awesome as well. 3rd is..";
        description2 = "this game is legend";
        description3 = "forget about your private life";

        genres1 = new ArrayList<>();
        genres1.add("shooter");
        genres1.add("action");
        genres1.add("horror");
        genres1.add("first-person");

        genres2 = new ArrayList<>();
        genres2.add("first-person");
        genres2.add("action");

        genres3 = new ArrayList<>();
        genres3.add("MOBA");
        genres3.add("online");
        genres3.add("third-person");

        price1 = 19.0f;
        price2 = 30.0f;
        price3 = 0.0f;


        ageRestriction1 = 16;
        ageRestriction2 = 18;
        ageRestriction3 = 14;

        platforms1 = new ArrayList<>();
        platforms1.add("PC");
        platforms1.add("SteamOS");

        platforms2 = new ArrayList<>();
        platforms2.add("PC");
        platforms2.add("XBox");
        platforms2.add("PS4");
        platforms2.add("PS3");

        platforms3 = new ArrayList<>();
        platforms3.add("PC");

        assertEquals(0, store.getLargestId());
        assertEquals(0, store.getGamesAmount());

        assertEquals(new ArrayList<ComputerGame>(), store.getGames());

        game1 = new ComputerGame(name1, description1, genres1, price1, ageRestriction1, platforms2, 1);
        game2 = new ComputerGame(name2, description2, genres2, price2, ageRestriction2, platforms2, 2);
        game3 = new ComputerGame(name3, description3, genres3, price3, ageRestriction3, platforms3, 3);

        allGames = new ArrayList<>();
        allGames.add(game1);
        allGames.add(game2);
        allGames.add(game3);


    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void searchById() throws Exception {
        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        assertEquals(store.searchById(1).getProperties().getName(), game1.getProperties().getName());
        assertEquals(store.searchById(20), null);
    }

    @Test
    public void tagsMatches() throws Exception {
        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        assertEquals(3, store.tagsMatches(1, "PC", "Minecraft", "shooter", "horror", "abracadabra", "Digger Online"));
        assertEquals(0, store.tagsMatches(20, "PC", "Minecraft", "shooter", "horror", "abracadabra", "Digger Online"));

    }

    @Test
    public void addGame() throws Exception {
        assertEquals(0, store.getGamesAmount());
        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        assertEquals(3, store.getGamesAmount());
    }

    @Test
    public void getLargestId() throws Exception {
        assertEquals(0, store.getLargestId());

        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        assertEquals(1, store.getLargestId());

        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        assertEquals(2, store.getLargestId());

        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        assertEquals(3, store.getLargestId());

        store.removeGame(1);
        assertEquals(3, store.getLargestId());

    }

    @Test
    public void getGamesAmount() throws Exception {
        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        assertEquals(3, store.getGamesAmount());
        store.removeGame(1);
        assertEquals(2, store.getGamesAmount());
        store.removeGame(2);
        assertEquals(1, store.getGamesAmount());
        store.removeGame(3);
        assertEquals(0, store.getGamesAmount());
    }

    @Test
    public void getGames() throws Exception {
        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);

        ArrayList<String> gameNamesInStore = new ArrayList<>();
        ArrayList<String> gameNamesInTest = new ArrayList<>();

        for (ComputerGame game :
                store.getGames()) {
            gameNamesInStore.add(game.getProperties().getName());
        }
        for (ComputerGame game :
                allGames) {
            gameNamesInTest.add(game.getProperties().getName());
        }


        assertEquals(gameNamesInStore, gameNamesInStore);
    }

    @Test
    public void searchByTags() throws Exception {

        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        ArrayList<ComputerGame> result = new ArrayList<>();

        result.add(game1);
        assertEquals(store.searchByTags("Half-life 1", "shooter").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        result.add(game2);
        assertEquals(store.searchByTags("action", "PC").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        assertEquals(store.searchByTags("action", "PC").get(1).getProperties().getName(), result.get(1).getProperties().getName());
        result = new ArrayList<>();
        result.add(game2);
        assertEquals(store.searchByTags("XBox", "TESV:Skyrim").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        result = new ArrayList<>();
        assertEquals(store.searchByTags("Super Mario", "MMORPG"), result);
        result.add(game3);
        assertEquals(store.searchByTags("some", "random", "tags", "Dota2").get(0).getProperties().getName(), result.get(0).getProperties().getName());


    }

    @Test
    public void searchByTag() throws Exception {

        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        ArrayList<ComputerGame> result = new ArrayList<>();

        result.add(game1);
        assertEquals(store.searchByTag("Half-life 1").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        result.add(game2);
        assertEquals(store.searchByTag("action").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        assertEquals(store.searchByTag("action").get(1).getProperties().getName(), result.get(1).getProperties().getName());
        result = new ArrayList<>();
        result.add(game2);
        assertEquals(store.searchByTag("XBox").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        result = new ArrayList<>();
        assertEquals(store.searchByTag("Super Mario"), result);
        result.add(game3);
        assertEquals(store.searchByTags("Dota2").get(0).getProperties().getName(), result.get(0).getProperties().getName());

    }

    @Test
    public void searchByName() throws Exception {

        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        ArrayList<ComputerGame> result = new ArrayList<>();

        result.add(game1);
        assertEquals(store.searchByName("Half-life 1").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        result.add(game3);
        assertEquals(store.searchByName("Half-life 1").get(0).getProperties().getName(), result.get(0).getProperties().getName());
        assertEquals(store.searchByName("Dota2").get(0).getProperties().getName(), result.get(1).getProperties().getName());
        result = new ArrayList<>();
        assertEquals(store.searchByTag("Super Mario"), result);

    }

    @Test
    public void removeGame() throws Exception {

        store.addGame(name1, description1, genres1, price1, ageRestriction1, platforms1);
        store.addGame(name2, description2, genres2, price2, ageRestriction2, platforms2);
        store.addGame(name3, description3, genres3, price3, ageRestriction3, platforms3);
        ArrayList<ComputerGame> result = new ArrayList<>();

        assertEquals(store.getGamesAmount(), 3);
        store.removeGame(1);
        assertEquals(store.getGamesAmount(), 2);
        store.removeGame(2);
        assertEquals(store.getGamesAmount(), 1);
        store.removeGame(3);
        assertEquals(store.getGamesAmount(), 0);
    }

}