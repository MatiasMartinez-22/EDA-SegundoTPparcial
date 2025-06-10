package eda.segundotpparcial;

import java.util.ArrayList;
import java.util.Scanner;

public class EDASegundoTPparcial {

    public static void main(String[] args) {
        
        Grafo grafo = new Grafo(10, 5, false);


        ArrayList<String> ciudades = new ArrayList();


        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- Menú ---");
            System.out.println("1. Creación automática");
            System.out.println("2. Ingreso de ciudades");
            System.out.println("3. Ingreso caminos");
            System.out.println("4. Consultar costos entre dos ciudades (por carril y distancia)");
            System.out.println("5. Consultar costos desde una ciudad al resto");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Cargando datos predefinidos...");
                    ciudades.add("La Toma"); //0
                    ciudades.add("San Martin"); //1
                    ciudades.add("San Luis"); //2 
                    ciudades.add("Quines"); //3
                    ciudades.add("La Punta"); //4
                    
                    
                    grafo.agregarArco(0, 1, 76, 2);
                    grafo.agregarArco(0, 2, 95, 2);
                    grafo.agregarArco(2, 4, 20, 3);
                    grafo.agregarArco(2, 3, 171, 2);
                    grafo.agregarArco(1, 3, 30, 1);
                    System.out.println("Datos cargados exitosamente");
                    break;

                case 2:
                    System.out.println("Ingrese el nombre de la ciudad:");
                    scanner.nextLine(); // limpiar buffer
                    String ciudadNueva = scanner.nextLine();
                    ciudades.add(ciudadNueva);
                
                    grafo.agregarVertice();
                    System.out.println("Ciudad registrada exitosamente.");
                    break;

                case 3:
                    
                    System.out.println("Ciudades del grafo Actual");
                    
                    for (int i = 0; i < ciudades.size(); i++) {
                        System.out.print(ciudades.get(i) + " indice : "+i +" | " );
                    }
                    
                    System.out.println("");
                    System.out.println("Ingrese el índice de la ciudad origen:");
                    int origen = scanner.nextInt();
                    System.out.println("Ingrese el índice de la ciudad destino:");
                    int destino = scanner.nextInt();
                    System.out.println("Ingrese la distancia (km):");
                    int distancia = scanner.nextInt();
                    System.out.println("Ingrese la cantidad de carriles:");
                    int carriles = scanner.nextInt();

                    try {
                        grafo.agregarArco(origen, destino, distancia, carriles);
                        System.out.println("Camino registrado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    
                     System.out.println("Ciudades del grafo Actual");
                    
                    for (int i = 0; i < ciudades.size(); i++) {
                        System.out.print(ciudades.get(i) + " indice : "+i +" | " );
                    }
                    
                    System.out.println(" ");
                    
                    System.out.println("Ingrese índice de la ciudad origen:");
                    int origenCosto = scanner.nextInt();
                    System.out.println("Ingrese índice de la ciudad destino:");
                    int destinoCosto = scanner.nextInt();
                    int[] distanciasDijkstra1 = grafo.dijkstra(origenCosto);
                   int[] distanciasFlujo = grafo.flujoMaximo(origenCosto);
                    System.out.println("Costos Desde " + ciudades.get(origenCosto) + "  " + " hasta:  "+ ciudades.get(destinoCosto) );
                     
                      
                        if (distanciasDijkstra1[destinoCosto] >= 1000 ||  distanciasFlujo[destinoCosto] ==0) {
                            System.out.println("-> " + ciudades.get(destinoCosto) + ": Sin conexión ");
                        } else {
                            System.out.println("-> " + "Ruta mas corta " + ": " + distanciasDijkstra1[destinoCosto] + " km" + " - la ruta con mayor capacidad de flujo  "+distanciasFlujo[destinoCosto]+" carriles ");
                        }

                    break;
                    

                case 5:
                    
                    if (ciudades.size() < 2) {
                        System.out.println("Debe ingresar al menos dos ciudades para consultar distancias.");
                        break;
                    }
                    
                       System.out.println("Ciudades del grafo Actual");
                    
                    for (int i = 0; i < ciudades.size(); i++) {
                        System.out.print(ciudades.get(i) + " indice : "+i +" | " );
                    }
                    
                    System.out.println(" ");
                    
                    System.out.println("Ingrese índice de la ciudad origen:");
                    int origenCosto1 = scanner.nextInt();
                   
                   
                  
                    int[] distanciasDijkstra = grafo.dijkstra(origenCosto1);
                   int[] distanciasFlujo1 = grafo.flujoMaximo(origenCosto1);
                    System.out.println("Costos Desde " + ciudades.get(origenCosto1) );
                     
                      
                    for (int i = 0; i < distanciasDijkstra.length; i++) {
                        if (i == origenCosto1) {
                            continue;
                        }
                      if (distanciasDijkstra[i] >= 1000 ||  distanciasFlujo1[i] ==0) {
                            System.out.println("-> " + ciudades.get(i) + ": Sin conexión ");
                        } else {
                            System.out.println(ciudades.get(i) +"-> " + "Ruta mas corta " + ": " + distanciasDijkstra[i] + " km" + " - la ruta con mayor capacidad de flujo  "+distanciasFlujo1[i]+" carriles ");
                        }
                    
                    }

                  
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
