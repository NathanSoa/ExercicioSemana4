package controller;

import Model.usuarioBean;
import Model.usuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "Controller", urlPatterns = {"/autenticar", "/cadastrar"})
public class Controller extends HttpServlet {

    usuarioDAO dao = new usuarioDAO();    
    
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
        String nome = dao.autenticar(request.getParameter("login"), request.getParameter("senha"));
        request.setAttribute("nome", nome);
        
        if(!nome.equalsIgnoreCase("Erro")){
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
        
        JOptionPane.showMessageDialog(null, login);
        JOptionPane.showMessageDialog(null, nome);
        JOptionPane.showMessageDialog(null, email);
        JOptionPane.showMessageDialog(null, senha);
        
        usuarioBean u = new usuarioBean(login, email, nome, senha, 0);
        dao.cadastrar(u);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
