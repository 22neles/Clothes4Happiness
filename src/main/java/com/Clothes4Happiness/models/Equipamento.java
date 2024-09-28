package com.Clothes4Happiness.models;

import jakarta.persistence.*;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;
    private String situacao; // Exemplos: "Disponível", "Em Uso", "Em Manutenção"

    @ManyToOne // Um equipamento pode estar vinculado a um usuário
    @JoinColumn(name = "usuario_id") // Coluna que armazenará o ID do usuário
    private Usuario usuario;

    public Equipamento() {}

    public Equipamento(int id, String descricao, String situacao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.situacao = situacao;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
