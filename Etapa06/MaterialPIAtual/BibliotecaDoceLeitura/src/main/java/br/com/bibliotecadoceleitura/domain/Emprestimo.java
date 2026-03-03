package br.com.bibliotecadoceleitura.domain;

import java.time.LocalDate;

public class Emprestimo {
    private Integer id;
    private Cliente cliente;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private StatusVigor statusVigor = StatusVigor.ATIVO;

    public Emprestimo() { this.dataEmprestimo = LocalDate.now(); }

    public Integer getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public StatusVigor getStatusVigor() { return statusVigor; }

    public void setId(Integer id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setLivro(Livro livro) { this.livro = livro; }
    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) { this.dataPrevistaDevolucao = dataPrevistaDevolucao; }
    public void setStatusVigor(StatusVigor statusVigor) { this.statusVigor = statusVigor; }

    public enum StatusVigor { ATIVO, INATIVO }
}
