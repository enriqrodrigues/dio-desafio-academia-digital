package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.request.AlunoRequest;
import me.dio.academia.digital.entity.response.AlunoResponse;
import me.dio.academia.digital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoResponse> findAll() {
        List<AlunoResponse> listResponse = new ArrayList<>();
        List<Aluno> listAlunos = alunoRepository.findAll();

        for (Aluno aluno : listAlunos) {
            AlunoResponse response = mountResponse(aluno);
            listResponse.add(response);
        }

        return listResponse;
    }

    public AlunoResponse findByid(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(null);
        return mountResponse(aluno);
    }

    public AlunoResponse create(AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setCpf(request.getCpf());
        aluno.setBairro(request.getBairro());
        aluno.setDataDeNascimento(request.getDataDeNascimento());
        Aluno alunoSaved = alunoRepository.save(aluno);

        return mountResponse(alunoSaved);
    }

    public AlunoResponse update(Long id, AlunoRequest request) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(null);
        aluno.setNome(request.getNome());
        aluno.setCpf(request.getCpf());
        aluno.setBairro(request.getBairro());
        aluno.setDataDeNascimento(request.getDataDeNascimento());
        Aluno alunoSaved = alunoRepository.save(aluno);

        return mountResponse(alunoSaved);
    }

    public Map<String, String> delete(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(null);
        alunoRepository.delete(aluno);
        Map<String, String> message = new HashMap<>();
        message.put("message", "OK!");
        return message;
    }

    protected AlunoResponse mountResponse(Aluno aluno) {
        AlunoResponse response = new AlunoResponse();
        response.setId(aluno.getId());
        response.setNome(aluno.getNome());
        response.setCpf(aluno.getCpf());
        response.setBairro(aluno.getBairro());
        response.setDataDeNascimento(aluno.getDataDeNascimento());
        return response;
    }

}
