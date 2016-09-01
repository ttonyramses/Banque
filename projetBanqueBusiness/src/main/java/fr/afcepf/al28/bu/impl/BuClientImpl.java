/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.bu.impl;

import fr.afcepf.al28.banque.dao.api.CompteDao;
import fr.afcepf.al28.banque.dao.api.OperationDao;
import fr.afcepf.al28.banque.dao.api.UtilisateurDao;
import fr.afcepf.al28.banque.entity.Client;
import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Utilisateur;
import fr.afcepf.al28.bu.BuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tony
 */
@Service
public class BuClientImpl implements BuClient{
    
    @Autowired
    private UtilisateurDao userDao;
    
    @Autowired
    private OperationDao opDao;
    
    @Autowired
    private CompteDao cmptDao;

    @Override
    public Utilisateur identifier(String mail, String mdp) {
        return userDao.identifier(mail, mdp);
    }

    @Override
    public Client listeCompte(Client user) {
        return cmptDao.listeCompte(user);
    }

    @Override
    public Compte listeOperation(Compte compte) {
        return opDao.listeOperation(compte);
    }

    public void setUserDao(UtilisateurDao userDao) {
        this.userDao = userDao;
    }

    public void setOpDao(OperationDao opDao) {
        this.opDao = opDao;
    }

    public void setCmptDao(CompteDao cmptDao) {
        this.cmptDao = cmptDao;
    }
    
    
    
}
