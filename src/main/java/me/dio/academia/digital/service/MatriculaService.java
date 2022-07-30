package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.request.MatriculaRequest;
import me.dio.academia.digital.entity.response.MatriculaResponse;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    public List<MatriculaResponse> findAll() {
        List<MatriculaResponse> listResponse = new ArrayList<>();
        List<Matricula> listMatriculas = matriculaRepository.findAll();

        for (Matricula matricula : listMatriculas) {
            MatriculaResponse response = mountResponse(matricula);
            listResponse.add(response);
        }

        return listResponse;
    }

    public MatriculaResponse findByid(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(null);
        return mountResponse(matricula);
    }

    public MatriculaResponse create(MatriculaRequest request) {
        Matricula matricula = new Matricula();
        matricula.setAluno(alunoRepository.findById(request.getIdAluno()).orElseThrow(null));
        matricula.setDataDaMatricula(LocalDateTime.now());
        Matricula matriculaSaved = matriculaRepository.save(matricula);

        return mountResponse(matriculaSaved);
    }

    public Map<String, String> delete(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(null);
        matriculaRepository.delete(matricula);
        Map<String, String> message = new HashMap<>();
        message.put("message", "OK!");
        return message;
    }

    protected MatriculaResponse mountResponse(Matricula matricula) {
        MatriculaResponse response = new MatriculaResponse();
        response.setId(matricula.getId());
        response.setAlunoResponse(alunoService.mountResponse(matricula.getAluno()));
        response.setDataDaMatricula(matricula.getDataDaMatricula());
        return response;
    }

}
