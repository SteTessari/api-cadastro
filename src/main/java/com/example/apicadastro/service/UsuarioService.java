package com.example.apicadastro.service;

import com.example.apicadastro.dto.UsuarioDTO;
import com.example.apicadastro.exceptions.UsuarioException;
import com.example.apicadastro.mappers.UsuarioMapper;
import com.example.apicadastro.model.Usuario;
import com.example.apicadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    public void inserir(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioMapper.toObject(usuarioDTO);
        tratativasAntesDeInserir(usuario);
        usuarioRepository.save(usuario);
    }
    public void tratativasAntesDeInserir(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(usuario.getCpf());

        if (usuarioOptional.isPresent())
            throw new UsuarioException(HttpStatus.NO_CONTENT, "Cpf já cadastrado.");

        Optional<Usuario> email = usuarioRepository.findByEmail(usuario.getEmail());

        if (email.isPresent())
            throw new UsuarioException(HttpStatus.NO_CONTENT, "Email já cadastrado.");
    }

    public void tratativasAntesDeAtualizar(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId());

        if (usuarioOptional.isPresent()){
            Usuario usuarioEncontrado = usuarioOptional.get();

            if (!usuarioEncontrado.getCpf().equals(usuario.getCpf()))
                throw new UsuarioException(HttpStatus.FORBIDDEN, "Cpf não pode ser alterado.");
        }
    }
}
