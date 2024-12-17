package br.com.cesarmontaldi.msclientes.application;

import br.com.cesarmontaldi.msclientes.infra.Cliente;

public record DadosCliente(Long id, String nome, String cpf, Integer idade) {

    public DadosCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getIdade());
    }
}
