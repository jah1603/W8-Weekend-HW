package models;

import javax.persistence.*;

@Entity
@Table(name = "critiques")
public class Critique {

    private int id;
    private int starRating;
    private String summary;
    private String publication;
    private Play play;

    public Critique(int starRating, String summary, String publication, Play play){
        this.starRating = starRating;
        this.summary = summary;
        this.publication = publication;
        this.play = play;
    }

    public Critique(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "star_rating")
    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "publication")
    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @ManyToOne
    @JoinColumn(name = "play_id", nullable = false)
    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}
