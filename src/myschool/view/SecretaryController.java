package myschool.view;

import java.io.File;
import myschool.MySchool;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SecretaryController {
    @FXML
    private ImageView profile;
    
    @FXML
    private BorderPane center;
    
    @FXML
    public static Stage cadastroAluno;

    @FXML
    public void initialize() throws IOException {
        javafx.scene.image.Image image1 = new javafx.scene.image.Image(new File("src\\myschool\\image\\profile.jpg").toURI().toString());
        profile.setImage(image1);
        ShowAlunoTable(new ActionEvent());
    }

    public void ShowClass(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/ClassView.fxml"));
        AnchorPane ap = Loader.load();
        center.setCenter(ap);
    }
    @FXML
    public void ShowAlunoTable(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/StudentTableView.fxml"));
        AnchorPane ap = Loader.load();
        center.setCenter(ap);
    }
  

    public void ShowProfessorTable(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/ProfessorTableView.fxml"));
        AnchorPane ap = Loader.load();
        center.setCenter(ap);
    }

    public void ShowSecretaryTable(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/SecretaryTableView.fxml"));
        AnchorPane ap = Loader.load();
        center.setCenter(ap);
    }

    public void showStudentRegister(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/RegisterStudentView.fxml"));
        BorderPane bp = Loader.load();

        cadastroAluno = new Stage();
        cadastroAluno.setResizable(false);
        cadastroAluno.setTitle("Cadastrar aluno");
        cadastroAluno.initModality(Modality.WINDOW_MODAL);
        cadastroAluno.initOwner(LoginController.homeStage);
        Scene scene = new Scene(bp);
        cadastroAluno.setScene(scene);
        cadastroAluno.showAndWait();
    }

    public void showProfessorRegister(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/RegisterProfessorView.fxml"));
        BorderPane bp = Loader.load();

        Stage cadastroProfessor = new Stage();
        cadastroProfessor.setResizable(false);
        cadastroProfessor.setTitle("Cadastro professor");
        cadastroProfessor.initModality(Modality.WINDOW_MODAL);
        cadastroProfessor.initOwner(LoginController.homeStage);
        Scene scene = new Scene(bp);
        cadastroProfessor.setScene(scene);
        cadastroProfessor.showAndWait();
    }

    public void LogOut(ActionEvent e) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Deslogar?");
        alert.setHeaderText("Deslogar");
        alert.setContentText("Você deseja realmente deslogar?");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                try {
                    MySchool.ShowHome();
                    LoginController.homeStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
