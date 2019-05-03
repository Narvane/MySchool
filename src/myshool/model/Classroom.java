package myshool.model;

import java.util.ArrayList;


public class Classroom {
    private String Sigla;
    private ArrayList<Student> Alunos;

    public Classroom() {
    }

    public Classroom(String Sigla, ArrayList<Student> Alunos) {
        this.Sigla = Sigla;
        this.Alunos = Alunos;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public ArrayList<Student> getAlunos() {
        return Alunos;
    }

    public void setAlunos(ArrayList<Student> Alunos) {
        this.Alunos = Alunos;
    }


}
