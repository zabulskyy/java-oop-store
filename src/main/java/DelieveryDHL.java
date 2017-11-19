import java.util.ArrayList;

public class DelieveryDHL implements DeliveryStrategy {
    @Override
    public boolean deliever(ArrayList<ComputerGame> games) {
        for (ComputerGame game :
                games) {
            System.out.println(game + " delivered with DHL successful");
        }
        return true;
    }
}
