package myschool.view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class EditStudentController {
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
    
    @FXML
    public void initialize() throws IOException {
        
    }
    @FXML
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
