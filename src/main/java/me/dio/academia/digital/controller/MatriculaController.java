package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.request.MatriculaRequest;
import me.dio.academia.digital.entity.response.MatriculaResponse;
import me.dio.academia.digital.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<MatriculaResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<MatriculaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByid(id));
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MatriculaResponse> create(@Valid @RequestBody MatriculaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }

}

