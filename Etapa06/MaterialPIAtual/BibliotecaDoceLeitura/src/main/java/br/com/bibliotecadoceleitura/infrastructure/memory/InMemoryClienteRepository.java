package br.com.bibliotecadoceleitura.infrastructure.memory;

import br.com.bibliotecadoceleitura.application.ports.ClienteRepository;
import br.com.bibliotecadoceleitura.domain.Cliente;
import java.util.*;

public class InMemoryClienteRepository implements ClienteRepository {
    private final Map<Integer, Cliente> db = new HashMap<>();
    private int seq = 1;

    public Cliente save(Cliente c){
        if(c.getId()==null){ c.setId(seq++); }
        db.put(c.getId(), c);
        return c;
    }
    public Optional<Cliente> findById(Integer id){ return Optional.ofNullable(db.get(id)); }
    public List<Cliente> findAll(){ return new ArrayList<>(db.values()); }
}
