package io.github.lucasximenes30.libraryapi.repository.specs;

import io.github.lucasximenes30.libraryapi.model.GeneroLivro;
import io.github.lucasximenes30.libraryapi.model.Livro;
import org.springframework.data.jpa.domain.Specification;

public class LivroSpecs {

    public static Specification<Livro> isbnEqual(String isbn){

        return (root,
                query,
                cb)
                -> cb.equal(root.get("isbn"), isbn);
    }

    public static Specification<Livro> tituloLike(String titulo){
        return (root,
                query,
                cb)
                -> cb.like( cb.upper(root.get("titulo")), "%"+  titulo.toUpperCase()+ "%");
    }

    public static Specification<Livro> generoEquals(GeneroLivro genero){

        return (root,
                query,
                cb)
                -> cb.equal(root.get("genero"), genero);

    }
}
