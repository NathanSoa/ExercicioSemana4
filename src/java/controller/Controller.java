package controller;

import Model.comentarioBean;
import Model.comentarioDAO;
import Model.topicoBean;
import Model.topicosDAO;
import Model.usuarioBean;
import Model.usuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/autenticar", "/main", "/cadastrar", "/exibeTopico", "/comentar", "/criarTopico", "/ranking"})
public class Controller extends HttpServlet {

    usuarioDAO usuarioDAO = new usuarioDAO();  
    topicosDAO topicoDAO = new topicosDAO();
    comentarioDAO comentarioDAO = new comentarioDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        switch(request.getServletPath()){
            
            case "/main":
                main(request, response);
                break;
                
            case "/exibeTopico":
                exibeTopico(request, response);
                break;
                
            case "/ranking":
                exibeRanking(request, response);
                break;
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        switch(request.getServletPath()){
            
            case "/main":
                main(request, response);
                break;
                
            case "/autenticar":
                autenticar(request, response);
                break;
                
            case "/cadastrar":
                cadastrar(request, response);
                break;
                
            case "/comentar":
                comentar(request, response);
                break;
                
            case "/criarTopico":
                criarTopico(request, response);
                break;
        }
    }
    
    private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<topicoBean> lista = topicoDAO.todosTopicos();
        request.setAttribute("topicos", lista);
        request.getRequestDispatcher("jsp/topicos.jsp").forward(request, response);
    }
    
    private void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nome = usuarioDAO.autenticar(request.getParameter("login"), request.getParameter("senha"));
        request.setAttribute("nome", nome);
        
        if(!nome.equalsIgnoreCase("Erro")){
            request.getSession().setAttribute("loginUsuario", request.getParameter("login"));
            request.getRequestDispatcher("main").forward(request, response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        usuarioBean u = new usuarioBean(login, email, nome, senha, 0);
        usuarioDAO.cadastrar(u);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    private void exibeTopico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String codigo = request.getParameter("topico");
        request.setAttribute("codigo", codigo);
        topicoBean topico = topicoDAO.retornaTopico(Integer.parseInt(codigo));
        List<comentarioBean> comentarios = comentarioDAO.todosComentarios(Integer.valueOf(codigo));
        request.setAttribute("topico", topico);
        request.setAttribute("comentarios", comentarios);
        
        request.getRequestDispatcher("jsp/exibeTopico.jsp").forward(request, response);
    }
    
    private void comentar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String comentario = request.getParameter("comentario");
        String codigoTopico = request.getParameter("codigo");
        String loginUsuario = (String) request.getSession().getAttribute("loginUsuario");
        
        comentarioDAO.fazerComentario(comentario, loginUsuario, Integer.valueOf(codigoTopico));
        adicionaPontos(loginUsuario, "3");
        response.sendRedirect("exibeTopico?topico="+codigoTopico);
    }
    
    private void criarTopico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        String loginUsuario = (String) request.getSession().getAttribute("loginUsuario");
        
        topicoBean t = new topicoBean();
        t.setConteudo(conteudo);
        t.setTitulo(titulo);
        t.setUsuario(loginUsuario);
        
        topicoDAO.insereTopico(t);
 
        adicionaPontos(loginUsuario, "10");
        
        request.getRequestDispatcher("main").forward(request, response);     
    }
    
    private void exibeRanking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<usuarioBean> ranking = usuarioDAO.ranking();
        request.setAttribute("ranking", ranking);
        
        request.getRequestDispatcher("jsp/ranking.jsp").forward(request, response);
    }
    
    private void adicionaPontos(String login, String pontos){
        
        usuarioDAO.acrescentaPontos(login, Integer.valueOf(pontos));
    }
}
