package io.github.diegowenndson.mscartoes.application;

import io.github.diegowenndson.mscartoes.application.Services.CartaoService;
import io.github.diegowenndson.mscartoes.application.Services.ClienteCartaoService;
import io.github.diegowenndson.mscartoes.application.representation.ClienteCartaoResponse;
import io.github.diegowenndson.mscartoes.domain.Cartao;
import io.github.diegowenndson.mscartoes.application.representation.CartaoSaveRequest;
import io.github.diegowenndson.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@Slf4j
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService service;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        log.info("Obtendo status do MS de cartões");
        return "OK"; }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        service.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> list = service.getCartaoRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClienteCartaoResponse>> getClienteCartaoPorCpf(
            @RequestParam("cpf") String cpf){
        List<ClienteCartao> lista = clienteCartaoService.listCartaoByCpf(cpf);
        List<ClienteCartaoResponse> resultList = lista.stream()
                .map(ClienteCartaoResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
