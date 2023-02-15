package io.github.diegowenndson.mscartoes.application.representation;

import io.github.diegowenndson.mscartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCartaoResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limite;

    public static ClienteCartaoResponse fromModel(ClienteCartao model){
        return new ClienteCartaoResponse(
            model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }
}
