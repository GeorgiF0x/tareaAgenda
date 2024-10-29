package control.servicios;


import java.util.ArrayList;
import java.util.HashMap;

public class ServicioValidaciones {
	

		    static public ArrayList<String> validarFormularioTexto(HashMap<String, Integer> camposFormulario) {
				ArrayList<String> camposFallados = new ArrayList<>();
				String cadenaDefectoNull="Rellena el campo";
		        // Validar que cada campo cumpla con la longitud mínima
		        for (String campo : camposFormulario.keySet()) {
		            int longitudMinima = camposFormulario.get(campo);
	
		           
		            if (campo == null || campo.isEmpty()) {
		            	StringBuilder sb = new StringBuilder();
		            	sb.append(cadenaDefectoNull);
		            	sb.append(" ");
		            	sb.append(campo);
		                camposFallados.add(sb.toString() ); 
		            } else if (campo.length() < longitudMinima) {
		                camposFallados.add(campo + " no cumple con la longitud mínima de " + longitudMinima + " caracteres."); // Concatenar información sobre la longitud
		            }
		        }
				return camposFallados;
		    }
	
	
}
