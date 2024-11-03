package br.com.vagner.classeestatisticas.model;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    private String nome;
    private LocalDate nascimento;

    public Aluno(String nome, LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

   public int getIdade(){
       Period periodo = Period.between(nascimento, LocalDate.now());
       return periodo.getYears();
   }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
