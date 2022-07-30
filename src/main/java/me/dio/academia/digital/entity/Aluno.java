package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(unique = true, nullable = false)
  private String cpf;

  @Column(nullable = false)
  private String bairro;

  @Column(nullable = false)
  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //cascade = CascadeType.ALL é usado para propagar a declaração sql. No caso, por exemplo, se o aluno for excluído, as avaliações também serão.
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

  @OneToOne(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Matricula matricula;

}
