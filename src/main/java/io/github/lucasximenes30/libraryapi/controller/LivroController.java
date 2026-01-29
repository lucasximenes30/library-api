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
public class LivroController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastriLivroDTO dto){
        try{
            Livro livro = mapper.toEntity(dto);
            service.salvar(livro);

            return ResponseEntity.ok(livro);

        }catch (RegistroDuplicadoException e ){
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }
}
