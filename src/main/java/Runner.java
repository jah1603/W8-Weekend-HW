import db.DBHelper;
import db.DBPlay;
import db.DBTheatre;
import models.*;
import models.Character;

import java.util.List;

public class Runner {


        public static void main(String[] args) {

            Playwright playwright1 = new Playwright("William Shakespeare", "British");
            DBHelper.save(playwright1);

            Playwright playwright2 = new Playwright("Molière", "French");
            DBHelper.save(playwright2);

            Theatre theatre1 = new Theatre("Palais Garnier", "Paris", 1900);
            DBHelper.save(theatre1);

            Play play1 = new Play("Romeo and Juliet", 1754, playwright1);
            DBHelper.save(play1);

            Play play2 = new Play("Le Misanthrope", 1653, playwright2);
            DBHelper.save(play2);

            Critique critique1 = new Critique(5, "A scintillating display capturing all the intent of the author in a manner befitting the world's biggest stages.", "The Guardian", play1);

            Critique critique2 = new Critique(2, "A mediocre attempt to bring Shakespeare to a mainstream audience. Ultimately it falls flat, leaving the audience unmoved and regretful at having paid the staggeringly high admission fee.", "The Financial Times", play1);

            Character character1 = new Character("Romeo Montague", play1);
            Character character2 = new Character("Juliet Capulet", play1);

            Actor actor1 = new Actor("Leonardo Dicaprio", play1, character1);
            Actor actor2 = new Actor("Kate Winslett", play1, character2);

            DBPlay.addPlayToTheatre(play1, theatre1);
            DBPlay.addPlayToTheatre(play2, theatre1);



            List<Play> plays = DBTheatre.getTheatrePlays(theatre1);

            List<Theatre> venuesForPlay1 = DBPlay.getPlayVenues(play1);


        }
}
