import models.*;
import models.Character;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TheatreTest {

    Theatre theatre1;
    Play play1;
    Character character1;
    Playwright playwright1;
    Ticket ticket1;


    @Before
    public void before(){
        playwright1 = new Playwright("William Shakespeare", "British");
        play1 = new Play("Romeo and Juliet", 1754, 55000, playwright1);
        character1 = new Character("Romeo Montague", play1);
        theatre1 = new Theatre("Palais Garnier", "Paris", 1900, 0, 0);
        ticket1 = new Ticket(52.50, theatre1, play1);
    }

    @Test
    public void hasName(){
        assertEquals("Palais Garnier", theatre1.getName());
    }

    @Test
    public void hasCity(){
        assertEquals("Paris", theatre1.getCity());
    }

    @Test
    public void hasCapacity(){
        assertEquals(1900, theatre1.getCapacity());
    }

    @Test
    public void hasIncome(){
        assertEquals(0, theatre1.getIncome(), 0.5);
    }

    @Test
    public void hasProfit(){
        assertEquals(0, theatre1.getProfit(), 0.5);
    }

    @Test
    public void canPrintTicket(){
        theatre1.addPlayToPerformanceList(play1);
        theatre1.printTicket(ticket1);
        assertEquals(1, theatre1.countTicketPrintedAndUnsold());
    }

    @Test
    public void canPrintTicketsUpToFullCapacity(){
        theatre1.addPlayToPerformanceList(play1);
        theatre1.printTicketsUpToCapacity(ticket1, 1900);
        assertEquals(1900, theatre1.countTicketPrintedAndUnsold());
    }

    @Test
    public void sellOutPerformancePossible(){
        theatre1.addPlayToPerformanceList(play1);
        theatre1.calculateStagingExpenditureForPlay(play1);
        theatre1.printTicketsUpToCapacity(ticket1, 1900);
        for (int numticks = 1; numticks <= 1900; numticks++)
        {
            theatre1.addTicketToSoldTickets(ticket1);
            theatre1.cashTransferredUponSale(ticket1);
            theatre1.profitIncrementedUponSale(ticket1);
        }
        assertEquals(44750, theatre1.getProfit(), 1);
    }


    @Test
    public void sellTicket(){
        theatre1.addPlayToPerformanceList(play1);
        theatre1.calculateStagingExpenditureForPlay(play1);
        theatre1.printTicket(ticket1);
        theatre1.addTicketToSoldTickets(ticket1);
        theatre1.cashTransferredUponSale(ticket1);
        theatre1.profitIncrementedUponSale(ticket1);
        assertEquals(11.5, theatre1.getIncome(), 0.5);
        assertEquals(0, theatre1.countTicketPrintedAndUnsold());
        assertEquals(1, theatre1.countPlays());
        assertEquals(1, theatre1.countTicketSales());
        assertEquals(-54989, theatre1.getProfit(), 0.5);
    }

}
