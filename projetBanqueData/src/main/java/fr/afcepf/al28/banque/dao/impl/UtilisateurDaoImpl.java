/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.banque.dao.impl;

import fr.afcepf.al28.banque.entity.Utilisateur;
import java.util.List;
import fr.afcepf.al28.banque.dao.api.UtilisateurDao;
import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Operation;
import org.apache.log4j.Logger;
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
public class UtilisateurDaoImpl implements UtilisateurDao {

    @Autowired
    private SessionFactory sf;

    private static Logger log = Logger.getLogger(UtilisateurDaoImpl.class);

    @Override
    public Utilisateur identifier(String mail, String mdp) {
        Utilisateur user = null;
        try {
            user = (Utilisateur) sf.getCurrentSession().createQuery("select u from Utilisateur u where u.mail=:umail and u.mdp=:umdp").
                    setParameter("umail", mail).
                    setParameter("umdp", mdp).
                    uniqueResult();
        } catch (Exception e) {
            log.error("Error identifier Utilisateur", e);
        }

        return user;
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur user) {
        try {
            Integer id=(Integer)sf.getCurrentSession().save(user);
            log.info("moniduser="+id);
            user=loadUser(id);
        } catch (Exception e) {
            log.error("ajouterUtilisateur", e);
        }

        return user;
    }

    @Override
    public Boolean supprimer(Utilisateur user) {
        Boolean test = false;
        try {
            sf.getCurrentSession().delete(user);
            test = true;
        } catch (Exception e) {
            log.error("Supprimer Utilisateur", e);
        }

        return test;
    }

    @Override
    public List<Utilisateur> rechercher(String nom) {
        List<Utilisateur> listUser = null;
        try {
            listUser = sf.getCurrentSession().createQuery("select u from Utilisateur u where u.nom like:unom ").
                    setParameter("unom", "%" + nom + "%").
                    list();
        } catch (Exception e) {
            log.error("Error identifier Utilisateur", e);
        }

        return listUser;
    }

    @Override
    public Utilisateur loadUser(Integer id) {
        Utilisateur user = null;
        try {
            user = (Utilisateur) sf.getCurrentSession().load(Utilisateur.class, id);
        } catch (Exception e) {
            log.error("ajouterUtilisateur", e);
        }
        return user;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Compte ajouterCompte(Compte compte) {
        try {
            sf.getCurrentSession().save(compte);
        } catch (Exception e) {
            log.error("ajouterCompte", e);
        }

        return compte;
    }

    @Override
    public Operation ajouterOperation(Operation op) {
        try {
            sf.getCurrentSession().save(op);
        } catch (Exception e) {
            log.error("ajouterOperation", e);
        }

        return op;
    }

}
