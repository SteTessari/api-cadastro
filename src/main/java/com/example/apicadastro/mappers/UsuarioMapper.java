package com.example.apicadastro.mappers;

import com.example.apicadastro.dto.UsuarioDTO;
import com.example.apicadastro.model.Usuario;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toObject(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Usuario updateObjectFromDTO(UsuarioDTO usuarioDTO, @MappingTarget Usuario usuario);

}
