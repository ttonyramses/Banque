/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.bu;

import fr.afcepf.al28.banque.entity.Utilisateur;
import java.util.List;

/**
 *
 * @author tony
 */
public interface BuConseiller {
    public Utilisateur identifier(String mail, String mdp);
    public Utilisateur ajouterUtilisateur(Utilisateur user);
    public Boolean supprimer(Utilisateur user);
    public List<Utilisateur> rechercher (String nom);
}
