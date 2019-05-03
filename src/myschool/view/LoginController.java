package myschool.view;

import myschool.MySchool;
import myschool.model.dao.PersonDAO;
import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import myschool.model.dao.ProfessorDAO;
import myschool.model.dao.SecretaryDAO;
import myschool.model.dao.StudentDAO;
import myshool.model.Professor;
import myshool.model.Secretary;
import myshool.model.Student;

public class LoginController {

    public static Stage homeStage;
    @FXML
    private AnchorPane pane;

    @FXML
    private TextField username;

    @FXML
    private ComboBox<String> post;

    @FXML
    private Button btnLogIn;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView image;

    @FXML
    private Label feedback;

    @FXML
    void Autenticate(ActionEvent event) throws IOException {
        if (null != post.getValue()) {
            switch (post.getValue()) {
                case "Aluno":
                    Student student = new Student();
                    student.setUsername(username.getText());
                    student.setPassword(password.getText());
                    StudentDAO sDAO = new StudentDAO();
                    if (setFeedback(sDAO.logIn(student))) {
                        showStudentStage();
                    }
                    break;
                case "Professor":
                    Professor professor = new Professor();
                    professor.setUsername(username.getText());
                    professor.setPassword(password.getText());
                    ProfessorDAO pDAO = new ProfessorDAO();
                    if (setFeedback(pDAO.logIn(professor))) {
                        showProfessorStage();
                    }
                    break;
                case "Secretario":
                    Secretary secretary = new Secretary();
                    secretary.setUsername(username.getText());
                    secretary.setPassword(password.getText());
                    SecretaryDAO seDAO = new SecretaryDAO();
                    if (setFeedback(seDAO.logIn(secretary))) {
                        showSecretaryStage();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    public void showStudentStage() throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/StudentView.fxml"));
        BorderPane bp = Loader.load();

        Stage Home = new Stage();
        this.homeStage = Home;
        Home.setTitle("StudentClient");
        Scene scene = new Scene(bp);
        Home.setScene(scene);
        Home.show();
        MySchool.home.close();
    }

    @FXML
    public void showProfessorStage() throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/ProfessorView.fxml"));
        BorderPane bp = Loader.load();

        Stage Home = new Stage();
        this.homeStage = Home;
        Home.setTitle("ProfessorClient");
        Scene scene = new Scene(bp);
        Home.setScene(scene);
        Home.show();
        MySchool.home.close();
    }

    @FXML
    public void showSecretaryStage() throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/SecretaryView.fxml"));
        BorderPane bp = Loader.load();

        Stage Home = new Stage();
        this.homeStage = Home;
        Home.setTitle("SecretaryClient");
        Scene scene = new Scene(bp);
        Home.setScene(scene);
        Home.show();
        MySchool.home.close();
    }

    @FXML
    public void showHome() throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(MySchool.class.getResource("view/HomeView.fxml"));
        BorderPane bp = Loader.load();

        Stage Home = new Stage();
        this.homeStage = Home;
        Home.setTitle("School");
        Scene scene = new Scene(bp);
        Home.setScene(scene);
        Home.show();
        MySchool.home.close();
    }

    @FXML
    public void initialize() {

        String prof = "Professor";
        String sec = "Secretario";
        String stud = "Aluno";
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add(prof);
        list.add(sec);
        list.add(stud);
        post.setItems(list);
        javafx.scene.image.Image image3 = new javafx.scene.image.Image(new File("src\\myschool\\image\\alunoImage.png").toURI().toString());
        image.setImage(image3);

    }

    public void changeImage() throws InterruptedException {
        if (null != post.getValue()) {
            switch (post.getValue()) {
                case "Secretario":
                    image.setOpacity(0);
                    javafx.scene.image.Image image1 = new javafx.scene.image.Image(new File("src\\myschool\\image\\secretarioImage.png").toURI().toString());
                    image.setImage(image1);
                    image.setOpacity(0);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                for (double i = 0; i < 1; i=i+0.1) {
                                    image.setOpacity(i);
                                    Thread.sleep(50);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    break;
                case "Professor":
                    javafx.scene.image.Image image2 = new javafx.scene.image.Image(new File("src\\myschool\\image\\professorImage.png").toURI().toString());
                    image.setImage(image2);
                    image.setOpacity(0);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                for (double i = 0; i < 1; i=i+0.1) {
                                    image.setOpacity(i);
                                    Thread.sleep(50);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    break;
                case "Aluno":
                    javafx.scene.image.Image image3 = new javafx.scene.image.Image(new File("src\\myschool\\image\\alunoImage.png").toURI().toString());
                    image.setImage(image3);
                    image.setOpacity(0);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                for (double i = 0; i < 1; i=i+0.1) {
                                    image.setOpacity(i);
                                    Thread.sleep(50);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    break;
                default:
                    break;
            }
        }
    }

    public void slide(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            post.show();
        }
    }

    public void enter(KeyEvent k) throws IOException {
        if (k.getCode() == KeyCode.ENTER) {
            if (null != post.getValue()) {
                switch (post.getValue()) {
                    case "Aluno":
                        Student student = new Student();
                        student.setUsername(username.getText());
                        student.setPassword(password.getText());
                        StudentDAO sDAO = new StudentDAO();
                        if (setFeedback(sDAO.logIn(student))) {
                            showStudentStage();
                        }
                        break;
                    case "Professor":
                        Professor professor = new Professor();
                        professor.setUsername(username.getText());
                        professor.setPassword(password.getText());
                        ProfessorDAO pDAO = new ProfessorDAO();
                        if (setFeedback(pDAO.logIn(professor))) {
                            showProfessorStage();
                        }
                        break;
                    case "Secretario":
                        Secretary secretary = new Secretary();
                        secretary.setUsername(username.getText());
                        secretary.setPassword(password.getText());
                        SecretaryDAO seDAO = new SecretaryDAO();
                        if (setFeedback(seDAO.logIn(secretary))) {
                            showSecretaryStage();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public boolean setFeedback(boolean r) {
        feedback.setVisible(true);
        if (r) {
            return true;
        } else {
            feedback.setText("Username ou senha errados!");
            return false;
        }
    }
}
