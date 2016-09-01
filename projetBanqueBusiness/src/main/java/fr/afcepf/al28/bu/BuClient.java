/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.bu;

import fr.afcepf.al28.banque.entity.Client;
import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Utilisateur;

/**
 *
 * @author tony
 */
public interface BuClient {

    public Utilisateur identifier(String mail, String mdp);

    public Client listeCompte(Client user);

    public Compte listeOperation(Compte compte);

}
