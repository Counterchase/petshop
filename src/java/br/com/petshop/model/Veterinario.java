package br.com.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "veterinario")
public class Veterinario extends Funcionario implements EfetuarAutenticacao{
    
  
    private String usuario;
    private String senha;
    
    //    REGRAS DE NEGÓCIO
    @Override
    public Boolean autenticar(String user, String pass){
        if (this.usuario == user && this.senha == pass) {
            System.out.println("Bem Vindo!!!");
        }
        return true;
    }

    @Override
    public Double bonificacao() {
        return this.salario * 0.5;
    }
}
