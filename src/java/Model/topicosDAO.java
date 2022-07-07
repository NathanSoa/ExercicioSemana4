
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
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
    
    public List<topicoBean> todosTopicos(){
        List<topicoBean> todos = new ArrayList<>();
        
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "SELECT * FROM topico INNER JOIN usuario ON (top_usu_login = login)";
            PreparedStatement stmt = c.prepareStatement(sql);
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
            String sql = "SELECT * FROM topico INNER JOIN usuario ON (top_usu_login = login) WHERE top_codigo = ?";
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
    
    public void insereTopico(topicoBean topico){
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "INSERT INTO topico(top_titulo, top_conteudo, top_usu_login) VALUES (?, ?, ?)";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, topico.getTitulo());
            stmt.setString(2, topico.getConteudo());
            stmt.setString(3, topico.getUsuario());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    topicoBean montaObjeto(ResultSet rs)throws SQLException{
        return new topicoBean(String.valueOf(rs.getInt("top_codigo")), rs.getString("top_titulo"), rs.getString("top_conteudo"), rs.getString("nome"));
    }
}
