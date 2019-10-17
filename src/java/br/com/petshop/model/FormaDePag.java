package br.com.petshop.model;

public class FormaDePag {
    private Double soma;
    
    public void registrarBonificacao(Funcionario f){
        soma += f.bonificacao();
    }
}