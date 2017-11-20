import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cart cart = new DiscountDecorator(new Cart());
        cart.setPaymentStrategy(new Privat24Payment());
        cart.setDeliveryStrategy(new DeliveryDHL());
        ComputerStore cs = new ComputerStore();
        ArrayList<String> genres = new ArrayList<>();
        genres.add("MOBA");
        genres.add("third-person");

        ArrayList<String> platforms = new ArrayList<>();
        platforms.add("PC");
        platforms.add("Mac");

        cs.addGame("Dota2", "TI 2020 got one billion $ prize", genres, 4f, 14, platforms);
        cs.addGame("League of Legends", "Best MOBA ever", genres, 10f, 12, platforms);

        cart.getDeliveryStrategy().deliver(cs.getGames());
        cart.addGames(cs.searchById(1), cs.searchById(2));
        double price = cart.computeTotalPrice();
        cart.getPaymentStrategy().pay(price);

    }
}
