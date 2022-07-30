package me.dio.academia.digital.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String bairro;
    private LocalDate dataDeNascimento;

}
