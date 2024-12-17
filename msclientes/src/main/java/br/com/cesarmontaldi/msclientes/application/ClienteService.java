package br.com.cesarmontaldi.msclientes.application;

import br.com.cesarmontaldi.msclientes.infra.Cliente;
import br.com.cesarmontaldi.msclientes.infra.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(DadosCadastroCliente dadosCliente) {
        return repository.save(new Cliente(dadosCliente));
    }

    public Cliente getByCPF(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

}