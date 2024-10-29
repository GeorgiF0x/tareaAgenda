package control.servicios;

import modelo.Contacto;
import modelo.dao.ContactoDAO;

public class ServicioContactos {

	
	static public int establecerId() {
		
		return ContactoDAO.getLastId()+1;
		
	}
	
	static public boolean anadirContacto(Contacto c) {
		boolean insertado=false;
		if(ContactoDAO.insert(c)) {
			insertado=true;
		}
		return insertado;
	}
}
