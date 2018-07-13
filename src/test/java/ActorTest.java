import models.Actor;
import models.Character;
import models.Play;
import models.Playwright;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActorTest {

    Actor actor1;
    Character character1;
    Play play1;
    Playwright playwright1;

    @Before
    public void before(){
        playwright1 = new Playwright("William Shakespeare", "British");
        play1 = new Play("Romeo and Juliet", 1754, 55000, playwright1);
        character1 = new Character("Romeo Montague", play1);
        actor1 = new Actor("Leonardo Dicaprio", play1, character1);
    }

    @Test
    public void hasName(){
        assertEquals("Leonardo Dicaprio", actor1.getName());
    }

    @Test
    public void isInPlay(){
        assertEquals(play1, actor1.getPlay());
    }

    @Test
    public void hasRoleAsACharacter(){
        assertEquals(character1, actor1.getCharacter());
    }
}

