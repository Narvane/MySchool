package myschool.view;

import java.io.IOException;
import myschool.model.dao.StudentDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javafx.scene.paint.Color.GREEN;
import myshool.model.Student;


public class RegisterStudentController {
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
    private Label feedback;
            
    
    public void Register(ActionEvent e) throws SQLException{
        Student student = new Student();
        student.setName(name.getText());
        student.setCpf(cpf.getText());
        student.setUsername(username.getText());
        student.setRg(rg.getText());
        student.setEmail(email.getText());
        student.setBornDate(String.valueOf(borndate.getValue()));
        student.setPassword(password.getText());
        
        StudentDAO sdao = new StudentDAO();
        
        feedback.setVisible(true);
        feedback.setText(sdao.studentRegister(student));
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
    }
}
