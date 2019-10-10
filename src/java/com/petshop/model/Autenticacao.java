
package com.petshop.model;

import javax.enterprise.context.Dependent;
import org.apache.catalina.User;
import org.primefaces.component.password.Password;

@Dependent
public class Autenticacao {
    
    
    public String autenticar(User user, String pass){
        return "Bem Vindo: "+ user;
    }
}
