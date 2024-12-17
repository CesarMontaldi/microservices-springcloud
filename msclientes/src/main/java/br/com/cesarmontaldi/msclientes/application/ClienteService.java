package br.com.cesarmontaldi.msclientes.application;

import br.com.cesarmontaldi.msclientes.infra.Cliente;
import br.com.cesarmontaldi.msclientes.infra.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    @Transactional
    public Cliente save(DadosCadastroCliente dadosCliente) {
        return repository.save(new Cliente(dadosCliente));
    }

    public Optional<Cliente> getByCPF(String cpf) {
        return repository.findByCpf(cpf);
    }

}