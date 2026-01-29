package io.github.lucasximenes30.libraryapi.dto;

import io.github.lucasximenes30.libraryapi.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastriLivroDTO(
        @NotBlank(message = "Campo obrigátorio")
        @ISBN
        String isbn,
        @NotBlank(message = "Campo obrigátorio")
        String titulo,
        @NotNull(message = "Campo obrigátorio")
        @Past(message = "Não pode ser uma data futura")
        LocalDate dataPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        @NotNull(message = "Campo obrigátorio")
        UUID idAutor) {
}
