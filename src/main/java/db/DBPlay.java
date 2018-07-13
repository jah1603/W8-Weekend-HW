package db;

import models.Play;
import models.Theatre;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBPlay {

    private static Session session;
    private static Transaction transaction;


    public static void addPlayToTheatre(Play play, Theatre theatre){
        play.addVenueToPlayVenues(theatre);
        theatre.addPlayToPerformanceList(play);
        theatre.calculateStagingExpenditureForPlay(play);
        DBHelper.update(play);
    }

    public static List<Theatre> getPlayVenues(Play play){
        List<Theatre> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Theatre.class);
            cr.createAlias("plays", "play"); // ADDED
            cr.add(Restrictions.eq("play.id", play.getId())); // ADDED
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


}
