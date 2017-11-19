import java.util.ArrayList;

public class BonusDecorator extends CartDecorator {
    BonusDecorator(Cart cart) {
        super(cart);
    }

    boolean ship() {
        System.out.println("Bonus is added\n");
        return true;
    }
}
