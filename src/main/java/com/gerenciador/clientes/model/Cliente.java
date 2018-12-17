package com.gerenciador.clientes.model;

import com.gerenciador.clientes.dto.ClienteDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author doareis@gmail.com
 * @since Dezembro 2018
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "limite_credito", nullable = false)
    private Double limiteCredito;

    @Enumerated(EnumType.STRING)
    @Column(name = "risco")
    private Risco risco;

    public Cliente() {
    }

    public Cliente(String nome, Double limiteCredito, Risco risco) {
        this.nome = nome;
        this.limiteCredito = limiteCredito;
        this.risco = risco;
    }

    public Long getId() {
        return id;
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

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

}
