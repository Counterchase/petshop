package br.com.petshop.service;

import br.com.petshop.model.Funcionario;
import br.com.petshop.repository.Funcionarios;
import br.com.petshop.util.Transacional;
import javax.inject.Inject;

public class FuncionarioService {
    @Inject
    private Funcionarios funcionarios;
    
    @Transacional
    public void salvar(Funcionario funcionario){
        funcionarios.salvar(funcionario);
    }
    
    @Transacional
    public void excluir(Funcionario funcionario){
        funcionarios.excluir(funcionario);
    }
    
}
