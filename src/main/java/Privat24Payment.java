public class Privat24Payment implements PaymentStrategy {
    @Override
    public boolean pay(double price) {
        System.out.println(price + " payed with Privat24 successfully\n");
        return true;
    }
}
