import java.util.ArrayList;

public class DeliveryDHL implements DeliveryStrategy{

    public boolean deliver(ArrayList<ComputerGame> games) {
        for (ComputerGame game : games) {
            System.out.println(game + " delivered with DHL successful");
        }
        return true;
    }

}
