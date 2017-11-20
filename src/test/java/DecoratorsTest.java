import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DecoratorsTest {


    private Cart cashCart = new Cart();
    private Cart privat24Cart = new Cart();

    private Cart NPCart = new Cart();
    private Cart DHLCart = new Cart();

    @Test
    public void testBonuses() throws Exception {
        Cart bonusCart = new BonusDecorator(new Cart());
        assertEquals(true, bonusCart.ship());

        Cart discountCart = new DiscountDecorator(new Cart() {
            @Override
            double computeTotalPrice() {
                return 100d;
            }
        });

        assertEquals(80f, discountCart.computeTotalPrice(), 0.01);

    }

    public void testPayment() throws Exception {
        cashCart.setPaymentStrategy(new CashPayment());
        privat24Cart.setPaymentStrategy(new Privat24Payment());

        assertEquals(true, cashCart.getPaymentStrategy().pay(10f));
        assertEquals(true, privat24Cart.getPaymentStrategy().pay(10f));

        CashPayment cp = new CashPayment();
        Privat24Payment pp = new Privat24Payment();

        assertEquals(true, cp.pay(1f));
        assertEquals(true, pp.pay(1f));

    }

    public void testDelivery() throws Exception{
        NPCart.setDeliveryStrategy(new DeliveryNovaPoshta());
        DHLCart.setDeliveryStrategy(new DeliveryDHL());

        ComputerGame game = new ComputerGame();
        ArrayList<ComputerGame> games = new ArrayList<>();
        games.add(game);

        assertEquals(true, NPCart.getDeliveryStrategy().deliver(games));
        assertEquals(true, DHLCart.getDeliveryStrategy().deliver(games));


    }

        @Test
    public void testMain() throws Exception{
        Main m = new Main();
        m.main(new String[0]);
    }

}
