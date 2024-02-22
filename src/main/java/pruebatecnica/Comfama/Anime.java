package pruebatecnica.Comfama;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Anime {
    @JsonProperty("mal_id")
    private int malId;
    private String url;
    private Images images;
    private String title;
    private String rating;
    private double score;
    private String synopsis;
    private int year;

    public Anime() {
    }

    public Anime(int mal_Id, String url, Images images, String title, String rating, double score, String synopsis, int year) {
        this.malId = mal_Id;
        this.url = url;
        this.images = images;
        this.title = title;
        this.rating = rating;
        this.score = score;
        this.synopsis = synopsis;
        this.year = year;
    }

    public int getMalId() {
        return malId;
    }

    public void setMalId(int malId) {
        this.malId = malId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Images {
    private Image jpg;

    public Images() {
    }

    public Images(Image jpg) {
        this.jpg = jpg;
    }

    public Image getJpg() {
        return jpg;
    }

    public void setJpg(Image jpg) {
        this.jpg = jpg;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Image {
    @JsonProperty("image_url")
    private String imageUrl;

    public Image() {
    }

    public Image(String image_url) {
        this.imageUrl = image_url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}




