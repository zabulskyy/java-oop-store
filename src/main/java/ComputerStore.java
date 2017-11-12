import java.util.ArrayList;

public class ComputerStore {

    private int id;
    private ArrayList<ComputerGame> storeContainer;

    ComputerStore() {
        storeContainer = new ArrayList<>();
        this.id = 0;
    }

    public ComputerStore addGame(
            String name,
            String description,
            ArrayList<String> genres,
            Float price,
            Integer ageRestriction,
            ArrayList<String> platforms) {


        int gameId = ++this.id;
        ComputerGame newGame = new ComputerGame(
                name,
                description,
                genres,
                price,
                ageRestriction,
                platforms,
                gameId);

        this.storeContainer.add(newGame);
        return this;
    }

    public ArrayList<ComputerGame> getGames() {
        return this.storeContainer;
    }

    public int getLargestId(){
        return this.id;
    }

    public int getGamesAmount(){
        return this.storeContainer.size();
    }

    public ArrayList<ComputerGame> searchByTags(String... tags) {
        ArrayList<ComputerGame> gamesFound = new ArrayList<>();
        for (String tag : tags) {
            for (ComputerGame game : this.storeContainer) {
                if (game.getProperties().hasTag(tag))
                    gamesFound.add(game);
            }
        }
        return gamesFound;
    }

    public ArrayList<ComputerGame> searchByTag(String tag) {
        ArrayList<ComputerGame> gamesFound = new ArrayList<>();

        for (ComputerGame game : this.storeContainer) {
            if (game.getProperties().hasTag(tag))
                gamesFound.add(game);
        }
        return gamesFound;
    }


    public ArrayList<ComputerGame> searchByName(String name) {
        ArrayList<ComputerGame> gamesFound = new ArrayList<>();

        for (ComputerGame game : this.storeContainer) {
            if (game.getProperties().getName().equals(name))
                gamesFound.add(game);
        }
        return gamesFound;
    }

    public ComputerGame searchById(int id) {
        for (ComputerGame game : this.storeContainer) {
            if (game.getId() == id)
                return game;
        }
        return null;
    }

    public int tagsMatches(int id, String... tags) {
        ComputerGame game = this.searchById(id);

        if (game == null) {
            return 0;
        }

        int counter = 0;
        for (String tag : tags) {
            if (game.getProperties().hasTag(tag))
                counter++;
        }
        return counter;
    }

    ComputerStore removeGame(int id) {
        for (int i = 0; i < this.storeContainer.size(); i++) {
            if (this.storeContainer.get(i).getId() == id)
                this.storeContainer.remove(i);
        }
        return this;
    }
}



