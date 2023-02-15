package io.github.diegowenndson.mscartoes.application.Services;

import io.github.diegowenndson.mscartoes.domain.ClienteCartao;
import io.github.diegowenndson.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartaoByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

}
