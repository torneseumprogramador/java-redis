package br.com.redis.models;

import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private List<Double> notas;

    public String getMatricula() {
        return matricula;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double media(){
        Double somaNotas = 0.0;
        for (Double nota : notas) {
            somaNotas+= nota;
        }
        return somaNotas / notas.size();
    }

    public Boolean aprovado(){
        return this.media() >= 7 ? true : false;
    }
}
