package br.com.bibliotecadoceleitura.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Devolucao {
    private Integer id;
    private Emprestimo emprestimo;
    private LocalDate dataDevolucao;
    private int qtdeDiasAtraso;
    private double valorMulta;

    public Integer getId() { return id; }
    public Emprestimo getEmprestimo() { return emprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public int getQtdeDiasAtraso() { return qtdeDiasAtraso; }
    public double getValorMulta() { return valorMulta; }

    public void setId(Integer id) { this.id = id; }
    public void setEmprestimo(Emprestimo emprestimo) { this.emprestimo = emprestimo; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public void calcularMulta(double taxaPorDia) {
        long atraso = ChronoUnit.DAYS.between(emprestimo.getDataPrevistaDevolucao(), dataDevolucao);
        this.qtdeDiasAtraso = (int)Math.max(0, atraso);
        this.valorMulta = this.qtdeDiasAtraso * taxaPorDia;
    }
}
