package br.com.bibliotecadoceleitura.application.ports;

import br.com.bibliotecadoceleitura.domain.Emprestimo;
import java.util.*;

public interface EmprestimoRepository {
    Emprestimo save(Emprestimo e);
    Optional<Emprestimo> findById(Integer id);
    List<Emprestimo> findAtivos();
}
