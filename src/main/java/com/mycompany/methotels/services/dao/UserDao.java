/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services.dao;

import com.mycompany.methotels.entities.User;

/**
 *
 * @author admin
 */
public interface UserDao {

    public User checkUser(String email, String password);

    public User registerUser(User user);

    public boolean checkIfEmailExists(String email);

}
