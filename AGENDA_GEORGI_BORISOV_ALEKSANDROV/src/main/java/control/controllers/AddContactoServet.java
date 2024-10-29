package control.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.servicios.ServicioContactos;
import control.servicios.ServicioValidaciones;
import modelo.Contacto;

/**
 * Servlet implementation class AddContactoServet
 */
@WebServlet("/AddContactoServet")
public class AddContactoServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactoServet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ha entrado en el post de add");
		String nombre=request.getParameter("nombreContacto");
		String apellidos=request.getParameter("apellidosContacto");
		String email=request.getParameter("emailContacto");
		String telefonoCadena=request.getParameter("telefonoContacto");
		int telefono=Integer.parseInt(telefonoCadena);
		
		
		//hacer el hashmap con los campos , y la longutud minima de caracteres
		HashMap<String, Integer> camposFormulario = new HashMap<>();
		camposFormulario.put(nombre, 3);       
		camposFormulario.put(apellidos, 3);    
		camposFormulario.put(email, 10);        
		camposFormulario.put(telefonoCadena, 8);   
		
		//validar con el servicio
		ArrayList<String> listaNoValidados= ServicioValidaciones.validarFormularioTexto(camposFormulario);
		if (!listaNoValidados.isEmpty()) {
		    request.setAttribute("noValidados", listaNoValidados);
		}else {
			System.out.println("todo GUAY SE PUEDE INSERTAR");
			int id= ServicioContactos.establecerId();
			Contacto contactoInsert= new Contacto(id, nombre, apellidos, email, telefono);
			if(ServicioContactos.anadirContacto(contactoInsert)) {
				request.setAttribute("mensaje", "Usuario "+nombre+"Añadido Correctamente");
				System.out.println("Usuario Insertado");
			}
		
				
		}
		
		//reedirigir al index de nuevo 
	    //request.getRequestDispatcher("index.jsp").forward(request, response);
	    request.getRequestDispatcher("/").forward(request, response);
	}

}
