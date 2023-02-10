package io.github.diegowenndson.mscliente.domain;

import jakarta.persistence.Id;

public class Cliente {
    @Id
    private long id;
    private String cpf;
    private String nome;
    private  Integer idade;
}
