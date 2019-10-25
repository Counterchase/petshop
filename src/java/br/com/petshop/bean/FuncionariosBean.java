package br.com.petshop.bean;

import br.com.petshop.model.Funcionario;
import br.com.petshop.repository.Funcionarios;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class FuncionariosBean {
    @Inject
    private Funcionarios funcionarios;
    private List<Funcionario> listaDeFuncionarios;
    
    public void todosOsFuncionarios(){
        listaDeFuncionarios = funcionarios.pesquisarTodos();
    }
    
    public List<Funcionario> getListaDeFuncionarios(){
        return listaDeFuncionarios;
    }
}
