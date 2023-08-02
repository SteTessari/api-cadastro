package com.example.apicadastro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"NOME", "CPF"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SENHA", nullable = false)
    @ColumnTransformer(write = "crypt(?, gen_salt('bf'))")
    private String senha;

    @Column(name = "TELEFONE", nullable = false)
    private String telelfone;

    @Column(name = "CPF", nullable = false)
    private String cpf;
}
