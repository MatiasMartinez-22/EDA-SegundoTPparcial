package eda.segundotpparcial;

import java.util.ArrayList;
import java.util.Scanner;

public class EDASegundoTPparcial {

    public static void main(String[] args) {

        Grafo grafo = new Grafo(5, 4, false);

//        grafo.agregarArco(0, 1, 10, 2);
//        grafo.agregarArco(0, 2, 20, 3);
//        grafo.agregarArco(1, 2, 30, 2);
//        grafo.agregarArco(2, 3, 40, 4);
//        
        int[] distancias = grafo.dijkstra(0); // desde el nodo 0
        ArrayList<String> ciudades = new ArrayList();

        System.out.println("Distancias mínimas desde la ciudad 0:");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("0 → " + i + ": " + (distancias[i] >= 1000 ? "∞" : distancias[i] + " km"));
        }

        grafo.flujoMaximo(0);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Creación automática");
            System.out.println("2. Ingreso de ciudades");
            System.out.println("3. Ingreso caminos");
            System.out.println("4. Consultar costo entre dos ciudades (por carril o distancia)");
            System.out.println("5. Consultar distancias entre ciudades");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Cargando datos predefinidos...");
                    ciudades.add("BuenosAires");
                    ciudades.add("SanMartin");
                    ciudades.add("SanLuis");
                    ciudades.add("VillaMercedes");
                    grafo.agregarArco(0, 1, 10, 2);
                    grafo.agregarArco(0, 2, 20, 3);
                    grafo.agregarArco(1, 2, 30, 2);
                    grafo.agregarArco(2, 3, 40, 4);
                    System.out.println("Datos cargados exitosamente.");
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
                    System.out.println("Ingrese índice de la ciudad origen:");
                    int origenCosto = scanner.nextInt();
                    System.out.println("Ingrese índice de la ciudad destino:");
                    int destinoCosto = scanner.nextInt();
                    Camino camino = grafo.comprobarArco(origenCosto, destinoCosto);

                    if (camino.getDistancia() >= 1000) {
                        System.out.println("No hay conexión entre las ciudades.");
                    } else {
                        System.out.println("de " + ciudades.get(origenCosto) + " a " + ciudades.get(destinoCosto) );
                        System.out.println("Distancia: " + camino.getDistancia() + " km");
                        System.out.println("Carriles: " + camino.getCarriles());
                    }
                    break;

                case 5:
                    if (ciudades.size() < 2) {
                        System.out.println("Debe ingresar al menos dos ciudades para consultar distancias.");
                        break;
                    }

                    System.out.println("Ingrese índice de la ciudad de origen:");
                    int origenDistancia = scanner.nextInt();
                    int[] distanciasDijkstra = grafo.dijkstra(origenDistancia);

                    System.out.println("Distancias desde " + ciudades.get(origenDistancia) + ":");
                    for (int i = 0; i < distanciasDijkstra.length; i++) {
                        if (i == origenDistancia) {
                            continue;
                        }
                        if (distanciasDijkstra[i] >= 1000) {
                            System.out.println("-> " + ciudades.get(i) + ": Sin conexión");
                        } else {
                            System.out.println("-> " + ciudades.get(i) + ": " + distanciasDijkstra[i] + " km");
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
