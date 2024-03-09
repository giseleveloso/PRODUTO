package br.unitins.topicos1.model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 60, nullable = false)
    private String pessoa;

    @Column(length = 100, nullable = false)
    private String endereco;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(length = 60, nullable = false)
    private String email;

    @Column(length = 60)
    private String inf;

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

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    

}