package modelo;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private ArrayList<Contacto> personas;

    public Agenda() {
        personas = new ArrayList<>(); 
    }
    
    
    public void addContacto(Contacto c) {
    	this.personas.add(c);
    }
    
    public ArrayList<Contacto> getPersonas() {
        return personas;
    }
    
    


   
}
