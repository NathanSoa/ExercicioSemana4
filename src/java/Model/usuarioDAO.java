package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class usuarioDAO {
    
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
    
    public String autenticar(String login, String senha){
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "SELECT nome FROM usuario WHERE login = ? AND senha = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return "Erro";
    }
    
    public String retornaNome(String login){
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "SELECT nome FROM usuario WHERE login = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return rs.getString("nome");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return "Erro";
    }
    
    public void cadastrar(usuarioBean u){
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "INSERT INTO usuario(login, nome, email, senha, pontos) VALUES(?, ?, ?, ?, 0)";
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSenha());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<usuarioBean> ranking(){
        List<usuarioBean> ranking = new ArrayList<>();
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "SELECT * FROM usuario ORDER BY pontos desc";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ranking.add(montaObjeto(rs));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ranking;
    }
    
    public void acrescentaPontos(int pontos, String login){
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "UPDATE usuario SET pontos = (pontos + ?) WHERE login = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, pontos);
            stmt.setString(2, login);
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
        
    usuarioBean montaObjeto(ResultSet rs) throws SQLException{
        return new usuarioBean(rs.getString("login"), rs.getString("email"), rs.getString("nome"),rs.getString("senha"), rs.getInt("pontos"));        
    }
}
