package myschool.model.dao;

import myschool.model.database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAO {
    private Connection conexao;
    
    public boolean logIn(String nome, String senha, String cargo){
        String sql = "SELECT nome, senha FROM pessoa WHERE nome=? and senha=? and cargo=?";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.setString(3, cargo);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<String> MostrarCargos(){
        ArrayList<String> aux = new ArrayList<>();
        String ViewCargo = "SELECT * FROM myschool.cargos";
        String qntResult = "SELECT count(*) as total FROM myschool.cargos;";
        try {
            conexao = ConnectionFactory.faz_conexao();
            PreparedStatement CCargo = conexao.prepareStatement(ViewCargo);
            PreparedStatement CResult = conexao.prepareStatement(qntResult);
            ResultSet rs = CCargo.executeQuery();
            ResultSet rs1 = CResult.executeQuery();
            
            
            while(rs.next()){
                    aux.add(rs.getString("Cargo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return aux;

    }
}
