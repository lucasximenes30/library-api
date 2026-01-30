package io.github.lucasximenes30.libraryapi.controller;

import io.github.lucasximenes30.libraryapi.controller.mappers.LivroMapper;
import io.github.lucasximenes30.libraryapi.dto.CadastriLivroDTO;
import io.github.lucasximenes30.libraryapi.dto.ErroResposta;
import io.github.lucasximenes30.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.lucasximenes30.libraryapi.model.Livro;
import io.github.lucasximenes30.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController implements GenericController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid CadastriLivroDTO dto) {
        Livro livro = mapper.toEntity(dto);
        service.salvar(livro);

        var url = gerarHeaderLocation(livro.getId());
        return ResponseEntity.created(url).build();


    }
}

