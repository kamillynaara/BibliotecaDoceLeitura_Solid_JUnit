package br.com.bibliotecadoceleitura.infrastructure.memory;

import br.com.bibliotecadoceleitura.application.ports.DevolucaoRepository;
import br.com.bibliotecadoceleitura.domain.Devolucao;
import java.util.*;

public class InMemoryDevolucaoRepository implements DevolucaoRepository {
    private final Map<Integer, Devolucao> db = new HashMap<>();
    private int seq = 1;

    public Devolucao save(Devolucao d){
        try {
            java.lang.reflect.Field f = d.getClass().getDeclaredField("id");
            f.setAccessible(true);
            if(f.get(d)==null){ f.set(d, seq++); }
        } catch (Exception ignore) {}
        db.put(seq, d);
        return d;
    }
    public List<Devolucao> findAll(){ return new ArrayList<>(db.values()); }
}
