package com.gerenciador.clientes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author doareis@gmail.com
 * @since Dezembro 2018
 */
public enum Risco {

    A("A", 0.0), B("B", 0.1), C("C", 0.2);

    String descricao;
    Double taxa;

    Risco(String descricao, Double taxa) {
        this.descricao = descricao;
        this.taxa = taxa;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonProperty(value="taxa")
    public Double getTaxa() {
        return taxa;
    }
}
