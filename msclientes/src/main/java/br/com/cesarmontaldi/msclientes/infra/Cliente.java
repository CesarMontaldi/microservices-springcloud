package br.com.cesarmontaldi.msclientes.infra;

import br.com.cesarmontaldi.msclientes.application.DadosCadastroCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;


    public Cliente(DadosCadastroCliente dadosCliente) {
        this.nome = dadosCliente.nome();
        this.cpf = dadosCliente.cpf();
        this.idade = dadosCliente.idade();
    }
}
