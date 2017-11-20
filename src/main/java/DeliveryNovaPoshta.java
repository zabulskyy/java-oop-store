import java.util.ArrayList;

public class DeliveryNovaPoshta implements DeliveryStrategy {
    public boolean deliver(ArrayList<ComputerGame> games) {
        for (ComputerGame game :
                games) {
            System.out.println(game + " delivered with Nova Poshta successful");
        }
        return true;
    }
}
