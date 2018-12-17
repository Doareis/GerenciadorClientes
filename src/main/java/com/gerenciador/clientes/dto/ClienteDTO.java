package com.gerenciador.clientes.dto;

import com.gerenciador.clientes.model.Risco;

import java.io.Serializable;

/**
 * @author doareis@gmail.com
 * @since Dezembro 2018
 */
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 3L;

    private Long id;
    private String nome;
    private Double limiteCredito;
    private String risco;
    private Double taxa;

    public ClienteDTO(Long id, String nome, Double limiteCredito, Risco risco) {
        this.id = id;
        this.nome = nome;
        this.limiteCredito = limiteCredito;
        this.risco = risco.getDescricao();
        this.taxa = risco.getTaxa();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }
}
