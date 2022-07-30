package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne()
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  @Column(name="peso_atual", nullable = false)
  private double peso;

  @Column(name="altura_atual", nullable = false)
  private double altura;

  @Column(nullable = false)
  private LocalDateTime dataDaAvaliacao;

}
