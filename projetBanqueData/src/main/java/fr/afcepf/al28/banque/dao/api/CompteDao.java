/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.banque.dao.api;

import fr.afcepf.al28.banque.entity.Client;
import fr.afcepf.al28.banque.entity.Compte;
import java.util.List;

/**
 *
 * @author tony
 */
public interface CompteDao {
    
    public Client listeCompte(Client user);   
}
