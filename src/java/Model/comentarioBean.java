
package Model;

public class comentarioBean {
    private String codigo;
    private String comentario;
    private usuarioBean usuario;
    private topicoBean topico;
    
    public comentarioBean() {
        
    }

    public comentarioBean(String codigo, String comentario, usuarioBean usuario, topicoBean topico) {
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
    public usuarioBean getUsuario() {
        return usuario;
    }
    public void setUsuario(usuarioBean usuario) {
        this.usuario = usuario;
    }
    public topicoBean getTopico() {
        return topico;
    }
    public void setTopico(topicoBean topico) {
        this.topico = topico;
    }
    
}
