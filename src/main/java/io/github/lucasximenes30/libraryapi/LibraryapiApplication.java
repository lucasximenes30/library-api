package io.github.lucasximenes30.libraryapi;

import io.github.lucasximenes30.libraryapi.model.Autor;
import io.github.lucasximenes30.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(LibraryapiApplication.class, args);
        AutorRepository repository = context.getBean(AutorRepository.class);
        exemplosSalvarRegistro(repository);

	}

    public static void exemplosSalvarRegistro(AutorRepository autorRepository){
        Autor autor = new Autor();
        autor.setNome("Lucas");
        autor.setNacionalidade("brasileiro");
        autor.setDataNascimento(LocalDate.of(2006,4,25));

        var autorSalvo = autorRepository.save(autor);
        System.out.println("autor salvo" + autorSalvo);
    }
}
