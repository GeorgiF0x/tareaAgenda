package modelo;

import java.util.ArrayList;

public class Agenda {

    public static ArrayList<Contacto> personas = new ArrayList<>();

    // Método para añadir contactos predefinidos a la agenda
    public static void inicializarAgenda() {
        personas.add(new Contacto(1, "Juan", "Pérez", "juan.perez@example.com", 600000001));
        personas.add(new Contacto(2, "Ana", "García", "ana.garcia@example.com", 600000002));
        personas.add(new Contacto(3, "Luis", "Martínez", "luis.martinez@example.com", 600000003));
        personas.add(new Contacto(4, "María", "López", "maria.lopez@example.com", 600000004));
        personas.add(new Contacto(5, "Carlos", "Hernández", "carlos.hernandez@example.com", 600000005));
        personas.add(new Contacto(6, "Laura", "González", "laura.gonzalez@example.com", 600000006));
        personas.add(new Contacto(7, "José", "Rodríguez", "jose.rodriguez@example.com", 600000007));
        personas.add(new Contacto(8, "Elena", "Sánchez", "elena.sanchez@example.com", 600000008));
        personas.add(new Contacto(9, "Miguel", "Ramírez", "miguel.ramirez@example.com", 600000009));
        personas.add(new Contacto(10, "Isabel", "Torres", "isabel.torres@example.com", 600000010));
    }


    public static ArrayList<Contacto> getPersonas() {
        return personas;
    }
}
