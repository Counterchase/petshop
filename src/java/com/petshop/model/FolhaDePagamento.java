/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.model;

/**
 *
 * @author Estudante
 */
public class FolhaDePagamento {
    private Double soma;
    
    public void registrarBonificacoes(Funcionario f){
        soma += f.bonificacao();
    }
}
