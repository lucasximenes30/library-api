package io.github.lucasximenes30.libraryapi.service;

import io.github.lucasximenes30.libraryapi.exceptions.OperacaoNaoPermetidaException;
import io.github.lucasximenes30.libraryapi.model.Autor;
import io.github.lucasximenes30.libraryapi.repository.AutorRepository;
import io.github.lucasximenes30.libraryapi.repository.LivroRepository;
import io.github.lucasximenes30.libraryapi.validator.AutorValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository repository;
    private final AutorValidator validator;
    private final LivroRepository livroRepository;

    public AutorService(AutorRepository repository, AutorValidator validator, LivroRepository livroRepository) {
        this.validator = validator;
        this.repository = repository;
        this.livroRepository = livroRepository;
    }

    public Autor salvar(Autor autor){
        validator.validar(autor);
        return repository.save(autor);
    }

    public void atualziar(Autor autor){
        if(autor.getId() == null){
            throw new IllegalArgumentException("O ID do autor não pode ser nulo para atualização.");
        }
            validator.validar(autor);
            repository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id){
        return repository.findById(id);
    }

    public void deletar(Autor autor){
        if (possuiLivro(autor)){
            throw new OperacaoNaoPermetidaException("Não é permetido excluir o autor que possui livros cadastrados!");
        }
        repository.delete(autor);

    }

    public List<Autor> pesquisa(String nome, String nacionalidade){
        if (nome != null && nacionalidade != null){
            return repository.findByNomeAndNacionalidade(nome, nacionalidade);
        }

        if(nome != null){
            return repository.findByNome(nome);
        }

        if(nacionalidade != null){
            return repository.findByNacionalidade(nacionalidade);
        }

        return repository.findAll();
    }

    public boolean possuiLivro(Autor autor){
        return livroRepository.existsByAutor(autor);
    }
}
