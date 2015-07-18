/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services.dao;

import com.mycompany.methotels.entities.Kategorija;
import java.util.List;

/**
 *
 * @author admin
 */
public interface KategorijaDao {
    public List<Kategorija> getListaSvihKategorija();
    public Kategorija getKategorijaById(Integer id);
    public void dodajKategoriju(Kategorija kategorija);
    public void obrisiKategoriju(Integer id);
}
