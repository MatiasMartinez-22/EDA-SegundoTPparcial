
package eda.segundotpparcial;



public class EDASegundoTPparcial {

    
    public static void main(String[] args) {
        
        Grafo grafo = new Grafo(5, 4, false);
        
        grafo.agregarArco(0, 1, 10, 2);
        grafo.agregarArco(0, 2, 20, 3);
        grafo.agregarArco(1, 2, 30, 2);
        grafo.agregarArco(2, 3, 40, 4);
        
        grafo.mostrarMatriz();
        
        
        int[] distancias = grafo.dijkstra(0); // desde el nodo 0

        System.out.println("Distancias mínimas desde la ciudad 0:");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("0 → " + i + ": " + (distancias[i] >= 1000 ? "∞" : distancias[i] + " km"));
        }

        grafo.flujoMaximo(0);
        
    
    
        
    }
}