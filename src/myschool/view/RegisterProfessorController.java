package myschool.view;

import myschool.model.dao.StudentDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javafx.scene.paint.Color.GREEN;
import myschool.model.dao.ProfessorDAO;
import myshool.model.Professor;
import myshool.model.Student;


public class RegisterProfessorController {
    @FXML
    private TextField name;
    @FXML
    private TextField username;
    @FXML
    private TextField rg; 
    @FXML
    private TextField cpf;
    @FXML
    private DatePicker borndate;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private TextField salary;
    @FXML
    private Label feedback;
            
    public void Register(ActionEvent e) throws SQLException{
        Professor professor = new Professor();
        professor.setName(name.getText());
        professor.setCpf(cpf.getText());
        professor.setUsername(username.getText());
        professor.setRg(rg.getText());
        professor.setEmail(email.getText());
        professor.setBornDate(String.valueOf(borndate.getValue()));
        professor.setPassword(password.getText());
        professor.setSalary(Integer.parseInt(salary.getText()));
        ProfessorDAO pdao = new ProfessorDAO();
        
        feedback.setVisible(true);
        feedback.setText(pdao.professorRegister(professor));
        if("Cadastrado com sucesso!".equals(feedback.getText())){
            feedback.setVisible(true);
            feedback.setTextFill(GREEN);
            clear();
        }
        
    }
    public void Cancel(ActionEvent e){
        SecretaryController.cadastroAluno.close();
    }
    public void clear(){
        name.setText("");
        username.setText("");
        rg.setText("");
        cpf.setText("");
        borndate.setValue(null);
        email.setText("");
        password.setText("");
        salary.setText("");
    }
}