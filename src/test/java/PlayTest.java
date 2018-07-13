import models.*;
import models.Character;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayTest {

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
    public void hasTitle(){
        assertEquals("Romeo and Juliet", play1.getTitle());
    }

    @Test
    public void hasYear(){
        assertEquals(1754, play1.getYearOfFirstPerformance());
    }

    @Test
    public void hasStagingCost(){
        assertEquals(55000.0, play1.getTheatreStagingCost());
    }

    @Test
    public void hasPlaywright(){
        assertEquals(playwright1, play1.getPlaywright());
    }

    @Test
    public void hasCharacters(){
        assertEquals(0, play1.countCharacters());
    }

    @Test
    public void hasActors(){
        assertEquals(0, play1.countActors());
    }

    @Test
    public void hasVenues(){
        assertEquals(0, play1.countTheatres());
    }

    @Test
    public void hasTickets(){
        assertEquals(0, play1.countTickets());
    }

    @Test
    public void hasCritiques(){
        assertEquals(0, play1.countCritiques());
    }

    @Test
    public void canCalculateBreakevenTicketPrice(){
        assertEquals(29, play1.getBreakevenTicketPriceAssumingFullCapacity(theatre1), 1);
    }

    @Test
    public void canAddVenue(){
        play1.addVenueToPlayVenues(theatre1);
        assertEquals(1, play1.countTheatres());
    }

}
