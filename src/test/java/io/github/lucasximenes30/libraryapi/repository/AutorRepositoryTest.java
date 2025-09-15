package io.github.lucasximenes30.libraryapi.repository;

import io.github.lucasximenes30.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    public AutorRepository autorRepository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("brasileira");
        autor.setDataNascimento(LocalDate.of(2000,4,25));

        var autorSalvo = autorRepository.save(autor);
        System.out.println("autor salvo" + autorSalvo);
    }

    @Test
    public void atualizarTest(){
        var id = UUID.fromString("da9ca126-74b1-42e9-adea-3c55f26815a3");

        Optional<Autor> possivelAutor = autorRepository.findById(id);

        if (possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 2));

            autorRepository.save(autorEncontrado);
        }

    }

    @Test
    public void listarAutor(){
        List<Autor> lista = autorRepository.findAll();
        lista.forEach(System.out::println);
    }
    @Test
    public void count(){
        System.out.println("Contagem de autores: "+autorRepository.count());
    }

    @Test
    public void deletePorIdTest(){
        var id = UUID.fromString("da9ca126-74b1-42e9-adea-3c55f26815a3");
        autorRepository.deleteById(id);
    }

    @Test
    public void deleteTest(){
        var id = UUID.fromString("b393e1e8-1318-4942-bf1a-5244a95d526e");
        var maria = autorRepository.findById(id).get();
        autorRepository.delete(maria);
    }
}
