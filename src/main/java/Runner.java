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

            Theatre theatre1 = new Theatre("Palais Garnier", "Paris", 1900, 0, 0);
            DBHelper.save(theatre1);

            Theatre theatre2 = new Theatre("The Old Vic", "Bristol", 1000, 0,0);
            DBHelper.save(theatre2);

            Play play1 = new Play("Romeo and Juliet", 1754, 55000, playwright1);
            DBHelper.save(play1);

            Play play2 = new Play("Le Misanthrope", 1653, 34520, playwright2);
            DBHelper.save(play2);

            Critique critique1 = new Critique(5, "A scintillating display capturing all the intent of the author in a manner befitting the world's biggest stages.", "The Guardian", play1);
            DBHelper.save(critique1);

            Critique critique2 = new Critique(2, "A mediocre attempt to bring Shakespeare to a mainstream audience. Ultimately it falls flat, leaving the audience unmoved and regretful at having paid the staggeringly high admission fee.", "The Financial Times", play1);
            DBHelper.save(critique2);

            Character character1 = new Character("Romeo Montague", play1);
            DBHelper.save(character1);
            Character character2 = new Character("Juliet Capulet", play1);
            DBHelper.save(character2);

            Actor actor1 = new Actor("Leonardo Dicaprio", play1, character1);
            DBHelper.save(actor1);
            Actor actor2 = new Actor("Kate Winslett", play1, character2);
            DBHelper.save(actor2);


            DBPlay.addPlayToTheatre(play1, theatre1);
            DBHelper.update(theatre1);
            DBPlay.addPlayToTheatre(play2, theatre1);
            DBHelper.update(theatre1);
            DBPlay.addPlayToTheatre(play1, theatre2);
            DBHelper.update(theatre2);

            Ticket ticket1 = new Ticket(20.50, theatre1, play1);
            DBHelper.save(ticket1);
            Ticket ticket2 = new Ticket(11.20, theatre1, play2);
            DBHelper.save(ticket2);
            Ticket ticket3 = new Ticket(25.45, theatre2, play1);
            DBHelper.save(ticket3);

            DBTheatre.sellTicket(ticket1, theatre1, ticket1.getPlay(), theatre1.getCapacity());
            DBHelper.update(theatre1);
            DBTheatre.sellTicket(ticket2, theatre1, ticket2.getPlay(), theatre1.getCapacity());
            DBHelper.update(theatre1);


//          The code below models a sold out performance for which the theatre prints and sells tickets up to full capacity.
            DBTheatre.sellMultipleTickets(ticket1, theatre1, ticket1.getPlay(), theatre1.getCapacity());
            DBHelper.update(theatre1);

//          The code below models a situation where a large group (e.g. university literature students attending a play as            part of their course.
            DBTheatre.sellMultipleTickets(ticket3, theatre2, ticket3.getPlay(), 16);
            DBHelper.update(theatre1);

            List<Play> playsShownAtTheatre1 = DBTheatre.getTheatrePlays(theatre1);

            List<Theatre> venuesShowingPlay1 = DBPlay.getPlayVenues(play1);


        }
}
