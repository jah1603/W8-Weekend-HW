package db;

import models.Play;
import models.Theatre;
import models.Ticket;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBTheatre {

    private static Session session;
    private static Transaction transaction;

    public static void sellTicket(Ticket ticket, Theatre theatre, Play play){
        theatre.printTicket(ticket);
        theatre.addTicketToSoldTickets(ticket);
        theatre.cashTransferredUponSale(ticket);
        theatre.profitIncrementedUponSale(ticket);
    }


    public static List<Play> getTheatrePlays(Theatre theatre){
        List<Play> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Play.class);
            cr.createAlias("theatres", "theatre"); // ADDED
            cr.add(Restrictions.eq("theatre.id", theatre.getId())); // ADDED
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


}
