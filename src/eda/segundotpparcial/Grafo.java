
package eda.segundotpparcial;

import java.util.ArrayList;

public class Grafo {
    
 
     private Camino matriz[][];
    private int maxVertices;
    private int numVertices;
    private boolean dirigido;

    public Grafo(int maxVertices, int numVertices, boolean dirigido) {

        //No se admitiran numero negativos
        if (maxVertices <= 0) {
            throw new IllegalArgumentException("El numero maximo de vertices no puede ser cero ni negativo");
        }
        if (numVertices <= 0) {
            throw new IllegalArgumentException("El numero de vertices no puede ser cero ni negativo");
        }

        //Impedimos sobrepasar el numero de vertices maximo
        if (numVertices > maxVertices) {
            throw new IllegalArgumentException("Numero de vertices no puede ser mayor al numero maximo de vertices permitido");
        }

        this.maxVertices = maxVertices;
        this.numVertices = numVertices;
        //La matriz por defecto tiene sus posiciones en en los atributos seteado en infinito
        this.matriz = new Camino[maxVertices][maxVertices];
        for (int i = 0; i < maxVertices; i++) {

            for (int j = 0; j < maxVertices; j++) {
                Camino camino=new Camino();
                matriz[i][j]=camino;

            }

        }
        //aca en la diagonal pondremos en 0 los atributos
         for (int i = 0; i < maxVertices; i++) {

            for (int j = 0; j < maxVertices; j++) {
                if(i==j){
                    matriz[i][j].setDistancia(0) ;
                    matriz[i][j].setCarriles(0);
                }
    
            }

        }

        this.dirigido = dirigido;
    }

    //Para agregar vertices si es posible
    public void agregarVertice() {
        if (numVertices == maxVertices) {
            System.out.println("No se pueden agragar mas vertices");
            return;
        }
        numVertices++;
    }

    //Utilizamos este metodo para comprobar si un indice representa un vertice en el grafo
    public boolean comprobarVertice(int i) {
        //el vertice buscado estara representando una posicion en la matriz debe
        //ser siempre menor al numero total de vertices (tamaño de la matriz)
        if (i >= 0 && i < numVertices) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarArco(int i, int j, int distancia,int carriles) {
        //Usamos el metodo auxiliar que comprueba la existencia del vertice
        if (!comprobarVertice(i)) {
            throw new IllegalArgumentException("El vertice " + i + " no existe");
        }
        if (!comprobarVertice(j)) {
            throw new IllegalArgumentException("El vertice " + j + " no existe");
        }

        //establecemos la posicion i j en representacion de una arista (union de vertice i --> j) en true
        matriz[i][j].setCarriles(carriles);
        matriz[i][j].setDistancia(distancia);

        //Si el grafo es NO dirigido i---j es lo mismo que j---i
        if (!dirigido) {
            matriz[j][i].setCarriles(carriles);
            matriz[j][i].setDistancia(distancia);
        }
    }

    public Camino comprobarArco(int i, int j) {
        if (!comprobarVertice(i)) {
            throw new IllegalArgumentException("El vertice " + i + " no existe");
        }
        if (!comprobarVertice(j)) {
            throw new IllegalArgumentException("El vertice " + j + " no existe");
        }
        return matriz[i][j];
    }

    public void eliminarArco(int i, int j) {
        //Usamos el metodo auxiliar que comprueba la existencia del vertice
        if (!comprobarVertice(i)) {
            throw new IllegalArgumentException("El vertice " + i + " no existe");
        }
        if (!comprobarVertice(j)) {
            throw new IllegalArgumentException("El vertice " + j + " no existe");
        }

        //establecemos la posicion i j en representacion de una arista (union de vertice i --> j) en true
        matriz[i][j].setCarriles(1000);
        matriz[i][j].setDistancia(1000);

        //Si el grafo es NO dirigido i---j es lo mismo que j---i
        if (!dirigido) {
            matriz[j][i].setCarriles(1000);
            matriz[j][i].setDistancia(1000);
        }
    }
    
     public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia:");

        // Imprime encabezado de columnas
        System.out.print("    ");
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        // Imprime separador
        System.out.print("    ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("---");
        }
        System.out.println();

        // Imprime cada fila de la matriz
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%2d |", i);
            for (int j = 0; j < numVertices; j++) {
                System.out.print(" " + (matriz[i][j]) + " ");
            }
            System.out.println();
        }
    }
    
    public int[] dijkstra(int origen) {       
    int[] dist = new int[numVertices];            // distancias mínimas
    boolean[] visitado = new boolean[numVertices]; // vértices ya procesados

    // Inicialización
    for (int i = 0; i < numVertices; i++) {
        dist[i] = matriz[origen][i].getDistancia(); // distancia directa
        visitado[i] = false;
    }

    dist[origen] = 0; // distancia a sí mismo es 0
    visitado[origen] = true;

    for (int k = 1; k < numVertices; k++) {
        int min = Integer.MAX_VALUE;
        int v = -1;
        // Encontrar el nodo no visitado con menor distancia
        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i] && dist[i] < min) {
                min = dist[i];
                v = i;
            }
        }

        if (v == -1) break; // No hay más vértices accesibles
        visitado[v] = true;

        // Actualizar distancias
        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i] && matriz[v][i].getDistancia() < 1000) {
                if (dist[i] > dist[v] + matriz[v][i].getDistancia()) {
                    dist[i] = dist[v] + matriz[v][i].getDistancia();
                }
            }
        }
    }
    return dist;
}
    
    
    
    
    public void flujoMaximo(int origen) {
    int[] flujo = new int[numVertices];
    boolean[] visitado = new boolean[numVertices];

    // Paso 1: Inicialización
    for (int i = 0; i < numVertices; i++) {
        flujo[i] = 0; // 0 indica que aún no hay flujo
        visitado[i] = false;
    }

    // Paso 2: El flujo al origen es máximo posible (inicialmente)
    flujo[origen] = 1000; // o Integer.MAX_VALUE, si tu sistema lo permite

    // Paso 3: Bucle de Dijkstra adaptado para flujo máximo
    for (int i = 0; i < numVertices; i++) {
        // Elegir el nodo no visitado con mayor flujo
        int maxFlujo = -1;
        int v = -1;

        for (int j = 0; j < numVertices; j++) {
            if (!visitado[j] && flujo[j] > maxFlujo) {
                maxFlujo = flujo[j];
                v = j;
            }
        }

        if (v == -1) break; // No hay más nodos alcanzables

        visitado[v] = true;

        // Ver todos los vecinos no visitados
        for (int z = 0; z < numVertices; z++) {
            if (!visitado[z]) {
                int carriles = matriz[v][z].getCarriles();
                if (carriles < 1000) { // Hay conexión válida
                    int nuevoFlujo = Math.min(flujo[v], carriles);
                    if (nuevoFlujo > flujo[z]) {
                        flujo[z] = nuevoFlujo;
                    }
                }
            }
        }
    }

    // Paso 4: Mostrar resultados
    System.out.println("\nFlujo máximo (mínimo de carriles) desde ciudad " + origen + ":");
   
    for (int i = 0; i < numVertices; i++) {
        if (flujo[i] == 0 && i != origen) {
            System.out.println(origen + " -> " + i + ": Sin conexión");
        } else {
            if (i == origen) {
    System.out.println(origen + " → " + i + ": - (mismo nodo)");
            }else{
                            System.out.println(origen + " -> " + i + ": " + flujo[i] + " carriles");

            }
        }
    }
}

    
    

}