package br.com.bibliotecadoceleitura.application.ports;

import br.com.bibliotecadoceleitura.domain.Devolucao;
import java.util.*;

public interface DevolucaoRepository {
    Devolucao save(Devolucao d);
    List<Devolucao> findAll();
}
