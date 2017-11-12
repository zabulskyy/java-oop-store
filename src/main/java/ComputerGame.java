import java.util.ArrayList;

public class ComputerGame {

    private int id;
    private ComputerGameParams properties;

    public ComputerGame(
            String name,
            String description,
            ArrayList<String> genres,
            Float price,
            Integer ageRestriction,
            ArrayList<String> platforms,
            Integer id) {

        this.id = id;
        this.properties = new ComputerGameParams(name, description, genres, price, ageRestriction, platforms);

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
