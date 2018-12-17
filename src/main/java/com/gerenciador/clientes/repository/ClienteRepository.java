package com.gerenciador.clientes.repository;

import com.gerenciador.clientes.dto.ClienteDTO;
import com.gerenciador.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author doareis@gmail.com
 * @since Dezembro 2018
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select new com.gerenciador.clientes.dto.ClienteDTO" +
            "(c.id, c.nome, c.limiteCredito, c.risco) " +
            "from Cliente c")
    List<ClienteDTO> findAllAsDTO();

    List<Cliente> findByNome(String nome);
}
