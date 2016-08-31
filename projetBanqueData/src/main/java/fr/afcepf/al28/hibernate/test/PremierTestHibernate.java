package fr.afcepf.al28.hibernate.test;

import fr.afcepf.al28.banque.entity.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.al28.banque.entity.Conseiller;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class PremierTestHibernate {
	
	private static Logger log = Logger.getLogger(PremierTestHibernate.class);
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Conseiller conseiller = new Conseiller(null, "TELILI", "Haifa", "123", "haifa@gmail.com","99 rue de l'argent");
//			Client client = new Client(null, "TAFEUMEWE", "Tony", "123", "tony@gmail.com", "1 rue de l'union", true,  conseiller);
			Client client1=new Client(null, "Tafeumewe", "tony", "papi", "ttonyramses@yahoo.fr", "Rouen", Boolean.FALSE, conseiller);
			Client client2=new Client(null, "Storero", "Nicolas", "super", "nicolas.storero@yahoo.fr", "Monrouge", Boolean.TRUE, conseiller);
                        
                        session.save(conseiller);
                        session.save(client1);
                        session.save(client2);
			
			tx.commit();
			
		}catch (Exception e) {
			log.fatal(e.getMessage());
		
		}finally {
			try {
				session.close();
			} catch (Exception e) {
				log.fatal(e.getMessage());
			}
		}

	}
			
			
			
}
