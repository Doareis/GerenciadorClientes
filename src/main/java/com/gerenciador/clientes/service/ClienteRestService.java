package com.gerenciador.clientes.service;

import com.gerenciador.clientes.dto.ClienteDTO;
import com.gerenciador.clientes.model.Cliente;
import com.gerenciador.clientes.model.Risco;
import com.gerenciador.clientes.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author doareis@gmail.com
 * @since Dezembro 2018
 */
@RestController
@RequestMapping(value = "/cliente")
public class ClienteRestService {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final Logger logger = LoggerFactory.getLogger(ClienteRestService.class);

    @RequestMapping(value = "/adiciona", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionaCliente(@RequestBody Cliente cliente) {
        logger.info("Adicionando cliente %s", cliente);
        this.clienteRepository.save(cliente);
    }

    @RequestMapping(value = "/busca/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscaCliente(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> buscaTodosClientes() {
        return clienteRepository.findAllAsDTO();
    }

    @RequestMapping(value = "/remove/{idCliente}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void removeCliente(@PathVariable("idCliente") Long idCliente) {
        logger.info("Removendo cliente (id = %d)", idCliente);
        clienteRepository.deleteById(idCliente);
    }
}
