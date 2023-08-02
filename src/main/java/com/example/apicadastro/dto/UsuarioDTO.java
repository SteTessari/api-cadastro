package com.example.apicadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO implements Serializable {
    private String nome;
    private String email;
    private String senha;
    private String telelfone;
    private String cpf;
}
