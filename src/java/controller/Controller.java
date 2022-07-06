package controller;

import Model.topicoBean;
import Model.topicosDAO;
import Model.usuarioBean;
import Model.usuarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/autenticar", "/cadastrar"})
public class Controller extends HttpServlet {

    usuarioDAO usuarioDAO = new usuarioDAO();  
    topicosDAO topicoDAO = new topicosDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        switch(request.getServletPath()){
            
            case "/autenticar":
                autenticar(request, response);
                break;
                
            case "/cadastrar":
                cadastrar(request, response);
                break;
        }
    }
    
    private void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nome = usuarioDAO.autenticar(request.getParameter("login"), request.getParameter("senha"));
        request.setAttribute("nome", nome);
        
        if(!nome.equalsIgnoreCase("Erro")){
            List<topicoBean> lista = topicoDAO.todosTopicos(request.getParameter("login"));
            request.setAttribute("topicos", lista);
            request.getRequestDispatcher("jsp/topicos.jsp").forward(request, response);
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
}
