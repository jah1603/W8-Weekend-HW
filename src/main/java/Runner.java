import db.DBHelper;
import models.Critique;
import models.Play;
import models.Playwright;
import models.Theatre;

public class Runner {


        public static void main(String[] args) {

            Playwright playwright1 = new Playwright("William Shakespeare", "British");
            DBHelper.save(playwright1);

            Theatre theatre1 = new Theatre("Palais Garnier", "Paris", 1900);
            DBHelper.save(theatre1);

            Play play1 = new Play("Romeo and Juliet", 1754, playwright1);
            DBHelper.save(play1);

            Critique critique = new Critique(5, "A scintillating display capturing all the intent of the author in a manner befitting the world's biggest stages.", "The Guardian", play1);


        }
}
