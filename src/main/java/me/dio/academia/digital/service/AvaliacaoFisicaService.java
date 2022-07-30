package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.request.AvaliacaoFisicaRequest;
import me.dio.academia.digital.entity.response.AvaliacaoFisicaResponse;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    public List<AvaliacaoFisicaResponse> findByIdAluno(Long id) {
        List<AvaliacaoFisicaResponse> listResponse = new ArrayList<>();
        List<AvaliacaoFisica> listAvaliacoes = avaliacaoFisicaRepository.findByIdAluno(id);

        for (AvaliacaoFisica avaliacao : listAvaliacoes) {
            AvaliacaoFisicaResponse response = mountResponse(avaliacao);
            listResponse.add(response);
        }

        return listResponse;
    }

    public AvaliacaoFisicaResponse create(AvaliacaoFisicaRequest request) {
        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        avaliacao.setAluno(alunoRepository.findById(request.getIdAluno()).orElseThrow(null));
        avaliacao.setAltura(request.getAltura());
        avaliacao.setPeso(request.getPeso());
        avaliacao.setDataDaAvaliacao(LocalDateTime.now());
        AvaliacaoFisica avaliacaoSaved = avaliacaoFisicaRepository.save(avaliacao);

        return mountResponse(avaliacaoSaved);
    }

    public Map<String, String> delete(Long id) {
        AvaliacaoFisica avaliacao = avaliacaoFisicaRepository.findById(id).orElseThrow(null);
        avaliacaoFisicaRepository.delete(avaliacao);
        Map<String, String> message = new HashMap<>();
        message.put("message", "OK!");
        return message;
    }

    protected AvaliacaoFisicaResponse mountResponse(AvaliacaoFisica avaliacao) {
        AvaliacaoFisicaResponse response = new AvaliacaoFisicaResponse();
        response.setId(avaliacao.getId());
        response.setAltura(avaliacao.getAltura());
        response.setPeso(avaliacao.getPeso());
        response.setDataDaAvaliacao(avaliacao.getDataDaAvaliacao());

        return response;
    }

}
