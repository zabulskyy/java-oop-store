import java.util.ArrayList;

public class ComputerGame {

    private int id;
    private ComputerGameParams properties;

    ComputerGame(){
        this.properties = new ComputerGameParams();
    }

    @Override
    public String toString() {
        return this.properties.getName();
    }

    public ComputerGameParams getProperties() {
        return properties;
    }

    public int getId() {
        return id;
    }

    public ComputerGame setId(int id) {
        this.id = id;
        return this;
    }
}
