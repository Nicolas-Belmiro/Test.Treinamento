package NicolasMelicom.example.meli.servico.entity;

import java.time.LocalDate;

public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;
  //  id, user_id, item_description, item_quantity, item_price, total_value, created_at, updated_at //

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}