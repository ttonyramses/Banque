/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.banque.dao.impl;

import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Utilisateur;
import java.util.List;
import fr.afcepf.al28.banque.dao.api.CompteDao;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tony
 */
@Service
@Transactional
public class CompteDaoImpl implements CompteDao {

    @Autowired
    private SessionFactory sf;

    private static Logger log = Logger.getLogger(CompteDaoImpl.class);

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Utilisateur listeCompte(Utilisateur user) {
        try {
            user = (Utilisateur) sf.getCurrentSession().createQuery("SELECT c from Client c left join fetch c.comptes where c.id=:uid").
                    setParameter("uid", "%" + user.getId()).
                    uniqueResult();
        } catch (Exception e) {
            log.error("Error Liste Compte", e);
        }

        return user;
    }

}
