package myshool.model;

import java.util.Date;


public class Professor extends Person{
    private int salary;

    public Professor() {
    }
    
    public Professor(int Salary, int id, String name, String cpf, String rg, String bornDate, String email) {
        super(id, name, cpf, rg, bornDate, email);
        this.salary = Salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int Salary) {
        this.salary = Salary;
    }




    
}
