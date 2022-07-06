package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class usuarioDAO {
    
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
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
}
