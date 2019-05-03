package myschool.model.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import myschool.model.database.ConnectionFactory;
import myshool.model.Professor;
import myshool.model.Student;


public class ProfessorDAO {
    private Connection conexao;
    
        public boolean logIn(Professor professor) {
        String sql = "CALL myschooldatabase.professorAutenticate(?, ?)";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, professor.getUsername());
            stmt.setString(2, professor.getPassword());
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        public String professorRegister(Professor professor) throws SQLException{
        String sql = "CALL myschooldatabase.registerProfessor (?,?,?,?,?,?,?,?)";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            System.out.println(professor.getUsername());
            stmt.setString(1, professor.getUsername());
            stmt.setString(2, professor.getName());
            stmt.setString(3, professor.getCpf());
            stmt.setString(4, professor.getRg());
            stmt.setString(5, professor.getBornDate());
            stmt.setString(6, professor.getPassword());
            stmt.setInt(7, professor.getSalary());
            stmt.setString(8, professor.getEmail()); 
            
            stmt.executeUpdate();
            
            return "Cadastrado com sucesso!";
        
        } catch(Exception m){
           return "O nome de usuário já existe";
        } 
    }
    public ArrayList<Professor> LoadAllProfessors(){
        String sql = "SELECT * FROM myschooldatabase.professorview";
        ArrayList<Professor> Professors = new ArrayList<>();
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("idProfessor"));
                professor.setName(rs.getString("professorName"));
                professor.setCpf(rs.getString("cpf"));
                professor.setBornDate(rs.getString("borndate"));
                professor.setRg(rs.getString("rg"));
                
                Professors.add(professor);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Professors;
    }
        
}
