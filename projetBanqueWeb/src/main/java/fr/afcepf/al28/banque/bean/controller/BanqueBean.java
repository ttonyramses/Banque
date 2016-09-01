/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.banque.bean.controller;

import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Operation;
import fr.afcepf.al28.banque.entity.Utilisateur;
import fr.afcepf.al28.bu.BuClient;
import fr.afcepf.al28.bu.BuConseiller;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author tony
 */
@ManagedBean(name="mbBank")
@SessionScoped
public class BanqueBean {

    private Logger log=Logger.getLogger(BanqueBean.class);
    private Utilisateur user =new Utilisateur();
    private List<Utilisateur> listClient ;
    private List<Compte> listCompte;
    private List<Operation> listOperation;
    
    @ManagedProperty(value="#{BuConseillerImpl}")
    private BuConseiller buConseiller;
    
    @ManagedProperty(value="#{BuClientImpl}")
    private BuClient buClient;
    

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<Utilisateur> getListClient() {
        return listClient;
    }

    public void setListClient(List<Utilisateur> listClient) {
        this.listClient = listClient;
    }

    public List<Compte> getListCompte() {
        return listCompte;
    }

    public void setListCompte(List<Compte> listCompte) {
        this.listCompte = listCompte;
    }

    public List<Operation> getListOperation() {
        return listOperation;
    }

    public void setListOperation(List<Operation> listOperation) {
        this.listOperation = listOperation;
    }

    public BuConseiller getBuConseiller() {
        return buConseiller;
    }

    public void setBuConseiller(BuConseiller buConseiller) {
        this.buConseiller = buConseiller;
    }

    public BuClient getBuClient() {
        return buClient;
    }

    public void setBuClient(BuClient buClient) {
        this.buClient = buClient;
    }
    
    
    public String identifier(){
        String suite=null;
        
        log.info(user);
        buClient.identifier(user.getMail(), user.getMdp());
        
        
        Utilisateur userClient=buClient.identifier(user.getMail(), user.getMdp());
        if(userClient==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email ou mot de passe erroné"));
        }else{
            this.user=userClient;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Connexion reussie"));

        }
        return suite;
    }
    
}
