package br.com.petshop.model;

public class Atendente extends Funcionario implements EfetuarAutenticacao{

    @Override
    public Double bonificacao() {
        return this.salario * 0.1;
    }

    @Override
    public Boolean autenticar(String user, String senha) {
        return true;
    }
    
}
