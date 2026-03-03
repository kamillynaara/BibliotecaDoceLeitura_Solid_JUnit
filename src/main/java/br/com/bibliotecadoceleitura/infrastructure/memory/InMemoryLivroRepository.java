package br.com.bibliotecadoceleitura.infrastructure.memory;

import br.com.bibliotecadoceleitura.application.ports.LivroRepository;
import br.com.bibliotecadoceleitura.domain.Livro;
import java.util.*;

public class InMemoryLivroRepository implements LivroRepository {
    private final Map<Integer, Livro> db = new HashMap<>();
    private int seq = 1;

    public Livro save(Livro l){
        if(l.getId()==null){ l.setId(seq++); }
        db.put(l.getId(), l);
        return l;
    }
    public Optional<Livro> findById(Integer id){ return Optional.ofNullable(db.get(id)); }
    public List<Livro> findAll(){ return new ArrayList<>(db.values()); }
}
