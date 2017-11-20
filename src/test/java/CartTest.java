import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CartTest {

    private Cart cart = new Cart();
    private Cart cart1 = cart;
    private Cart cart2 = cart;


    ComputerStore store;

    private Float price1, price2, price3;

    private ComputerGame game1;
    private ComputerGame game2;
    private ComputerGame game3;

    @Before
    public void setUp() throws Exception {


        String name1 = "Half-life 1";
        String name2 = "TESV:Skyrim";
        String name3 = "Dota2";

        String description1 = "1st part is awesome. 2nd is awesome as well. 3rd is..";
        String description2 = "this game is legend";
        String description3 = "forget about your private life";

        ArrayList<String> genres1 = new ArrayList<>();
        genres1.add("shooter");
        genres1.add("action");
        genres1.add("horror");
        genres1.add("first-person");

        ArrayList<String> genres2 = new ArrayList<>();
        genres2.add("first-person");
        genres2.add("action");

        ArrayList<String> genres3 = new ArrayList<>();
        genres3.add("MOBA");
        genres3.add("online");
        genres3.add("third-person");

        price1 = 19.0f;
        price2 = 30.0f;
        price3 = 0.0f;


        Integer ageRestriction1 = 16;
        Integer ageRestriction2 = 18;
        Integer ageRestriction3 = 14;

        ArrayList<String> platforms1 = new ArrayList<>();
        platforms1.add("PC");
        platforms1.add("SteamOS");

        ArrayList<String> platforms2 = new ArrayList<>();
        platforms2.add("PC");
        platforms2.add("XBox");
        platforms2.add("PS4");
        platforms2.add("PS3");

        ArrayList<String> platforms3 = new ArrayList<>();
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

        ArrayList<ComputerGame> allGames = new ArrayList<>();
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

        cart1.setDeliveryStrategy(new DeliveryNovaPoshta());
        assertEquals(cart1, cart.setDeliveryStrategy(new DeliveryNovaPoshta()));
        assertEquals(DeliveryNovaPoshta.class, cart.getDeliveryStrategy().getClass());

        cart2.setDeliveryStrategy(new DeliveryDHL());
        assertEquals(cart1, cart.setDeliveryStrategy(new DeliveryDHL()));
        assertEquals(DeliveryDHL.class, cart.getDeliveryStrategy().getClass());
    }


    @Test
    public void addGames() throws Exception {
        assertEquals(cart, cart1.addGames(game1, game2, game3));
    }

}