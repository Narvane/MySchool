package myshool.model;

import java.util.ArrayList;


public class SchoolReport {
    private int id;
    private ArrayList<Discipline> disciplina;

    public SchoolReport() {
    }

    public SchoolReport(ArrayList<Discipline> disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Discipline> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(ArrayList<Discipline> disciplina) {
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
