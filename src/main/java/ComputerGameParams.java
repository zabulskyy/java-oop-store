import java.util.ArrayList;

class ComputerGameParams {
    private String name;
    private String description;
    private ArrayList<String> genres;
    private Float price;
    private Integer ageRestriction;
    private ArrayList<String> platforms;

    ComputerGameParams(){
        name = "";
        description = "";
        genres = new ArrayList<>();
        price = 0f;
        ageRestriction = 0;
        platforms = new ArrayList<>();
    }

    public ArrayList<String> getTags() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add(this.name);
        tags.addAll(this.genres);
        tags.addAll(this.platforms);
        return tags;
    }


    public boolean hasTag(String tag) {
        ArrayList<String> gameTags = this.getTags();
        return gameTags.contains(tag);
    }


    public String getName() {
        return name;
    }

    public ComputerGameParams setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ComputerGameParams setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public ComputerGameParams setGenres(ArrayList<String> genres) {
        this.genres = genres;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public ComputerGameParams setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public ComputerGameParams setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    public ArrayList<String> getPlatforms() {
        return platforms;
    }

    public ComputerGameParams setPlatforms(ArrayList<String> platforms) {
        this.platforms = platforms;
        return this;
    }

}
