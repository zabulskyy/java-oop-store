import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CartTest {

    Cart cart = new Cart();
    Cart cart1 = cart;
    Cart cart2 = cart;


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

        game1 = new ComputerGame();
        game2 = new ComputerGame();
        game3 = new ComputerGame();
        game1.setId(1)
                .getProperties()
                .setName(name1)
                .setDescription(description1)
                .setPlatforms(platforms1)
                .setAgeRestriction(ageRestriction1)
                .setGenres(genres1)
                .setPrice(price1);
        game2.setId(2)
                .getProperties()
                .setName(name2)
                .setDescription(description2)
                .setPlatforms(platforms2)
                .setAgeRestriction(ageRestriction2)
                .setGenres(genres2)
                .setPrice(price2);
        game3.setId(3)
                .getProperties()
                .setName(name3)
                .setDescription(description3)
                .setPlatforms(platforms3)
                .setAgeRestriction(ageRestriction3)
                .setGenres(genres3)
                .setPrice(price3);

        allGames = new ArrayList<>();
        allGames.add(game1);
        allGames.add(game2);
        allGames.add(game3);

        cart.addGames(game1, game2, game3);

    }

    @Test
    public void ship() throws Exception {
        assertEquals(true, cart.ship());
    }

    @Test
    public void computeTotalPrice() throws Exception {
        assertEquals(price1 + price2 + price3, cart.computeTotalPrice(), 0.01);
    }

    @Test
    public void getSetPaymentStrategy() throws Exception {
        cart1.setPaymentStrategy(new Privat24Payment());
        assertEquals(cart1, cart.setPaymentStrategy(new Privat24Payment()));
        assertEquals(Privat24Payment.class, cart.getPaymentStrategy().getClass());

        cart2.setPaymentStrategy(new CashPayment());
        assertEquals(cart1, cart.setPaymentStrategy(new CashPayment()));
        assertEquals(CashPayment.class, cart.getPaymentStrategy().getClass());
    }


    @Test
    public void getDeliveryStrategy() throws Exception {

        cart1.setDeliveryStrategy(new DelieveryNovaPoshta());
        assertEquals(cart1, cart.setDeliveryStrategy(new DelieveryNovaPoshta()));
        assertEquals(DelieveryNovaPoshta.class, cart.getDeliveryStrategy().getClass());

        cart2.setDeliveryStrategy(new DelieveryDHL());
        assertEquals(cart1, cart.setDeliveryStrategy(new DelieveryDHL()));
        assertEquals(DelieveryDHL.class, cart.getDeliveryStrategy().getClass());
    }


    @Test
    public void addGames() throws Exception {
        assertEquals(cart, cart1.addGames(game1, game2, game3));
    }

}