package br.com.petshop.bean;

import br.com.petshop.model.Autenticacao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("autenticar")
public class EfetuarAutenticacaoBean {

    @Inject
    private Autenticacao autenticacao;
    private String usuario, senha;
    private String mensagem;
    
    public void executarChamada(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EfetuarAutenticacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void executarAutenticacao() {
        System.out.println("Usuario..:" +this.usuario);
        System.out.println("Senha..:" +this.senha);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acesso Autorizado!"));
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
