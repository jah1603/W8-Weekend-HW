package models;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class Character {

    private int id;
    private String name;
    private Play play;
    private Actor actor;

    public Character(String name, Play play){
        this.name = name;
        this.play = play;
    }

    public Character(){}

    @OneToOne(mappedBy = "character", fetch = FetchType.LAZY)
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "play_id", nullable = false)
    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}
