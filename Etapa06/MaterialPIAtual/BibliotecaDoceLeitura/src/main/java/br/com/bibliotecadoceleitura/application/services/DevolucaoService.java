package br.com.bibliotecadoceleitura.application.services;

import br.com.bibliotecadoceleitura.domain.Livro;
import br.com.bibliotecadoceleitura.domain.Emprestimo;
import br.com.bibliotecadoceleitura.domain.Devolucao;
import br.com.bibliotecadoceleitura.application.ports.DevolucaoRepository;
import br.com.bibliotecadoceleitura.application.ports.LivroRepository;
import br.com.bibliotecadoceleitura.application.ports.EmprestimoRepository;
import java.time.LocalDate;

public class DevolucaoService {
    private final DevolucaoRepository devolucoes;
    private final EmprestimoRepository emprestimos;
    private final LivroRepository livros;
    private final PoliticaMulta politica;

    public DevolucaoService(DevolucaoRepository d, EmprestimoRepository e, LivroRepository l, PoliticaMulta p){
        this.devolucoes = d; this.emprestimos = e; this.livros = l; this.politica = p;
    }

    public Devolucao registrarDevolucao(Emprestimo emp, LocalDate data){
        Devolucao d = new Devolucao();
        d.setEmprestimo(emp);
        d.setDataDevolucao(data);
        d.calcularMulta(politica.taxaPorDia());
        // Atualiza estado
        emp.setStatusVigor(Emprestimo.StatusVigor.INATIVO);
        Livro l = emp.getLivro();
        l.setStatusDisponibilidade(Livro.StatusDisponibilidade.DISPONIVEL);
        livros.save(l);
        emprestimos.save(emp);
        return devolucoes.save(d);
    }
}
