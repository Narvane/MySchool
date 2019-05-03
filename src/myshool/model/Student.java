package myshool.model;

import java.util.Date;


public class Student extends Person{

    public Student() {
    }
    
    public Student(int id, String name, String cpf, String rg, String bornDate, String email) {
        super(id, name, cpf, rg, bornDate, email);
    }    
}
