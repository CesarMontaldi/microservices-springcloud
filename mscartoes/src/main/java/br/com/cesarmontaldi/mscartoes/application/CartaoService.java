package br.com.cesarmontaldi.mscartoes.application;

import br.com.cesarmontaldi.mscartoes.application.representation.DadosCadastroCartao;
import br.com.cesarmontaldi.mscartoes.application.representation.DadosCartao;
import br.com.cesarmontaldi.mscartoes.infra.cartao.Cartao;
import br.com.cesarmontaldi.mscartoes.infra.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository repository;

    @Transactional
    public Cartao save(DadosCadastroCartao dadosCartao) {
        return repository.save(new Cartao(dadosCartao));
    }

    public List<DadosCartao> getCartoesRendaMenorIgual(Long renda) {
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        List<Cartao> cartoes = repository.findByRendaLessThanEqual(rendaBigDecimal);

        return cartoes.stream()
                .map(DadosCartao::new)
                .toList();
    }

}
