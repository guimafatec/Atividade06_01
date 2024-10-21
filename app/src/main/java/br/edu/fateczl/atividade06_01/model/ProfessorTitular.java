package br.edu.fateczl.atividade06_01.model;

public class ProfessorTitular extends Professor {
    private int anosInstituicao;
    private double salario;
    public ProfessorTitular() {
        super();
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcSalario() {
        double salario = this.salario;
        for (int i = 1; i <= this.anosInstituicao; i++) {
            if (i % 5 == 0) {
                salario *= 1.05;
            }
        }
        return salario;
    }
}
