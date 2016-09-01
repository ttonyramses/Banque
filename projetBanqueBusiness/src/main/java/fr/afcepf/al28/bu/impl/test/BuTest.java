/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.bu.impl.test;

import fr.afcepf.al28.banque.dao.api.UtilisateurDao;
import fr.afcepf.al28.banque.entity.Utilisateur;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author tony
 */
public class BuTest {

    private static Logger log = Logger.getLogger(BuTest.class);

    public static void main(String[] args) {

        BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springBu.xml");
        UtilisateurDao userDao = bf.getBean(UtilisateurDao.class);
        
        for(Utilisateur user:userDao.rechercher("")){
            log.info(user);
        }
        
        Utilisateur user1=userDao.identifier("toto", "tata");
        Utilisateur user2=userDao.identifier("haifa@gmail.com ", "123");
        
        log.info("user1="+user1);
        log.info("user2="+user2);
    }

}
