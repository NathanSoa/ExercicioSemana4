package controller;

import Model.usuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/autenticar"})
public class Controller extends HttpServlet {

    usuarioDAO dao = new usuarioDAO();    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch(request.getServletPath()){
            
            case "/autenticar":
                String nome = dao.autenticar(request.getParameter("login"), request.getParameter("senha"));
                request.setAttribute("nome", nome);
                if(!nome.equalsIgnoreCase("Erro")){
                    request.getRequestDispatcher("jsp/topicos.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
        }
    }
}
