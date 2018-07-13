import models.Play;
import models.Playwright;
import models.Theatre;
import models.Ticket;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TicketTest {

    Ticket ticket1;
    Play play1;
    Theatre theatre1;
    Playwright playwright1;

    @Before
    public void before(){
        playwright1 = new Playwright("William Shakespeare", "British");
        play1 = new Play("Romeo and Juliet", 1754, 55000, playwright1);
        theatre1 = new Theatre("Palais Garnier", "Paris", 1900, 0, 0);
        ticket1 = new Ticket(52.50, theatre1, play1);
    }

    @Test
    public void hasSalesPrice(){
        assertEquals(52.50, ticket1.getSalePrice());
    }

    @Test
    public void hasTheatre(){
        assertEquals(theatre1, ticket1.getTheatre());
    }

    @Test
    public void hasPlay(){
        assertEquals(play1, ticket1.getPlay());
    }

    @Test
    public void canCalculateProfitPerUnitSold(){
        assertEquals(23.50, ticket1.getProfitPerTicketSold(play1, theatre1), 0.5);
    }
}
