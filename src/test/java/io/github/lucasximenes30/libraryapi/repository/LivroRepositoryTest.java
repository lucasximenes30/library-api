package io.github.lucasximenes30.libraryapi.repository;

import io.github.lucasximenes30.libraryapi.model.Autor;
import io.github.lucasximenes30.libraryapi.model.GeneroLivro;
import io.github.lucasximenes30.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvar(){

        Livro livro = new Livro();

        livro.setIsbn("126516351736");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1990,1,2));

        Autor autor = autorRepository
                .findById(UUID.fromString("b8b534f8-e294-4287-adc3-cf944ac4e393"))
                .orElse(null);
        livro.setAutor(autor);

        livroRepository.save(livro);

    }

}