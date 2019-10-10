
package com.petshop.model;

import org.apache.catalina.User;
import org.primefaces.component.password.Password;


public interface EfetuarAutenticacao {
    
    public boolean autenticar(User user, Password pass);
    
    
}
