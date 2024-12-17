package br.com.cesarmontaldi.msclientes.infra;

import br.com.cesarmontaldi.msclientes.application.DadosCadastroCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;

    public Cliente() {
    }

    public Cliente(DadosCadastroCliente dadosCliente) {
        this.nome = dadosCliente.nome();
        this.cpf = dadosCliente.cpf();
        this.idade = dadosCliente.idade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdade() {
        return idade;
    }
}
