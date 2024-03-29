package org.example.model;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tbl_clinica") //define o nome da tabela que sera criada no banco de dados
public class Clinica implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false, length = 150) //define o tamanho da coluna
    @NotBlank (message = "Nome da Clínica é uma informação obrigatória")
    private String nome;

    @Column(nullable = false, length = 150) //define o tamanho da coluna
    @NotBlank (message = "Telefone da Clínica é uma informação obrigatória")
    private String telefone;

    @Column(nullable = false, length = 150) //define o tamanho da coluna
    @NotBlank (message = "E-mail da Clínica é uma informação obrigatória")
    private String email;

    @Column(nullable = false, length = 150) //define o tamanho da coluna
    @NotBlank (message = "Especialidade da Clínica é uma informação obrigatória")
    private String especialidade;



    @OneToOne (cascade=CascadeType.PERSIST)
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


}


