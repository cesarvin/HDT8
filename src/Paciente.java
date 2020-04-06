
import java.util.*;

public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private String enfermedad;
    private Character prioridad;

    public Paciente(String nombre, String enfermedad, Character priority){
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.prioridad = priority;
    }
    
    public String getNombre() { 
    	return nombre;
    }
    
    public String getEnfermedad() { 
    	return enfermedad; 
    }

    public char getPrioridad() { 
    	return prioridad; 
    }

    @Override
    public int compareTo(Paciente p2) {
        int result = 0;
        if (this.prioridad<p2.prioridad) {
            result= -1;
        }
        else if (this.prioridad> p2.prioridad) {
            result = 1;
        }
        return result;
    }
}