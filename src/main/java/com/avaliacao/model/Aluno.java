package com.avaliacao.model;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno implements Avaliavel, Recuperavel, Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private int matricula;

    private double frequencia;

    @OneToOne(cascade = CascadeType.ALL)
    private Avaliacao primeiroBimestre;

    @OneToOne(cascade = CascadeType.ALL)
    private Avaliacao segundoBimestre;

    private double notaRecuperacao;

    // Constructors, getters, and setters omitted for brevity

    public double calcularMedia() {
        double media = (primeiroBimestre.getNota() + segundoBimestre.getNota()) / 2;
        return media;
    }

    public boolean temDireitoRecuperacao() {
        return calcularMedia() < 6.0;
    }

    public void registrarNotaRecuperacao(double nota) {
        this.notaRecuperacao = nota;
    }

    public String gerarRelatorio() {
        return String.format("Aluno: %s - Média: %.2f - Recuperação: %.2f", nome, calcularMedia(), notaRecuperacao);
    }
}