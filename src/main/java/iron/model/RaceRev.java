package iron.model;

public class RaceRev {
    private String reviewId;
    private Race race;
    private Racer racer;
    private int rating;
    private String comment;
    
    public RaceRev(String reviewId, Race race, Racer racer, int rating, String comment) {
        this.reviewId = reviewId;
        this.race = race;
        this.racer = racer;
        this.rating = rating;
        this.comment = comment;
    }

    public String getReviewId() { return reviewId; }
    public void setReviewId(String reviewId) { this.reviewId = reviewId; }
    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }
    public Racer getRacer() { return racer; }
    public void setRacer(Racer racer) { this.racer = racer; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}