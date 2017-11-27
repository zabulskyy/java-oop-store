import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObservableTest {

    private Observable cart;
    private Observer seller;
    private Observer customer;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
        seller = new Seller();
        customer = new Customer();
    }

    @Test
    public void testAll() throws Exception {
        cart.addObserver(customer).
                addObserver(seller).
                removeObserver(customer).
                notifyObserves();

        cart.addObserver(customer);
        assertEquals(cart, cart.notifyObserves());
    }


}