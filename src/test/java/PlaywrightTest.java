import models.*;
import models.Character;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlaywrightTest {

    Play play1;
    Character character1;
    Actor actor1;
    Playwright playwright1;
    Ticket ticket1;
    Critique critique1;
    Theatre theatre1;

    @Before
    public void before(){
        playwright1 = new Playwright("William Shakespeare", "British");
        play1 = new Play("Romeo and Juliet", 1754, 55000, playwright1);
        character1 = new Character("Romeo Montague", play1);
        theatre1 = new Theatre("Palais Garnier", "Paris", 1900, 0, 0);
        ticket1 = new Ticket(52.50, theatre1, play1);
        actor1 = new Actor("Leonardo Dicaprio", play1, character1);
        critique1 = new Critique(5, "A scintillating display capturing all the intent of the author in a manner befitting the world's biggest stages.", "The Guardian", play1);
    }

    @Test
    public void hasName(){
        assertEquals("William Shakespeare", playwright1.getName());
    }

    @Test
    public void hasNationality(){
        assertEquals("British", playwright1.getNationality());
    }

    @Test
    public void hasŒuvre(){
        assertEquals(0, playwright1.countWorks());
    }
}
