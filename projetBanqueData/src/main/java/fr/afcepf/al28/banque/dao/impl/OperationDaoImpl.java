/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.al28.banque.dao.impl;

import fr.afcepf.al28.banque.entity.Compte;
import fr.afcepf.al28.banque.entity.Operation;
import java.util.List;
import fr.afcepf.al28.banque.dao.api.OperationDao;
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
public class OperationDaoImpl implements OperationDao {

    @Autowired
    private SessionFactory sf;
    private static Logger log = Logger.getLogger(OperationDaoImpl.class);

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Compte listeOperation(Compte compte) {
        try {
            compte = (Compte) sf.getCurrentSession().createQuery("SELECT c from Compte c left join fetch c.operations where c.numero=:cnumero").
                    setParameter("cnumero", "%" + compte.getNumero()).
                    uniqueResult();
        } catch (Exception e) {
            log.error("Error Liste Operation", e);
        }

        return compte;
    }

}
