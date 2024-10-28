package control.servicios;

import java.util.ArrayList;
import java.util.List;

import modelo.Agenda;
import modelo.Contacto;

public class AgendaServicios {
	
	public static Agenda devolverAgenda() {
		 Agenda agenda= new Agenda();
		 ArrayList <Contacto>listaContactos= crearContactos();
		 
		 for (Contacto contacto : listaContactos) {
			agenda.addContacto(contacto);
		}
		 
		return agenda;
		 
	 }
	 private static ArrayList<Contacto> crearContactos() {
		 ArrayList<Contacto> listaContactos = new ArrayList<>();
		 
		 listaContactos.add(new Contacto("Juan", "Pérez", "juan.perez@example.com", 600000001));
		 listaContactos.add(new Contacto("Ana", "García", "ana.garcia@example.com", 600000002));
		 listaContactos.add(new Contacto("Luis", "Martínez", "luis.martinez@example.com", 600000003));
		 listaContactos.add(new Contacto("María", "López", "maria.lopez@example.com", 600000004));
		 listaContactos.add(new Contacto("Carlos", "Hernández", "carlos.hernandez@example.com", 600000005));
		 listaContactos.add(new Contacto("Laura", "González", "laura.gonzalez@example.com", 600000006));
		 listaContactos.add(new Contacto("José", "Rodríguez", "jose.rodriguez@example.com", 600000007));
		 listaContactos.add(new Contacto("Elena", "Sánchez", "elena.sanchez@example.com", 600000008));
		 listaContactos.add(new Contacto("Miguel", "Ramírez", "miguel.ramirez@example.com", 600000009));
		 listaContactos.add(new Contacto("Isabel", "Torres", "isabel.torres@example.com", 600000010));
		 
		 return listaContactos;
	 }
	 
	 
	
	

}
