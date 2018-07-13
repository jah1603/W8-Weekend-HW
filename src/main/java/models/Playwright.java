package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playwrights")
public class Playwright {

    private int id;
    private String name;
    private String nationality;
    private List<Play> œuvre;

    public Playwright(String name, String nationality){
        this.name = name;
        this.nationality = nationality;
        this.œuvre = new ArrayList<Play>();
    }

    public Playwright(){}

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

    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @OneToMany(mappedBy = "playwright", fetch = FetchType.LAZY)
    public List<Play> getŒuvre() {
        return œuvre;
    }

    public void setŒuvre(List<Play> œuvre) {
        this.œuvre = œuvre;
    }

    public int countWorks(){
        return this.œuvre.size();
    }
}
