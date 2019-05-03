package myschool.model.dao;


import myshool.model.Student;
import myschool.model.database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import myshool.model.Professor;


public class StudentDAO {
    private Connection conexao;
    
    public boolean logIn(Student student){
        String sql = "CALL studentAutenticate('?', '?')";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, student.getUsername());
            stmt.setString(2, student.getPassword());
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Student> LoadAllStudents(){
        String sql = "SELECT * FROM myschooldatabase.studentview";
        ArrayList<Student> Students = new ArrayList<>();
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("idStudent"));
                student.setName(rs.getString("studentname"));
                student.setCpf(rs.getString("cpf"));
                student.setBornDate(rs.getString("borndate"));
                student.setRg(rs.getString("rg"));
                
                Students.add(student);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Students;
    }
    public ArrayList<Student> LoadPerSerie(String seriename){
        String sql = "CALL myschooldatabase.studentPerSerie(?)";
        ArrayList<Student> Students = new ArrayList<>();
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, seriename);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("idStudent"));
                student.setName(rs.getString("studentname"));
                student.setCpf(rs.getString("cpf"));
                student.setBornDate(rs.getString("borndate"));
                student.setRg(rs.getString("rg"));
                
                Students.add(student);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Students;
    }
    public ArrayList<Student> LoadPerClassroom(String classroom){
        String sql = "CALL myschooldatabase.studentPerClassroom(?)";
        ArrayList<Student> Students = new ArrayList<>();
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, classroom);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("idStudent"));
                student.setName(rs.getString("studentname"));
                student.setCpf(rs.getString("cpf"));
                student.setBornDate(rs.getString("borndate"));
                student.setRg(rs.getString("rg"));
                
                Students.add(student);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Students;
    }
    public ArrayList<String> LoadSerieComboBox(){
        String sql = "SELECT * FROM myschooldatabase.seriesview";
        ArrayList<String> Series = new ArrayList<>();
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Series.add(rs.getString("seriename"));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Series;
    }
    public ArrayList<String> LoadClassroomComboBox(String seriename){
        String sql = "CALL myschooldatabase.classroomperserie(?)";
        ArrayList<String> classrooms = new ArrayList<>();
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, seriename);
            System.out.println(seriename);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
                classrooms.add(rs.getString("initials"));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }
    
    public void DeleteStudent(Student student){
        String sql = "CALL studentDelete(?)";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
    public ArrayList<Student> MostrarAluno(String nome){
        String sql = "Select alunos from Pessoas where nome=? ";
        ArrayList<Student> Alunos = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Student aluno = new Student();
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDatanasc(rs.getDate("datanasc"));
                aluno.setCargo(rs.getString("cargo"));
                aluno.getBoletim().setId(rs.getInt("id_boletim"));
                
                Alunos.add(aluno);
            }
            
        } catch (Exception e) {
        }
        return Alunos;
    }
    */
    public String studentRegister(Student student)throws SQLException{
        String sql = "CALL myschooldatabase.registerStudent (?,?,?,?,?,?,?)";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            System.out.println(student.getUsername());
            stmt.setString(1, student.getUsername());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getCpf());
            stmt.setString(4, student.getRg());
            stmt.setString(5, student.getBornDate());
            stmt.setString(6, student.getPassword());
            stmt.setString(7, student.getEmail());  
            stmt.executeUpdate();
            return "Cadastrado com sucesso!";
        
        } catch(Exception m){
           return "O nome de usuário já existe";
        } 
    }
    public String studentUpdate(Student student)throws SQLException{
        String sql = "CALL myschooldatabase.studentUpdate (?,?,?,?,?,?,?)";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            System.out.println(student.getUsername());
            stmt.setString(1, student.getUsername());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getCpf());
            stmt.setString(4, student.getRg());
            stmt.setString(5, student.getBornDate());
            stmt.setString(6, student.getPassword());
            stmt.setString(7, student.getEmail());  
            stmt.executeUpdate();
            return "Atualizado com sucesso!";
        
        } catch(Exception m){
           return "O nome de usuário já existe";
        } 
    }
    /*
    public void EditarAluno(){
        
    }
    public void ExcluirAluno(){
        
    }*/
}
