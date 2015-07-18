/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Kategorija;
import com.mycompany.methotels.entities.Klijent;
import com.mycompany.methotels.services.dao.KategorijaDao;
import com.mycompany.methotels.services.dao.KlijentDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author admin
 */
public class DodavanjeKlijenata {
    
    @Property
    private Klijent klijent;
    @Property
    private Klijent oneklijent;
    @Inject
    private Messages messages;
    @Inject
    private KategorijaDao kategorijeDao;
    @Inject
    private KlijentDao klijentiDao;
    @Property
    private Kategorija katId;
    @Property
    @Persist
    private List<Kategorija> kategorije;
    public ValueEncoder getEncoder(){
        return new ValueEncoder<Kategorija>() {
            @Override
            public String toClient(Kategorija v) {
                return String.valueOf(v.getId());
            }
            @Override
            public Kategorija toValue(String string) {
                Kategorija kat = kategorijeDao.getKategorijaById(Integer.parseInt(string));
                return kat;
            }
        };
    }
    
    @Property
    private List<Klijent> klijenti;

    void onActivate() {
        klijent = new Klijent();
        if (klijenti == null) {
            klijenti = new ArrayList<Klijent>();
        }
        klijenti = klijentiDao.getListaSvihKlijenata();
        kategorije = kategorijeDao.getListaSvihKategorija();
    }
    
    @CommitAfter
    Object onSuccess() {
        klijent.setKatId(katId);
        klijentiDao.dodajKlijenta(klijent);
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        klijentiDao.obrisiKlijenta(id);
        return this;
    }

    public String getKategorija() {
        if (oneklijent.getKatId()!=null) {
            return oneklijent.getKatId().getNaziv();
        } else {
            return "";
        }
    }
}
