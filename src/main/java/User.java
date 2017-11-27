abstract public class User implements Observer {

    @Override
    abstract public String toString();

    public void update() {
        System.out.println("User " + this + " was updated");
    }
}
