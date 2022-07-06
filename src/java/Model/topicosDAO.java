
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class topicosDAO {
    
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
    
    public List<topicoBean> todosTopicos(String login){
        List<topicoBean> todos = new ArrayList<>();
        
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "SELECT * FROM topico WHERE top_usu_login = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                todos.add(montaObjeto(rs));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return todos;
    }
    
    public topicoBean retornaTopico(int codigo){
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "SELECT * FROM topico WHERE top_codigo = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return montaObjeto(rs);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    topicoBean montaObjeto(ResultSet rs)throws SQLException{
        return new topicoBean(String.valueOf(rs.getInt("top_codigo")), rs.getString("top_titulo"), rs.getString("top_conteudo"), rs.getString("top_usu_login"));
    }
}
