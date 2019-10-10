/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.model;

import org.apache.catalina.User;
import org.primefaces.component.password.Password;

/**
 *
 * @author Estudante
 */
public class Atendente  extends Funcionario implements EfetuarAutenticacao{

    @Override
    public double bonificacao() {
        return this.salario * 0.1;
    }

    @Override
    public boolean autenticar(User user, Password pass) {
    
        return true;
    }
    
}
