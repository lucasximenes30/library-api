package io.github.lucasximenes30.libraryapi.controller.mappers;

import io.github.lucasximenes30.libraryapi.dto.CadastriLivroDTO;
import io.github.lucasximenes30.libraryapi.model.Livro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T14:39:50-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class LivroMapperImpl extends LivroMapper {

    @Override
    public Livro toEntity(CadastriLivroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Livro livro = new Livro();

        livro.setIsbn( dto.isbn() );
        livro.setTitulo( dto.titulo() );
        livro.setDataPublicacao( dto.dataPublicacao() );
        livro.setGenero( dto.genero() );
        livro.setPreco( dto.preco() );

        livro.setAutor( autorRepository.findById(dto.idAutor()).orElse(null) );

        return livro;
    }
}
