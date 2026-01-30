package io.github.lucasximenes30.libraryapi.controller.mappers;

import io.github.lucasximenes30.libraryapi.dto.AutorDTO;
import io.github.lucasximenes30.libraryapi.dto.CadastriLivroDTO;
import io.github.lucasximenes30.libraryapi.dto.ResultadoPesquisaLivroDTO;
import io.github.lucasximenes30.libraryapi.model.GeneroLivro;
import io.github.lucasximenes30.libraryapi.model.Livro;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-30T10:38:48-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class LivroMapperImpl extends LivroMapper {

    @Autowired
    private AutorMapper autorMapper;

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

    @Override
    public ResultadoPesquisaLivroDTO toDTO(Livro livro) {
        if ( livro == null ) {
            return null;
        }

        UUID id = null;
        String isbn = null;
        String titulo = null;
        LocalDate dataPublicacao = null;
        GeneroLivro genero = null;
        BigDecimal preco = null;
        AutorDTO autor = null;

        id = livro.getId();
        isbn = livro.getIsbn();
        titulo = livro.getTitulo();
        dataPublicacao = livro.getDataPublicacao();
        genero = livro.getGenero();
        preco = livro.getPreco();
        autor = autorMapper.toDTO( livro.getAutor() );

        ResultadoPesquisaLivroDTO resultadoPesquisaLivroDTO = new ResultadoPesquisaLivroDTO( id, isbn, titulo, dataPublicacao, genero, preco, autor );

        return resultadoPesquisaLivroDTO;
    }
}
