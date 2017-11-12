import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComputerGameParamsTest {

    private ComputerGameParams cgp;
    private ComputerGameParams cgp2;
    private String name;
    private String description;
    private ArrayList<String> genres;
    private Float price;
    private Integer ageRestriction;
    private ArrayList<String> platforms;

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

        cgp = new ComputerGameParams(name, description, genres, price, ageRestriction, platforms);
        cgp2 = cgp;
    }

    @Test
    public void getTags() throws Exception {
        ArrayList<String> result = new ArrayList<>();
        result.add("Half-life 1");
        result.add("shooter");
        result.add("action");
        result.add("horror");
        result.add("PC");
        result.add("SteamOS");

        assertEquals(result, cgp.getTags());
    }

    @Test
    public void hasTag() throws Exception {
        assertEquals(true, cgp.hasTag("PC"));
        assertEquals(false, cgp.hasTag("Minecraft"));

    }

    @Test
    public void getName() throws Exception {
        assertEquals(name, cgp.getName());
    }

    @Test
    public void setName() throws Exception {
        String newName = "Half-life 2";
        assertEquals(newName, cgp.setName(newName).getName());

        cgp2.setName(newName);
        assertEquals(cgp2, cgp.setName(newName));
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(description, cgp.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        String newDescription = "worst game ever";
        assertEquals(newDescription, cgp.setDescription(newDescription).getDescription());

        cgp2.setDescription(newDescription);
        assertEquals(cgp2, cgp.setDescription(newDescription));
    }

    @Test
    public void getGenres() throws Exception {
        assertEquals(genres, cgp.getGenres());
    }

    @Test
    public void setGenres() throws Exception {
        ArrayList<String> newGenres = new ArrayList<>();
        newGenres.add("fighting");
        newGenres.add("solo-game");
        newGenres.add("shooter");
        assertEquals(newGenres, cgp.setGenres(newGenres).getGenres());

        cgp2.setGenres(newGenres);
        assertEquals(cgp2, cgp.setGenres(newGenres));
    }

    @Test
    public void getPrice() throws Exception {
        assertEquals(price, cgp.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        Float newPrice = 100500f;
        assertEquals(newPrice, cgp.setPrice(newPrice).getPrice());

        cgp2.setPrice(newPrice);
        assertEquals(cgp2, cgp.setPrice(newPrice));
    }

    @Test
    public void getAgeRestriction() throws Exception {
        assertEquals(ageRestriction, cgp.getAgeRestriction());
    }

    @Test
    public void setAgeRestriction() throws Exception {
        Integer newAgeRestriction = 90;
        assertEquals(newAgeRestriction, cgp.setAgeRestriction(newAgeRestriction).getAgeRestriction());

        cgp2.setAgeRestriction(newAgeRestriction);
        assertEquals(cgp2, cgp.setAgeRestriction(newAgeRestriction));

    }

    @Test
    public void getPlatforms() throws Exception {
        assertEquals(platforms, cgp.getPlatforms());
    }

    @Test
    public void setPlatforms() throws Exception {
        ArrayList<String> newPlatforms = new ArrayList<>();
        newPlatforms.add("XBox");
        newPlatforms.add("PS4");
        newPlatforms.add("PS3");
        assertEquals(newPlatforms, cgp.setPlatforms(newPlatforms).getPlatforms());

        cgp2.setPlatforms(newPlatforms);
        assertEquals(cgp2, cgp.setPlatforms(newPlatforms));
    }

}