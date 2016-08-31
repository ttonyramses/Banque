package fr.afcepf.al28.hibernate.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afcepf.al28.banque.entity.Client;
import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Conseiller;
import fr.afcepf.al28.banque.entity.Credit;
import fr.afcepf.al28.banque.entity.Debit;
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
			Compte compte = new Compte(null, "Compte epargne",20000.0, client1);
			Compte compte1 = new Compte(null, "Compte chèque", 5000.0,  client1);
//			Operation op1 = new Operation(null, new Date(), 125.02, "Debit", compte);
			Debit debit = new Debit(null, new Date(), 125.02, "paiment SFR", compte);
			Debit virement = new Debit(null, new Date(), 125.02, "Virement compte 1 vers 2", compte1, compte);
			Credit credit = new Credit(null, new Date(), 500.0, "Versement liquide", compte1);
                        
                        session.save(conseiller);
                        session.save(client1);
                        session.save(client2);
                        session.save(compte);
                        session.save(compte1);
                        session.save(debit);
                        session.save(virement);
                        session.save(credit);
                        
                       
			
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
