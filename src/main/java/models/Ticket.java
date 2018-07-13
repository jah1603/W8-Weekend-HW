package models;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    private int id;
    private double salePrice;
    private Theatre theatre;
    private Play play;

    public Ticket(double salePrice, Theatre theatre, Play play){
        this.salePrice = salePrice;
        this.theatre = theatre;
        this.play = play;
    }

    public Ticket(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "sale_price")
    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
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
