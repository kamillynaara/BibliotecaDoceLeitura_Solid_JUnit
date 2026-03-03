package br.com.bibliotecadoceleitura.application.ports;

import br.com.bibliotecadoceleitura.domain.Livro;
import java.util.*;

public interface LivroRepository {
    Livro save(Livro l);
    Optional<Livro> findById(Integer id);
    List<Livro> findAll();
}
