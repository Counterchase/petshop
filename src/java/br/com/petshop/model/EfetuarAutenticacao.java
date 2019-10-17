package br.com.petshop.model;

public abstract interface EfetuarAutenticacao {
    public Boolean autenticar(String user, String senha); 
}
