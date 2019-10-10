
package com.petshop.bean;

import com.petshop.model.Autenticacao;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.catalina.User;
import org.primefaces.component.password.Password;


@Named("autenticar")
public class EfetuarAutenticacaoBean {
    
    @Inject
    private Autenticacao autenticacao;
    private String mensagem;
    private User user;
    
    
    
    public void executarAutenticacao(){
        String pass = "1234";
        mensagem = autenticacao.autenticar(user, pass);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    
    
}
