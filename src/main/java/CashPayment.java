public class CashPayment implements PaymentStrategy{
    @Override
    public boolean pay(double price) {
        System.out.println(price + " payed with cash successfully\n");
        return true;
    }
}
