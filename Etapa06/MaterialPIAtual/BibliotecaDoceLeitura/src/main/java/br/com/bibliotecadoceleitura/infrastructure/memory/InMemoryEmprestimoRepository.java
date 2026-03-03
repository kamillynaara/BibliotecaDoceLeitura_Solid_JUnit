package br.com.bibliotecadoceleitura.infrastructure.memory;

import br.com.bibliotecadoceleitura.application.ports.EmprestimoRepository;
import br.com.bibliotecadoceleitura.domain.Emprestimo;
import java.util.*;

public class InMemoryEmprestimoRepository implements EmprestimoRepository {
    private final Map<Integer, Emprestimo> db = new HashMap<>();
    private int seq = 1;

    public Emprestimo save(Emprestimo e){
        if(e.getId()==null){ e.setId(seq++); }
        db.put(e.getId(), e);
        return e;
    }
    public Optional<Emprestimo> findById(Integer id){ return Optional.ofNullable(db.get(id)); }
    public List<Emprestimo> findAtivos(){
        List<Emprestimo> out = new ArrayList<>();
        for(Emprestimo e: db.values()){
            if(e.getStatusVigor()==Emprestimo.StatusVigor.ATIVO) out.add(e);
        }
        return out;
    }
}
