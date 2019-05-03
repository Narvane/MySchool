package myshool.model;

import java.util.Date;


public abstract class Person {
    private int id;
    private String username;
    private String name;
    private String password;
    private String cpf;
    private String rg;
    private String bornDate;
    private String email;

    public Person() {
    }

    public Person(int id, String name, String cpf, String rg, String bornDate, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.bornDate = bornDate;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String BornDate) {
        this.bornDate = BornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }
    
    
}
