package control.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.Agenda;
import modelo.Contacto;

/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ha entrado en get");
      
		doPost(request, response);
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ha entrado en el post");

        
        //rellenar contactos
       Agenda.inicializarAgenda();
        // Enviar solo la lista de contactos al JSP
        ArrayList<Contacto> listaContactos = Agenda.getPersonas();
        request.setAttribute("contactos", listaContactos); 
        
        // ir al index 
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
