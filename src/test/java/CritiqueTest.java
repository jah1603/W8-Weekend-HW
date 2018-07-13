import models.Critique;
import models.Play;
import models.Playwright;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CritiqueTest {

    Play play1;
    Playwright playwright1;
    Critique critique1;

    @Before
    public void before(){

        playwright1 = new Playwright("William Shakespeare", "British");

        play1 = new Play("Romeo and Juliet", 1754, 55000, playwright1);

        critique1 = new Critique(5, "A scintillating display capturing all the intent of the author in a manner befitting the world's biggest stages.", "The Guardian", play1);
    }

    @Test
    public void hasStarRating(){
        assertEquals(5, critique1.getStarRating());
    }

    @Test
    public void hasSummary(){
        assertEquals("A scintillating display capturing all the intent of the author in a manner befitting the world's biggest stages.", critique1.getSummary());
    }

    @Test
    public void hasPublication(){
        assertEquals("The Guardian", critique1.getPublication());
    }

    @Test
    public void isWrittenForAnActualPlay(){
        assertEquals(play1, critique1.getPlay());
    }

}
