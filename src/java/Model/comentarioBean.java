
package Model;

public class comentarioBean {
    private String codigo;
    private String comentario;
    private String usuario;
    private String topico;
    
    public comentarioBean() {
        
    }

    public comentarioBean(String codigo, String comentario, String usuario, String topico) {
        this.codigo = codigo;
        this.comentario = comentario;
        this.usuario = usuario;
        this.topico = topico;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getTopico() {
        return topico;
    }
    public void setTopico(String topico) {
        this.topico = topico;
    }
    
}
