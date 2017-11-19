import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cart cart = new DiscountDecorator(new Cart());
        cart.paymentStrategy = new Privat24Payment();
        cart.deliveryStrategy = new DelieveryDHL();
        ComputerStore cs = new ComputerStore();
        ArrayList<String> genres = new ArrayList<>();
        genres.add("MOBA");
        genres.add("third-person");

        ArrayList<String> platforms = new ArrayList<>();
        platforms.add("PC");
        platforms.add("Mac");

        cs.addGame("Dota2", "TI 2020 got one billion $ prize", genres, 4f, 14, platforms);
        cs.addGame("League of Legends", "Best MOBA ever", genres, 10f, 12, platforms);

        cart.deliveryStrategy.deliever(cs.getGames());
        cart.addGamesToCart(cs.getGames());
        cart.paymentStrategy.pay(cart.computeTotalPrice());

    }
}
