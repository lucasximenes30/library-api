package io.github.lucasximenes30.libraryapi.controller.mappers;

import io.github.lucasximenes30.libraryapi.dto.CadastriLivroDTO;
import io.github.lucasximenes30.libraryapi.model.Livro;
import io.github.lucasximenes30.libraryapi.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LivroMapper {

    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null) )")
    public abstract Livro toEntity(CadastriLivroDTO dto);
}
