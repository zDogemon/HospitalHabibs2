package com.example.hospital;

public class Paciente {

    String nome;
    double idade;
    boolean litiase;
    double leucocitos;
    double glicemia;
    double ast_tgo;
    double ldh;

    public Paciente(String nome, double idade, boolean litiase, double leucocitos, double glicemia, double ast_tgo, double ldh) {
        this.nome = nome;
        this.idade = idade;
        this.litiase = litiase;
        this.leucocitos = leucocitos;
        this.glicemia = glicemia;
        this.ast_tgo = ast_tgo;
        this.ldh = ldh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public boolean isLitiase() {
        return litiase;
    }

    public void setLitiase(boolean litiase) {
        this.litiase = litiase;
    }

    public double getLeucocitos() {
        return leucocitos;
    }

    public void setLeucocitos(double leucocitos) {
        this.leucocitos = leucocitos;
    }

    public double getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(double glicemia) {
        this.glicemia = glicemia;
    }

    public double getAst_tgo() {
        return ast_tgo;
    }

    public void setAst_tgo(double ast_tgo) {
        this.ast_tgo = ast_tgo;
    }

    public double getLdh() {
        return ldh;
    }

    public void setLdh(double ldh) {
        this.ldh = ldh;
    }


}
