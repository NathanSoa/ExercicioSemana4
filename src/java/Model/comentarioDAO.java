package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class comentarioDAO {
    
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
    
    public List<comentarioBean> todosComentarios(int codigo){
        List<comentarioBean> todos = new ArrayList<>();
        
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "SELECT * FROM comentario"
                    + " INNER JOIN topico ON (com_top_codigo = top_codigo)"
                    + " INNER JOIN usuario ON (top_usu_login = login)"
                    + " WHERE top_codigo = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                todos.add(montaObjeto(rs));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return todos;
    }
    
    public void fazerComentario(String comentario, String login, int codigoTopico){
        
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuarioDB", "usuarioTeste", "senhaPadrao")){
            String sql = "INSERT INTO comentario (com_comentario, com_login, com_top_codigo) values (?, ?, ?)";
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, comentario);
            stmt.setString(2, login);
            stmt.setInt(3, codigoTopico);
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private comentarioBean montaObjeto(ResultSet rs) throws SQLException{
        usuarioDAO u = new usuarioDAO();
        topicosDAO t = new topicosDAO();
        return new comentarioBean(String.valueOf(rs.getInt("com_codigo")), rs.getString("com_comentario"), u.montaObjeto(rs), t.montaObjeto(rs));
    }
}