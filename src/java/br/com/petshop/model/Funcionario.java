package br.com.petshop.model;

public abstract class Funcionario {

    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    protected Double salario;
    
    public abstract Double bonificacao();
//    public abstract Double bonificacao(Double valor);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}