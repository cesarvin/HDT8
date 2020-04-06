import java.util.*;
import java.util.stream.Stream;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main { 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PriorityQueue<String> pQueue = new PriorityQueue<String>();
		VectorHeap<String> Heap = new VectorHeap<String>();
		boolean exit = false;
		
		final int[] numberOfPatients = {0};

        System.out.println("--------------------------------------------");
        System.out.println("\nAtención de pacientes. \n");
        System.out.println("--------------------------------------------");
        
        int opcion = 0;
        
        while (!exit){
        	//seleccionar implementación
            System.out.println("Utilizar: \n1. PriorityQueue \n2. VectorHeap \n3. Salir");
            opcion = scan.nextInt();
            final int[] numeroPacientes = {0};
            switch (opcion){
	            case 1:
	                try {
	                	//Java Collection PriorityQueue
	                	//se lee el archivo
	                    FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src" +  "\\pacientes.txt");
	                    BufferedReader br = new BufferedReader(fr);
	                    String[] lista;
	
	                    String cadena = br.readLine();
	                    while (cadena != null) {
	                        lista = cadena.split(",");
	                        
	                        String priority = lista[2].toLowerCase();
	    					String nombre = lista[0].toLowerCase();
	    					String enfermedad = lista[1].toLowerCase();
	    					String paciente = priority+", "+nombre+", "+enfermedad;
	                        
	    					pQueue.add(paciente);
	    
	                        cadena = br.readLine();
	                    }
	                } catch (Exception e){
	                    System.out.println("No se encontro el archivo " + System.getProperty("user.dir") + "\\src" +  "\\pacientes.txt");
	                }
	                //cuando ya se cargo la cola
	                while(!exit) {
						try {
							//submenu de opciones
							System.out.println("Pacientes en cola listos: ");
							System.out.println("1. Ver cola de pacientes \n2. Ver siguiente \n3. Salir" + "\n");
							int subOption = scan.nextInt();
							switch (subOption){
								case 1:
									//se listan los pacientes en cola
									if(!pQueue.isEmpty()) {
										System.out.println(pQueue);
									}
									break;
								case 2:
									//se extrae el siguiente paciente
									if(!pQueue.isEmpty()) {
										System.out.println("Siguiente: ");
										System.out.println(pQueue.poll());
									}
									else {
										System.out.println("No hay más pacientes en cola");
									}
									break;
								case 3:
									exit = true;
									break;
							}
							
						}catch(Exception e) {
							exit = true;
							System.out.println("ocurrio un error");
						}
					}
	                break;
                //VectorHeap
                case 2:
                    try {
                    	//se lee el archivo
                    	FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src" +  "\\pacientes.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String[] lista;

                        String cadena = br.readLine();
                        while (cadena != null) {
                            lista = cadena.split(",");
                            
                            String priority = lista[2].toLowerCase();
        					String nombre = lista[0].toLowerCase();
        					String enfermedad = lista[1].toLowerCase();
        					String paciente = priority+","+nombre+","+enfermedad;
                            
        					Heap.add(paciente);

                            cadena = br.readLine();
                        }
                    } catch (Exception e){
                        System.out.println("No se encontro el archivo " + System.getProperty("user.dir") + "\\src" +  "\\pacientes.txt");
                    }
                    //cuando ya se cargo la cola
                    while(!exit) {
						try {
							
							int count = Heap.size();
							String str[] = new String[count];
							str = Heap.toString(Heap, count);
							//se ordena el heap
							str = Heap.sortS(str, count);
							
							Heap.vp(str, count, Heap);
							
							System.out.println("Pacientes en cola listos: ");
							System.out.println("1. Ver cola de pacientes \n2. Ver siguiente \n3. Salir" + "\n");
							int subOption = scan.nextInt();
							switch (subOption){
								case 1:
									for(int i = 0; i<count; i++) {
										System.out.println("-"+Heap.get(i));
									}
									break;
								case 2:
									if(!Heap.isEmpty()) {
										System.out.println("Siguiente: ");
										System.out.println(Heap.pop() + "\n");	
									}
									else {
										System.out.println("No hay más pacientes en cola");
									}
									break;
								case 3:
									exit = true;
									break;
							}
							
						}catch(Exception e) {
							System.out.println("Ha ingresado algo mal");
						}
					}
                    break;
                
                case 3:
                	exit = false;
                    break;
            }
        }

	}

}