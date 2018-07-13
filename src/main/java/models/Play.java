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
    private double theatreStagingCost;
    private Playwright playwright;
    private List<Theatre> venues;
    private List<Critique> critiques;
    private List<Character> characters;
    private List<Actor> actors;
    private List<Ticket> tickets;

    public Play(String title, int yearOfFirstPerformance, double theatreStagingCost, Playwright playwright){
        this.title = title;
        this.yearOfFirstPerformance = yearOfFirstPerformance;
        this.theatreStagingCost = theatreStagingCost;
        this.playwright = playwright;
        this.critiques = new ArrayList<Critique>();
        this.venues = new ArrayList<Theatre>();
        this.characters = new ArrayList<Character>();
        this.actors = new ArrayList<Actor>();
        this.tickets = new ArrayList<Ticket>();
    }

    public Play(){}

    @OneToMany(mappedBy = "play", fetch = FetchType.LAZY)
    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @OneToMany(mappedBy = "play", fetch = FetchType.LAZY)
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @OneToMany(mappedBy = "play", fetch = FetchType.LAZY)
    public List<Critique> getCritique() {
        return critiques;
    }

    public void setCritique(List<Critique> critique) {
        this.critiques = critique;
    }

    @OneToMany(mappedBy = "play", fetch = FetchType.LAZY)
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
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

    @Column(name = "theatre_staging_cost")
    public double getTheatreStagingCost(){
        return theatreStagingCost;
    }

    public void setTheatreStagingCost(double theatreStagingCost){
        this.theatreStagingCost = theatreStagingCost;
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
    @JoinTable(name = "theatre_play",
            joinColumns = {@JoinColumn(name = "play_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "theatre_id", nullable = false, updatable = false)})
    public List<Theatre> getVenue() {
        return venues;
    }

    public void setVenue(List<Theatre> venues) {
        this.venues = venues;
    }

    public void addVenueToPlayVenues(Theatre venue){
        this.venues.add(venue);
    }

    public double getBreakevenTicketPriceAssumingFullCapacity(Theatre theatre){
        return this.theatreStagingCost / theatre.getCapacity();
    }

}
