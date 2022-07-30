package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.request.AvaliacaoFisicaRequest;
import me.dio.academia.digital.entity.response.AvaliacaoFisicaResponse;
import me.dio.academia.digital.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<List<AvaliacaoFisicaResponse>> findByIdAluno(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByIdAluno(id));
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AvaliacaoFisicaResponse> create(@Valid @RequestBody AvaliacaoFisicaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }

}
