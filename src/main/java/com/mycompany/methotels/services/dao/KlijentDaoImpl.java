/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services.dao;

import com.mycompany.methotels.entities.Klijent;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author admin
 */
public class KlijentDaoImpl implements KlijentDao {

    @Inject
    private Session session;
    
    @Override
    public List<Klijent> getListaSvihKlijenata() {
        return session.createCriteria(Klijent.class).list();
    }

    @Override
    public Klijent getKlijentaById(Integer id) {
        return (Klijent) session.createCriteria(Klijent.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void dodajKlijenta(Klijent klijent) {
        session.persist(klijent);
    }

    @Override
    public void obrisiKlijenta(Integer id) {
        Klijent klijent = (Klijent) session.createCriteria(Klijent.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(klijent);
    }
    
}
