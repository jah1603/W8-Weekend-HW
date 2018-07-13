package models;

import javax.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {

    private int id;
    private String name;
    private Play play;
    private Character character;

    public Actor(String name, Play play, Character character){
        this.name = name;
        this.play = play;
        this.character = character;
    }

    public Actor(){}

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
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
