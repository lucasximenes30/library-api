package io.github.lucasximenes30.libraryapi.repository;

import io.github.lucasximenes30.libraryapi.model.Autor;
import io.github.lucasximenes30.libraryapi.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID>, JpaSpecificationExecutor<Livro> {
    boolean existsByAutor(Autor autor);

    Page<Livro> findByAutor(Autor autor, Pageable pageable);

    Optional<Livro> findByIsbn(String isbn);
}
