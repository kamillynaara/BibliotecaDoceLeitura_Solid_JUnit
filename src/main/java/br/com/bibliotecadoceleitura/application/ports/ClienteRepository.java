package br.com.bibliotecadoceleitura.application.ports;

import br.com.bibliotecadoceleitura.domain.Cliente;
import java.util.*;

public interface ClienteRepository {
    Cliente save(Cliente c);
    Optional<Cliente> findById(Integer id);
    List<Cliente> findAll();
}
