package br.com.bibliotecadoceleitura;

import br.com.bibliotecadoceleitura.infrastructure.memory.InMemoryLivroRepository;
import br.com.bibliotecadoceleitura.infrastructure.memory.InMemoryEmprestimoRepository;
import br.com.bibliotecadoceleitura.infrastructure.memory.InMemoryDevolucaoRepository;
import br.com.bibliotecadoceleitura.domain.Livro;
import br.com.bibliotecadoceleitura.domain.Cliente;
import br.com.bibliotecadoceleitura.domain.Emprestimo;
import br.com.bibliotecadoceleitura.application.services.EmprestimoService;
import br.com.bibliotecadoceleitura.application.services.PoliticaMultaPadrao;
import br.com.bibliotecadoceleitura.application.services.DevolucaoService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        var repoLivros = new InMemoryLivroRepository();
        var repoEmps = new InMemoryEmprestimoRepository();
        var repoDevs = new InMemoryDevolucaoRepository();

        var emprestimoService = new EmprestimoService(repoEmps, repoLivros);
        var devolucaoService = new DevolucaoService(repoDevs, repoEmps, repoLivros, new PoliticaMultaPadrao());

        // Arrange
        var l = new Livro(); l.setTitulo("O Labirinto de Aurora");
        repoLivros.save(l);
        var c = new Cliente(); c.setNome("Cliente Teste");
        var e = new Emprestimo(); e.setLivro(l); e.setCliente(c); e.setDataPrevistaDevolucao(LocalDate.now().minusDays(2));

        // Registrar empréstimo
        e = emprestimoService.registrar(e);
        // Assert simples no main (demonstração)
        if(l.getStatusDisponibilidade() != Livro.StatusDisponibilidade.EMPRESTADO) {
            throw new RuntimeException("Livro deveria estar EMPRESTADO após o registro do empréstimo");
        }

        // Act - registrar devolução com atraso de 2 dias
        var d = devolucaoService.registrarDevolucao(e, LocalDate.now());
        if(d.getQtdeDiasAtraso() != 2 || Math.abs(d.getValorMulta()-2.0) > 0.0001){
            throw new RuntimeException("Cálculo de multa incorreto");
        }

        System.out.println("Fluxo básico executado com sucesso.");
    }
}
