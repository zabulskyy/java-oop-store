import java.util.ArrayList;

public class ComputerGame {
    private String name;
    private String description;
    private ArrayList<String> genres;
    private Float price;
    private Integer ageRestriction;
    private ArrayList<String> platforms;
    private Integer id;

    public ComputerGame(
            String name,
            String description,
            ArrayList<String> genres,
            Float price,
            Integer ageRestriction,
            ArrayList<String> platforms,
            Integer id) {

        this.name = name;
        this.description = description;
        this.genres = genres;
        this.price = price;
        this.ageRestriction = ageRestriction;
        this.platforms = platforms;
        this.id = id;

    }

    public ArrayList<String> getTags() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add(this.name);
        tags.add(this.ageRestriction.toString());
        tags.addAll(this.genres);
        tags.addAll(this.platforms);
        return tags;
    }


    public boolean hasTag(String tag){
        ArrayList<String> gameTags = this.getTags();
        return gameTags.contains(tag);
    }


    public String getName() {
        return name;
    }

    public ComputerGame setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ComputerGame setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public ComputerGame setGenres(ArrayList<String> genres) {
        this.genres = genres;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public ComputerGame setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public ComputerGame setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    public ArrayList<String> getPlatforms() {
        return platforms;
    }

    public ComputerGame setPlatforms(ArrayList<String> platforms) {
        this.platforms = platforms;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public ComputerGame setId(Integer id) {
        this.id = id;
        return this;
    }

}
