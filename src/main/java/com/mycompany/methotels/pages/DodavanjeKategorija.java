/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Kategorija;
import com.mycompany.methotels.services.dao.KategorijaDao;
import com.mycompany.methotels.services.dao.KlijentDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author admin
 */
public class DodavanjeKategorija {
    @Property
    private Kategorija kategorija;
    @Property
    private Kategorija onekategorija;
    @Inject
    private KategorijaDao kategorijaDao;
    @Property
    private List<Kategorija> kategorije;
    
    void onActivate() {
        if (kategorije == null) {
            kategorije = new ArrayList<Kategorija>();
        }
        kategorije = kategorijaDao.getListaSvihKategorija();
    }

    @CommitAfter
    Object onSuccess() {
        kategorijaDao.dodajKategoriju(kategorija);
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        kategorijaDao.obrisiKategoriju(id);
        return this;
    }
}
