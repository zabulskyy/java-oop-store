public class BonusDecorator extends CartDecorator {
    BonusDecorator(Cart cart) {
        super(cart);
    }

    @Override
    boolean ship() {
        System.out.println("Bonus is added\n");
        return true;
    }
}
