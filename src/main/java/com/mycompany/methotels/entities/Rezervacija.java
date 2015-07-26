/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

/*
Kreiranje tabele

create table REZERVACIJA
(
   ID                   int not null auto_increment,
   KLIJ_ID              int,
   SOBA_ID              int,
   POCETAK              date not null,
   KRAJ                 date not null,
   OSNOVNA_CENA         decimal(10,2) not null,
   primary key (ID)
);

alter table REZERVACIJA add constraint FK_KLIJENT_REZERVACIJA foreign key (KLIJ_ID)
      references KLIJENT (ID) on delete restrict on update restrict;

alter table REZERVACIJA add constraint FK_SOBA_REZERVACIJA foreign key (SOBA_ID)
      references SOBA (ID) on delete restrict on update restrict;

*/

/**
 *
 * @author admin
 */
@Entity
@Table(name = "rezervacija")
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")})
public class Rezervacija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "POCETAK")
    @Validate("required")
    @Temporal(TemporalType.DATE)
    private Date pocetak;
    @Basic(optional = false)
    @Column(name = "KRAJ")
    @Validate("required")
    @Temporal(TemporalType.DATE)
    private Date kraj;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "OSNOVNA_CENA")
    @Validate("required")
    private BigDecimal osnovnaCena;
    @JoinColumn(name = "SOBA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Soba sobaId;
    @JoinColumn(name = "KLIJ_ID", referencedColumnName = "ID")
    @ManyToOne
    private Klijent klijId;

    @Inject
    public Rezervacija() {
    }

    public Rezervacija(Integer id) {
        this.id = id;
    }

    public Rezervacija(Integer id, Date pocetak, Date kraj, BigDecimal osnovnaCena) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.osnovnaCena = osnovnaCena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public BigDecimal getOsnovnaCena() {
        return osnovnaCena;
    }

    public void setOsnovnaCena(BigDecimal osnovnaCena) {
        this.osnovnaCena = osnovnaCena;
    }

    public Soba getSobaId() {
        return sobaId;
    }

    public void setSobaId(Soba sobaId) {
        this.sobaId = sobaId;
    }

    public Klijent getKlijId() {
        return klijId;
    }

    public void setKlijId(Klijent klijId) {
        this.klijId = klijId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Rezervacija[ id=" + id + " ]";
    }
    
}
