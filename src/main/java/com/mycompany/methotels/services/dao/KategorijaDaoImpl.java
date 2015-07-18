/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services.dao;

import com.mycompany.methotels.entities.Kategorija;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author admin
 */
public class KategorijaDaoImpl implements KategorijaDao {

    @Inject
    private Session session;
    
    @Override
    public List<Kategorija> getListaSvihKategorija() {
        return session.createCriteria(Kategorija.class).list();
    }

    @Override
    public Kategorija getKategorijaById(Integer id) {
        return (Kategorija) session.createCriteria(Kategorija.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void dodajKategoriju(Kategorija kategorija) {
        session.persist(kategorija);
    }

    @Override
    public void obrisiKategoriju(Integer id) {
        Kategorija kategorija = (Kategorija) session.createCriteria(Kategorija.class).add(Restrictions.eq("id",
            id)).uniqueResult();
        session.delete(kategorija);
    }
    
}
