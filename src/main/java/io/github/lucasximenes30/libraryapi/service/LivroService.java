package io.github.lucasximenes30.libraryapi.service;


import io.github.lucasximenes30.libraryapi.model.GeneroLivro;
import io.github.lucasximenes30.libraryapi.model.Livro;
import io.github.lucasximenes30.libraryapi.repository.LivroRepository;
import io.github.lucasximenes30.libraryapi.repository.specs.LivroSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> obterPorId(UUID id){
        return livroRepository.findById(id);
    }

    public void deletar(Livro livro){
        livroRepository.delete(livro);
    }

    public List<Livro> pesquisa(
            String isbn,
            String titulo,
            String nomeAutor,
            GeneroLivro genero,
            Integer anoPublicacao
    ) {

        Specification<Livro> specs = null;

        if (isbn != null) {
            specs = specs == null
                    ? LivroSpecs.isbnEqual(isbn)
                    : specs.and(LivroSpecs.isbnEqual(isbn));
        }

        if (titulo != null) {
            specs = specs == null
                    ? LivroSpecs.tituloLike(titulo)
                    : specs.and(LivroSpecs.tituloLike(titulo));
        }

        if (genero != null) {
            specs = specs == null
                    ? LivroSpecs.generoEquals(genero)
                    : specs.and(LivroSpecs.generoEquals(genero));
        }

        return livroRepository.findAll(specs);
    }

}
