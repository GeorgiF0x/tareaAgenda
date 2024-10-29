package modelo.dao;

import modelo.Agenda;
import modelo.Contacto;

public class ContactoDAO {

	public static Contacto getById(Contacto c) {
		for (Contacto contacto : Agenda.personas) {
			if(c.getId()==contacto.getId()) {
				return contacto;
			}
		}
		return null;
	}
	
	public static Contacto updateContacto(Contacto c) {
		Contacto contactoActualizado=null;
		for (Contacto contacto : Agenda.personas) {
			
			if(c.getId()==contacto.getId()) {
				contacto.setNombre(c.getNombre());
				contacto.setApellidos(c.getApellidos());
				contacto.setEmail(c.getEmail());
				contacto.setNumTelefono(c.getNumTelefono());
				contactoActualizado=contacto;
			}
			
		}
		return contactoActualizado;
		
	}
	
	public static boolean delete(int id) {
		boolean borrado=false;
		for (Contacto contacto : Agenda.personas) {
			if(id==contacto.getId()) {
				borrado=true;
			}
		}
		return borrado ;
	}
	
	public static boolean insert(Contacto c) {
		Agenda.personas.add(c);
		return true;
	}
	
	public static int getLastId() {
	    int maxId = 0; 
	    for (Contacto c : Agenda.personas) {
	        if (c.getId() > maxId) {
	            maxId = c.getId();  // se actualiza en cada vuelta hasta igualar a la ultima
	        }
	    }
	    return maxId; 
	}
	
	
}
