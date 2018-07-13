package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plays")
public class Play {

    private int id;
    private String title;
    private int yearOfFirstPerformance;
    private Playwright playwright;
    private List<Theatre> venues;
    private Critique critique;

    public Play(String title, int yearOfFirstPerformance, Playwright playwright){
        this.title = title;
        this.yearOfFirstPerformance = yearOfFirstPerformance;
        this.playwright = playwright;
        this.venues = new ArrayList<Theatre>();
    }

    public Play(){}

    @OneToMany(mappedBy = "play", fetch = FetchType.LAZY)
    public Critique getCritique() {
        return critique;
    }

    public void setCritique(Critique critique) {
        this.critique = critique;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "year_of_first_performance")
    public int getYearOfFirstPerformance() {
        return yearOfFirstPerformance;
    }

    public void setYearOfFirstPerformance(int yearOfFirstPerformance) {
        this.yearOfFirstPerformance = yearOfFirstPerformance;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playwright_id", nullable = false)
    public Playwright getPlaywright() {
        return playwright;
    }

    public void setPlaywright(Playwright playwright) {
        this.playwright = playwright;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "pirate_raid",
            joinColumns = {@JoinColumn(name = "play_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "theatre_id", nullable = false, updatable = false)})
    public List<Theatre> getVenue() {
        return venues;
    }

    public void setVenue(List<Theatre> venues) {
        this.venues = venues;
    }
}
