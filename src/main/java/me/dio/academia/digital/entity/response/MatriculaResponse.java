package me.dio.academia.digital.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaResponse {

    private Long id;
    private AlunoResponse alunoResponse;
    private LocalDateTime dataDaMatricula;


}
