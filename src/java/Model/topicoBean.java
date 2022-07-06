
package Model;

import java.io.Serializable;

public class topicoBean implements Serializable{
    private String codigo;
    private String titulo;
    private String conteudo;
    private usuarioBean usuario;

    
    public topicoBean() {
    }

    public topicoBean(String codigo, String titulo, String conteudo, usuarioBean usuario) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.usuario = usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public usuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(usuarioBean usuario) {
        this.usuario = usuario;
    }

}
