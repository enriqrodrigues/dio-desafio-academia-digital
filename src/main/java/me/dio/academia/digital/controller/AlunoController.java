package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.request.AlunoRequest;
import me.dio.academia.digital.entity.response.AlunoResponse;
import me.dio.academia.digital.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    public AlunoService service;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<AlunoResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AlunoResponse> findById(@PathVariable Long id) {
        AlunoResponse response = service.findByid(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AlunoResponse> create(@Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AlunoResponse> updated(@PathVariable Long id,
                                               @Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, request));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }

}
