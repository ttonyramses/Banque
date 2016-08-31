/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.banque.dao.api;

import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Operation;
import fr.afcepf.al28.banque.entity.Utilisateur;
import java.util.List;

/**
 *
 * @author tony
 */
public interface UtilisateurDao {
    
    public Utilisateur identifier(String mail, String mdp);
    public Utilisateur ajouterUtilisateur(Utilisateur user);
    public Compte ajouterCompte(Compte compte);
    public Operation ajouterOperation(Operation op);
    public Boolean supprimer(Utilisateur user);
    public List<Utilisateur> rechercher (String nom);
    public Utilisateur loadUser(Integer id);
    
}
