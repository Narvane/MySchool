package myschool.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import myschool.model.database.ConnectionFactory;
import myshool.model.Professor;
import myshool.model.Secretary;


public class SecretaryDAO {
    
    private Connection conexao;
    
    public boolean logIn(Secretary secretary){
        String sql = "CALL myschooldatabase.secretaryAutenticate(?, ?)";
        System.out.println(secretary.getUsername());
        System.out.println(secretary.getPassword());
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, secretary.getUsername());
            stmt.setString(2, secretary.getPassword());
            ResultSet rs = stmt.executeQuery();

            
            return rs.next();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
