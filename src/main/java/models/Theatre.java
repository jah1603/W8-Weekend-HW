package models;

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
    private List<Play> performances;

    private Theatre(String name, String city, int capacity){
        this.name = name;
        this.city = city;
        this.capacity = capacity;
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

    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY)
    public List<Play> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Play> performances) {
        this.performances = performances;
    }
}
