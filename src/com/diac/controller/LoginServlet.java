package com.diac.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diac.dao.UsuarioDAO;
import com.diac.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
          
        Usuario user = new Usuario();
        user.setUnome(request.getParameter("name"));  
        user.setPass(request.getParameter("password"));  
          
        if(request.getParameter("name") != null){
        
        	UsuarioDAO userdao = new UsuarioDAO();
        	userdao.checkUsuario(user);
        	
	        if(userdao.getCount() > 0){  
	        HttpSession session=request.getSession();  
	        session.setAttribute("name",user.getUnome());  
	        response.sendRedirect("profile.jsp");
	        }  
	        else{  
	            out.print("Nome do Usuario ou Palavra passe Incorrecto");  
	            request.getRequestDispatcher("login.jsp").include(request, response);  
	        }  
	        out.close();  
        }
	}
}
