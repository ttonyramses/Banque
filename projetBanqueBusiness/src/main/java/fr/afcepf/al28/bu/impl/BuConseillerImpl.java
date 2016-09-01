/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.bu.impl;

import fr.afcepf.al28.banque.dao.api.UtilisateurDao;
import fr.afcepf.al28.banque.entity.Utilisateur;
import fr.afcepf.al28.bu.BuConseiller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tony
 */
@Service
public class BuConseillerImpl implements BuConseiller{

    @Autowired
    private UtilisateurDao userDao;
    public Utilisateur identifier(String mail, String mdp) {
        return userDao.identifier(mail, mdp);
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur user) {
        return userDao.ajouterUtilisateur(user);
    }

    @Override
    public Boolean supprimer(Utilisateur user) {
        return userDao.supprimer(user);
    }

    @Override
    public List<Utilisateur> rechercher(String nom) {
        return userDao.rechercher(nom);
    }
    
}
