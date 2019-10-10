/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.catalina.User;
import org.primefaces.component.password.Password;

/**
 *
 * @author Estudante
 */
public class Veterinario extends Funcionario implements EfetuarAutenticacao{
    
    private String CFMV;
    private User usuario;
    private Password senha;

    // regras de negocfio 
    public boolean autenticar(User user, Password pass) {
        if (this.usuario == user && this.senha == pass) {
            System.out.println("Bem Vindo");
        }
        return true;
    }

    @Override
    public double bonificacao() {
        return this.salario * 0.1;
    }

    /* @Override
    public double bonificacao(double valor) {
       return this.salario * (valor / 100);
    }*/
}
