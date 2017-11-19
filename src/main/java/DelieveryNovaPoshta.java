import java.util.ArrayList;

public class DelieveryNovaPoshta implements DeliveryStrategy {
    @Override
    public boolean deliever(ArrayList<ComputerGame> games) {
        for (ComputerGame game :
                games) {
            System.out.println(game + " delivered with Nova Poshta successful");
        }
        return true;
    }
}
