package br.com.bibliotecadoceleitura;

import br.com.bibliotecadoceleitura.domain.*;
import br.com.bibliotecadoceleitura.application.services.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultaTest {
    @Test
    void calculaMultaAtraso2Dias(){
        Emprestimo e = new Emprestimo();
        e.setDataPrevistaDevolucao(LocalDate.now().minusDays(2));
        Livro l = new Livro(); e.setLivro(l);
        Devolucao d = new Devolucao();
        d.setEmprestimo(e);
        d.setDataDevolucao(LocalDate.now());
        d.calcularMulta(new PoliticaMultaPadrao().taxaPorDia());
        assertEquals(2, d.getQtdeDiasAtraso());
        assertEquals(2.0, d.getValorMulta(), 0.0001);
    }
}
