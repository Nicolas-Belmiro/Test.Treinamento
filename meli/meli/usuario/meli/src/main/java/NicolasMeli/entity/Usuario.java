package NicolasMeli.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "data_register", nullable = false)
    private LocalDate data_register;

    @Column(name ="numerro_celuluar", nullable = false )
    private Long numero_celular;

    @Column(name = "atualizar_registro", nullable = false)
    private LocalDate atualizar_registro;
    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public Long getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(Long numero_celular) {
        this.numero_celular = numero_celular;
    }

    public LocalDate getAtualizar_registro() {
        return atualizar_registro;
    }

    public void setAtualizar_registro(LocalDate atualizar_registro) {
        this.atualizar_registro = atualizar_registro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_register() {
        return data_register;
    }

    public void setData_register(LocalDate data_register) {
        this.data_register = data_register;
    }
}