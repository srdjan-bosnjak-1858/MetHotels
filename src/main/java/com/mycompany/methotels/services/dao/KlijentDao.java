/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services.dao;

import com.mycompany.methotels.entities.Klijent;
import java.util.List;

/**
 *
 * @author admin
 */
public interface KlijentDao {
    public List<Klijent> getListaSvihKlijenata();
    public Klijent getKlijentaById(Integer id);
    public void dodajKlijenta(Klijent klijent);
    public void obrisiKlijenta(Integer id);
}
