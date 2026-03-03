package br.com.bibliotecadoceleitura.application.services;

import br.com.bibliotecadoceleitura.domain.Livro;
import br.com.bibliotecadoceleitura.domain.Emprestimo;
import br.com.bibliotecadoceleitura.application.ports.LivroRepository;
import br.com.bibliotecadoceleitura.application.ports.EmprestimoRepository;

public class EmprestimoService {
    private final EmprestimoRepository emprestimos;
    private final LivroRepository livros;

    public EmprestimoService(EmprestimoRepository emprestimos, LivroRepository livros){
        this.emprestimos = emprestimos;
        this.livros = livros;
    }

    public Emprestimo registrar(Emprestimo e){
        // Regra simples: marcar livro como emprestado
        Livro l = e.getLivro();
        l.setStatusDisponibilidade(Livro.StatusDisponibilidade.EMPRESTADO);
        livros.save(l);
        return emprestimos.save(e);
    }
}
