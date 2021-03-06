/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
@ProtectedPage
@RolesAllowed(value={"Admin","Sluzbenik"})
public class DodavanjeSobe {
    
    @Property
    private Soba soba;
    @Inject
    private Session session;
    @Property
    private ArrayList<Soba> sobe;
    
    void onActivate() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
        sobe=(ArrayList<Soba>) session.createCriteria(Soba.class).list();
    }
    @CommitAfter
    Object onSuccess() {
        // upis u bazu
        session.persist(soba);
        return this;
    }    
}
