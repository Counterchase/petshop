package br.com.petshop.bean;

import br.com.petshop.model.Autenticacao;
import javax.inject.Inject;
import javax.inject.Named;

@Named("autenticar")
public class EfetuarAutenticacaoBean {

    @Inject
    private Autenticacao autenticacao;
    private String usuario, senha;
    private String mensagem;

    public void executarAutenticacao() {
        mensagem = autenticacao.autenticar("admin", "admin");
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
