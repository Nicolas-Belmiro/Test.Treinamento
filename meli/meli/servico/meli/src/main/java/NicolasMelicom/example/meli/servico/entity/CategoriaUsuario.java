package NicolasMelicom.example.meli.servico.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CategoriaUsuario {
//id, user_id, item_description, item_quantity, item_price, total_value, created_at, updated_at
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private long quantidadeItens;

    @Column(nullable = false)
    private long preco;

    @Column(nullable = false)
    private long valortotal;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    @Column(nullable = false)
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public long getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(long quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public long getPreco() {
        return preco;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }

    public long getValortotal() {
        return valortotal;
    }

    public void setValortotal(long valortotal) {
        this.valortotal = valortotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}