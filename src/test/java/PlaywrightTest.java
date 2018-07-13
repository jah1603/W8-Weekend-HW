import models.Playwright;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlaywrightTest {

    Playwright playwright1;

    @Before
    public void before(){
        playwright1 = new Playwright("William Shakespeare", "British");
    }

    @Test
    public void hasName(){
        assertEquals("William Shakespeare", playwright1.getName());
    }

    @Test
    public void hasNationality(){
        assertEquals("British", playwright1.getNationality());
    }
}
