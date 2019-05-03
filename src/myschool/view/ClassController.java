package myschool.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myschool.MySchool;
import myschool.model.dao.StudentDAO;
import myshool.model.Student;

public class ClassController {

    @FXML
    public static Stage addStudentToClass;
    
    @FXML
    public static String classroomReference;

    @FXML
    private ComboBox serie;
    
    @FXML
    private ComboBox classroom;
    
    @FXML
    private Label classroomName;
    
    @FXML
    private TableView table;
    
    @FXML
    private TableColumn namecol;
    
    @FXML
    private TableColumn cpfcol;
    
    @FXML
    private TableColumn rgcol;
    
    @FXML
    private TableColumn borndatecol;
    
    @FXML
    private TableColumn matriculacol;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private Button Search;
    
    @FXML
    private Button addStudent;
    
    @FXML
    private  List<Student> StudentList = new ArrayList<>();

    @FXML
    private  ObservableList<Student> ObAlunoList;
    
    
    @FXML
    public void initialize() {
        LoadStudents();
        LoadSerieBox();
        LoadStudentsMiniTable();
        activAdd();
    }
    @FXML
    public void LoadStudentsPerSerie() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cpfcol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        rgcol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        borndatecol.setCellValueFactory(new PropertyValueFactory<>("bornDate"));
        matriculacol.setCellValueFactory(new PropertyValueFactory<>("id"));

        StudentDAO sdao = new StudentDAO();
        StudentList = sdao.LoadPerSerie(String.valueOf(serie.getValue()));
        ObAlunoList = FXCollections.observableArrayList(StudentList);
        table.setItems(ObAlunoList);
        LoadClassroomBox();
    }
    @FXML
    public void LoadStudentsPerClassroom() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cpfcol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        rgcol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        borndatecol.setCellValueFactory(new PropertyValueFactory<>("bornDate"));
        matriculacol.setCellValueFactory(new PropertyValueFactory<>("id"));

        StudentDAO sdao = new StudentDAO();
        StudentList = sdao.LoadPerClassroom((String) classroom.getValue());
        ObAlunoList = FXCollections.observableArrayList(StudentList);
        table.setItems(ObAlunoList);
        activAdd();
    }
    @FXML
    public void LoadSerieBox(){
        StudentDAO sdao = new StudentDAO();
        ObservableList<String> list = FXCollections.observableArrayList(sdao.LoadSerieComboBox());
        serie.setItems(list);
    }
    @FXML
    public void LoadClassroomBox(){
        StudentDAO sdao = new StudentDAO();
        ObservableList<String> list = FXCollections.observableArrayList(sdao.LoadClassroomComboBox(String.valueOf(serie.getValue())));
        classroom.setItems(list);
    }
    
    @FXML
    public void LoadStudents() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cpfcol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        rgcol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        borndatecol.setCellValueFactory(new PropertyValueFactory<>("bornDate"));
        matriculacol.setCellValueFactory(new PropertyValueFactory<>("id"));

        StudentDAO sdao = new StudentDAO();
        StudentList = sdao.LoadAllStudents();
        //System.out.println(adao.MostrarTodosAlunos().get(0).getNome());
        ObAlunoList = FXCollections.observableArrayList(StudentList);
        table.setItems(ObAlunoList);
    }
    @FXML
    public void LoadStudentsMiniTable() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        matriculacol.setCellValueFactory(new PropertyValueFactory<>("id"));

        StudentDAO sdao = new StudentDAO();
        StudentList = sdao.LoadAllStudents();
        //System.out.println(adao.MostrarTodosAlunos().get(0).getNome());
        ObAlunoList = FXCollections.observableArrayList(StudentList);
        table.setItems(ObAlunoList);
    }

    @FXML
    public void addToClass(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/AddToClassView.fxml"));
        AnchorPane bp = Loader.load();

        addStudentToClass = new Stage();
        addStudentToClass.setResizable(false);
        addStudentToClass.setTitle("Adicionar aluno a classe");
        addStudentToClass.initModality(Modality.WINDOW_MODAL);
        addStudentToClass.initOwner(LoginController.homeStage);
        Scene scene = new Scene(bp);
        addStudentToClass.setScene(scene);
        addStudentToClass.showAndWait();
    }
    public void activAdd(){
        if(classroom.getValue() == null){
            returnReference();
            addStudent.setDisable(true);
        }else{
            addStudent.setDisable(false);
        }
    }
    public void returnReference(){
        classroomReference = (String) classroom.getValue();
    }
}
