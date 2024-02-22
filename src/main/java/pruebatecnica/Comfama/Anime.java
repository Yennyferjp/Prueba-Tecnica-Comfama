package pruebatecnica.Comfama;


public class Anime {
    private int malId;
    private String url;
    private Images images;
    private String title;
    private String rating;
    private double score;
    private String synopsis;
    private int year;

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

class Image {
    private String imageUrl;

    public Image() {
    }

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}




