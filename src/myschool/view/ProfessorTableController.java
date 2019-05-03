package myschool.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import myschool.model.dao.ProfessorDAO;
import myschool.model.dao.StudentDAO;
import myshool.model.Professor;
import myshool.model.Student;


public class ProfessorTableController implements Initializable{
    @FXML
    private TableView<Professor> table;
    
    @FXML
    private TableColumn<Professor, String> nomecol;
    
    @FXML
    private TableColumn<Professor, String> cpfcol;
    
    @FXML
    private TableColumn<Professor, String> rgcol;
    
    @FXML
    private TableColumn<Professor, String> datanasccol;
    
    @FXML
    private TableColumn<Professor, String> matriculacol;
    
    private List<Professor> ProfessorList= new ArrayList<>();
    
    private ObservableList<Professor> ObProfessorList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadProfessors();
    }
    @FXML
    public void LoadProfessors(){
        nomecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cpfcol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        rgcol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        datanasccol.setCellValueFactory(new PropertyValueFactory<>("bornDate"));
        matriculacol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        ProfessorDAO pdao = new ProfessorDAO();
        ProfessorList = pdao.LoadAllProfessors();
        //System.out.println(adao.MostrarTodosAlunos().get(0).getNome());
        ObProfessorList = FXCollections.observableArrayList(ProfessorList);
        table.setItems(ObProfessorList);
    }
    
}
