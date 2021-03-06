package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatres")
public class Theatre {

    private int id;
    private String name;
    private String city;
    private int capacity;
    private double income;
    private double profit;
    private List<Play> performances;
    private List<Ticket> ticketsPrintedAndUnsold;
    private List<Ticket> ticketsSold;

    public Theatre(String name, String city, int capacity, double income, double profit) {
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.income = income;
        this.profit = profit;
        this.performances = new ArrayList<Play>();
        this.ticketsPrintedAndUnsold = new ArrayList<Ticket>();
        this.ticketsSold = new ArrayList<Ticket>();
    }

    public Theatre() {
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column(name = "income")
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Column(name = "profit")
    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "theatre_play",
            joinColumns = {@JoinColumn(name = "theatre_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "play_id", nullable = false, updatable = false)})
    public List<Play> getPerformances() {
        return performances;
    }

    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY)
    public List<Ticket> getTicketsPrinted() {
        return ticketsPrintedAndUnsold;
    }

    public void setTicketsPrinted(List<Ticket> tickets) {
        this.ticketsPrintedAndUnsold = tickets;
    }

    public void setPerformances(List<Play> performances) {
        this.performances = performances;
    }

    public void addPlayToPerformanceList(Play play) {
        this.performances.add(play);
    }

    public void printTicket(Ticket ticket) {
        this.ticketsPrintedAndUnsold.add(ticket);
    }

    public void addTicketToSoldTickets(Ticket ticket) {
        this.ticketsPrintedAndUnsold.remove(ticket);
        this.ticketsSold.add(ticket);
    }

    public void cashTransferredUponSale(Ticket ticket) {
        this.income = income + ticket.getSalePrice();
    }

    public void profitIncrementedUponSale(Ticket ticket) {
        this.profit = profit + ticket.getSalePrice();
    }

    public int countTicketSales() {
        return this.ticketsSold.size();
    }

    public int countTicketPrintedAndUnsold() {
        return this.ticketsPrintedAndUnsold.size();
    }

    public int countPlays() {
        return this.performances.size();
    }

    public void printTicketsUpToCapacity(Ticket ticket, int number){
        for (int numticks = 1; numticks <= number; numticks++)
        {
           this.ticketsPrintedAndUnsold.add(ticket);
        }
    }

    public double calculateStagingExpenditureForPlay(Play play) {
        return profit -= play.getTheatreStagingCost();
    }

}

