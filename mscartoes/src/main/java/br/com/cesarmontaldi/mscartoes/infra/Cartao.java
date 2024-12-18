package br.com.cesarmontaldi.mscartoes.infra;

import br.com.cesarmontaldi.mscartoes.application.representation.DadosCadastroCartao;
import br.com.cesarmontaldi.mscartoes.domain.BandeiraCartao;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cartoes")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao() {

    }

    public Cartao(DadosCadastroCartao dadosCartao) {
        this.nome = dadosCartao.nome();
        this.bandeira = dadosCartao.bandeira();
        this.renda = dadosCartao.renda();
        this.limiteBasico = dadosCartao.limiteBasico();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public BigDecimal getLimiteBasico() {
        return limiteBasico;
    }

    public void setLimiteBasico(BigDecimal limiteBasico) {
        this.limiteBasico = limiteBasico;
    }
}
