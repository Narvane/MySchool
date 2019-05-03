package myschool.view;

import java.io.IOException;
import myshool.model.Student;
import myschool.model.dao.StudentDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myschool.MySchool;

public class StudentTableController implements Initializable {

    @FXML
    private TableView<Student> table;

    @FXML
    private  TableColumn<Student, String> nomecol;

    @FXML
    private  TableColumn<Student, String> cpfcol;

    @FXML
    private  TableColumn<Student, String> rgcol;

    @FXML
    private  TableColumn<Student, String> datanasccol;

    @FXML
    private  TableColumn<Student, String> matriculacol;

    private  List<Student> StudentList = new ArrayList<>();

    private  ObservableList<Student> ObAlunoList;
    
    //--------
    
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
    @FXML
    public void setFields(){
        name.setText(table.getSelectionModel().getSelectedItem().getName());
        username.setText(table.getSelectionModel().getSelectedItem().getUsername());
        rg.setText(table.getSelectionModel().getSelectedItem().getRg());
        cpf.setText(table.getSelectionModel().getSelectedItem().getCpf());
        email.setText(table.getSelectionModel().getSelectedItem().getEmail());
        password.setText(table.getSelectionModel().getSelectedItem().getPassword());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadStudents();
    }

    @FXML
    public void LoadStudents() {
        nomecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cpfcol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        rgcol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        datanasccol.setCellValueFactory(new PropertyValueFactory<>("bornDate"));
        matriculacol.setCellValueFactory(new PropertyValueFactory<>("id"));

        StudentDAO sdao = new StudentDAO();
        StudentList = sdao.LoadAllStudents();
        //System.out.println(adao.MostrarTodosAlunos().get(0).getNome());
        ObAlunoList = FXCollections.observableArrayList(StudentList);
        table.setItems(ObAlunoList);
    }
    @FXML
    public void confirmDeleteStudent(ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Deletar alino?");
        alert.setHeaderText("Deletar?");
        alert.setContentText("Você deseja realmente deletar o aluno?");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                DeleteSelectStudent();
                LoadStudents();
            }
        });
    }
    @FXML
    public void DeleteSelectStudent(){
        StudentDAO sdao = new StudentDAO();
        Student student = table.getSelectionModel().getSelectedItem();
        sdao.DeleteStudent(student);
    }
    @FXML
    public void ShowSchoolReport(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/SchoolReportView.fxml"));
        AnchorPane ap = Loader.load();

        Stage cadastroAluno = new Stage();
        cadastroAluno.setTitle("Boletim");
        cadastroAluno.setResizable(false);
        cadastroAluno.initModality(Modality.WINDOW_MODAL);
        cadastroAluno.initOwner(LoginController.homeStage);
        Scene scene = new Scene(ap);
        cadastroAluno.setScene(scene);
        cadastroAluno.showAndWait();
    }

    @FXML
    public void ShowEditStudent(ActionEvent e) throws IOException {
        
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/EditStudentView.fxml"));
        BorderPane ap = Loader.load();
        setFields();

        Stage cadastroAluno = new Stage();
        cadastroAluno.setResizable(false);
        cadastroAluno.setTitle("Editar Dados");
        cadastroAluno.initModality(Modality.WINDOW_MODAL);
        cadastroAluno.initOwner(LoginController.homeStage);
        Scene scene = new Scene(ap);
        cadastroAluno.setScene(scene);
        
        cadastroAluno.showAndWait();
    }
}
