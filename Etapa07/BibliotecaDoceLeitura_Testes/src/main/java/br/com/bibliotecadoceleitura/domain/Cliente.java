package br.com.bibliotecadoceleitura.domain;

public class Cliente {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private StatusAcesso statusAcesso = StatusAcesso.HABILITADO;

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public StatusAcesso getStatusAcesso() { return statusAcesso; }

    public void setId(Integer id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setStatusAcesso(StatusAcesso statusAcesso) { this.statusAcesso = statusAcesso; }

    public enum StatusAcesso { HABILITADO, BLOQUEADO }
}
