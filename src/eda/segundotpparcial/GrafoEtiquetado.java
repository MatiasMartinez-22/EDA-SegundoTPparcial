
package eda.segundotpparcial;

import java.util.ArrayList;

public class GrafoEtiquetado {
     private Camino[][] matrizCamino;
     private Camino[][] matrizCaminoDistancia;

    private int maxCiudad; //maximo de ciudades que ingrese el usuario
    private int numCiudad; //cantidad de ciudades que ingrese el usuario
    private boolean dirigido;

    public GrafoEtiquetado(int maxVertices, int numVertices, boolean dirigido) {

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

        this.maxCiudad = maxVertices;
        this.numCiudad = numVertices;
        //La matriz por defecto tiene sus posiciones en falso
        this.matrizCamino = new Camino[maxVertices][maxVertices];
        for (int i = 0; i < maxVertices; i++) {

            for (int j = 0; j < maxVertices; j++) {
                matrizCamino[i][j] = null;
            }

        }

        this.dirigido = dirigido;
    }

    //Para agregar vertices si es posible
    public void agregarVertice() {
        if (numCiudad == maxCiudad) {
            System.out.println("No se pueden agragar mas vertices");
            return;
        }
        numCiudad++;
    }

    //Utilizamos este metodo para comprobar si un indice representa un vertice en el grafo
    public boolean comprobarVertice(int i) {
        //el vertice buscado estara representando una posicion en la matriz debe
        //ser siempre menor al numero total de vertices (tamaño de la matriz)
        if (i >= 0 && i < numCiudad) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarArco(int i, int j, Camino etiqueta) {
        //Usamos el metodo auxiliar que comprueba la existencia del vertice
        if (!comprobarVertice(i)) {
            throw new IllegalArgumentException("El vertice " + i + " no existe");
        }
        if (!comprobarVertice(j)) {
            throw new IllegalArgumentException("El vertice " + j + " no existe");
        }

        //establecemos la posicion i j en representacion de una arista (union de vertice i --> j) en true
        matrizCamino[i][j] = etiqueta;

        //Si el grafo es NO dirigido i---j es lo mismo que j---i
        if (!dirigido) {
            matrizCamino[j][i] = etiqueta;
        }
    }

    public Camino comprobarArco(int i, int j) {
        if (!comprobarVertice(i)) {
            throw new IllegalArgumentException("El vertice " + i + " no existe");
        }
        if (!comprobarVertice(j)) {
            throw new IllegalArgumentException("El vertice " + j + " no existe");
        }
        return matrizCamino[i][j];
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
        matrizCamino[i][j] = null;

        //Si el grafo es NO dirigido i---j es lo mismo que j---    public void dijkstra(int origen) {i
        if (!dirigido) {
            matrizCamino[j][i] = null;
        }
    }
    
//
//    int[] distancias = new int[numCiudad]; // distancias mínimas desde el origen
//    boolean[] visitado = new boolean[numCiudad]; // si ya visité ese nodo
//    int[] anterior = new int[numCiudad]; // para guardar el camino
//    
//    
//
//    // Inicializar
//    for (int i = 0; i < numCiudad; i++) {
//        distancias[i] = Integer.MAX_VALUE; // infinito
//        visitado[i] = false;
//        anterior[i] = -1; // sin previo
//    }
//
//     distancias[origen] = 0; // distancia desde el origen a sí mismo es 0
//
//    for (int i = 0; i < numCiudad - 1; i++) {
//        // Elegir el nodo no visitado con menor distancia
//        int u = -1;
//        int minDistancia = Integer.MAX_VALUE;
//
//        for (int j = 0; j < numCiudad; j++) {
//            if (!visitado[j] && distancias[j] < minDistancia) {
//                u = j;
//                minDistancia = distancias[j];
//            }
//        }
//
//        if (u == -1) break; // si no se encontró, corto
//
//        visitado[u] = true;
//
//        // Actualizar las distancias de los vecinos de u
//        for (int v = 0; v < numCiudad; v++) {
//                       
//            Camino camino = matrizCamino[u][v];
//            if (camino != null && !visitado[v]) {
//                int nuevaDistancia = distancias[u] + camino.getDistancia();
//                if (nuevaDistancia < distancias[v]) {
//                    distancias[v] = nuevaDistancia;
//                    anterior[v] = u;
//                }
//            }
//        }
//    }
//
//    // Mostrar resultados
//    System.out.println("Distancias mínimas desde la ciudad " + origen + ":");
//    for (int i = 0; i < numCiudad; i++) {
//        if (distancias[i] == Integer.MAX_VALUE) {
//            System.out.println("Ciudad " + i + " es inalcanzable");
//        } else {
//            System.out.print("Ciudad " + i + " - Distancia: " + distancias[i] + " km");
//
//            // Mostrar el camino
//            System.out.print(" - Camino: ");
//            mostrarCamino(anterior, i);
//            System.out.println();
//        }
//    }
//}
     
     
//     private void mostrarCamino(int[] anterior, int destino) {
//    if (anterior[destino] == -1) {
//        System.out.print(destino);
//        return;
//    }
//    mostrarCamino(anterior, anterior[destino]);
//    System.out.print(" -> " + destino);
//}
     
     
     public void dijkstra2(int origen){
     
        Camino[] D = new Camino[numCiudad];        
        ArrayList <Integer> T = new ArrayList<>();
               
        for(int i=0; i < numCiudad; i++){       
            D[i] = matrizCamino[origen][i];
            
            //veo si el valor i es distinto al origen para agregarlo a la lista T de los vertices a tratar 
            if(i!=origen){
                T.add(i); //agrego todos menos el indice origen
//                System.out.println("T:" + T);
                }           
            }  
        
        //int origen =2 (berazategui)
        //suponemos que T=[0,1,3]  y D=[1000,70,0,35]
         while(!T.isEmpty()){
             
            int v = -1;
            int distanciaMinima = Integer.MAX_VALUE; //la distancia minima empieza con un num grande 
            
            for (int i = 0; i < T.size(); i++) {
                int var = T.get(i);
                
                if (D[var] != null && D[var].getDistancia() < distanciaMinima) {
                    distanciaMinima = D[var].getDistancia();
                    v = var;
                }     
             }
            
             System.out.println("v:" + v);
            T.remove((Integer)v); //eliminaria el vertice 3
            
            int i =0;
            
          while(T.get(i)!= null){
              
              for(i = 0;i < T.size(); i++ ){   
                System.out.println("Tamaño lista:" + T.size());
                
                    int z = T.get(i);

                     System.out.println("z:" + z);

                     if(D[z] != null && matrizCamino[v][z] != null){    
                         if(D[z].getDistancia() > D[v].getDistancia() + matrizCamino[v][z].getDistancia()){

                             int nuevaDistancia = D[v].getDistancia() + matrizCamino[v][z].getDistancia();
                             D[z] = new Camino(nuevaDistancia);

                               }

                           }
                
//                     i++;
                     System.out.println("i:" + i);
                 }
            }

        }
         
         
//         System.out.println("Distancias mínimas desde el vértice " + origen + ":");
//            for (int i = 0; i < numCiudad; i++) {
//                if (D[i].getDistancia() == Integer.MAX_VALUE) {
//                    System.out.println("A " + i + ": Inalcanzable");
//                } else {
//                    System.out.println("A " + i + ": " + D[i].getDistancia());
//                }
//            }
        
        
     } //FIN Dijkstra
        

  
    public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia:");

        // Imprime encabezado de columnas
        System.out.print("    ");
        for (int i = 0; i < numCiudad; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        // Imprime separador
        System.out.print("    ");
        for (int i = 0; i < numCiudad; i++) {
            System.out.print("---");
        }
        System.out.println();

        // Imprime cada fila de la matriz
        for (int i = 0; i < numCiudad; i++) {
            System.out.printf("%2d |", i);
            for (int j = 0; j < numCiudad; j++) {
                System.out.print(" " + (matrizCamino[i][j]) + " ");
            }
            System.out.println();
        }
    }
    

//     public void dijkstra(int origen) {
//        Camino[] D = new Camino[4]; // distancias mínimas
//        boolean[] visitado = new boolean[4];
//        ArrayList<Integer> T = new ArrayList<>();
//
//        // Inicializamos las distancias
//        for (int i = 0; i < 4; i++) {
//            D[i] = matrizCamino[origen][i];
//            if (i != origen) {
//                T.add(i); // Agregamos todos menos el origen a T
//            }
//        }
//
//        D[origen] = null;
//        visitado[origen] = true;
//     }
     
        
//   public void dijkstra(int origen) {
//    int[] distancias = new int[numCiudad]; // distancias mínimas desde el origen
//    boolean[] visitado = new boolean[numCiudad]; // si ya visité ese nodo
//    int[] anterior = new int[numCiudad]; // para guardar el camino
//
//    // Inicializar
//    for (int i = 0; i < numCiudad; i++) {
//        distancias[i] = Integer.MAX_VALUE; // infinito
//        visitado[i] = false;
//        anterior[i] = -1; // sin previo
//    }
//
//     distancias[origen] = 0; // distancia desde el origen a sí mismo es 0
//
//    for (int i = 0; i < numCiudad - 1; i++) {
//        // Elegir el nodo no visitado con menor distancia
//        int u = -1;
//        int minDistancia = Integer.MAX_VALUE;
//
//        for (int j = 0; j < numCiudad; j++) {
//            if (!visitado[j] && distancias[j] < minDistancia) {
//                u = j;
//                minDistancia = distancias[j];
//            }
//        }
//    
//        if (u == -1) break; // si no se encontró, corto
//
//
//        visitado[u] = true;
//            for (int z : T) {
//                if (matrizCamino[v][z].getDistancia() != Integer.MAX_VALUE && D[z].getDistancia() > D[v].getDistancia() + matrizCamino[v][z].getDistancia()) {
////                    D[z]. = D[v].getDistancia() + matrizCamino[v][z].getDistancia();
//                     D[z].setDistancia( D[v].getDistancia() + matrizCamino[v][z].getDistancia());
//                }
//            }
//        }
//
//        // Mostrar resultados
//        System.out.println("Distancias mínimas desde ciudad " + origen + ":");
//        for (int i = 0; i < 4; i++) {
//            System.out.println("→ Ciudad " + i + ": " + (D[i].getDistancia() == Integer.MAX_VALUE ? "∞" : D[i]));
//        }
//    }
//   
//   
//
//     private int indiceMinimo(Camino[] D, ArrayList<Integer> T) {
//        int minValor = Integer.MAX_VALUE;
//        int minIndice = -1;
//        for (int nodo : T) {
//            if (D[nodo].getDistancia() < minValor ) {
//                minValor = D[nodo].getDistancia();
//                minIndice = nodo;
//            }
//
//        // Actualizar las distancias de los vecinos de u
//        for (int v = 0; v < numCiudad; v++) {
//            Camino camino = matriz[u][v];
//            if (camino != null && !visitado[v]) {
//                int nuevaDistancia = distancias[u] + camino.getDistancia();
//                if (nuevaDistancia < distancias[v]) {
//                    distancias[v] = nuevaDistancia;
//                    anterior[v] = u;
//                }
//            }
//        }
//    }
//
//    // Mostrar resultados
//    System.out.println("Distancias mínimas desde la ciudad " + origen + ":");
//    for (int i = 0; i < numCiudad; i++) {
//        if (distancias[i] == Integer.MAX_VALUE) {
//            System.out.println("Ciudad " + i + " es inalcanzable");
//        } else {
//            System.out.print("Ciudad " + i + " - Distancia: " + distancias[i] + " km");
//
//            // Mostrar el camino
//            System.out.print(" - Camino: ");
//            mostrarCamino(anterior, i);
//            System.out.println();
//
//             }
//        }
//     }  
}