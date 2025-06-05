/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda.segundotpparcial;

import java.util.ArrayList;

/**
 *
 * @author Matias
 */
public class GrafoEtiquetado {
     private Camino matriz[][];
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
        this.matriz = new Camino[maxVertices][maxVertices];
        for (int i = 0; i < maxVertices; i++) {

            for (int j = 0; j < maxVertices; j++) {
                matriz[i][j] = null;
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
        matriz[i][j] = etiqueta;

        //Si el grafo es NO dirigido i---j es lo mismo que j---i
        if (!dirigido) {
            matriz[j][i] = etiqueta;
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
        matriz[i][j] = null;

        //Si el grafo es NO dirigido i---j es lo mismo que j---i
        if (!dirigido) {
            matriz[j][i] = null;
        }
    }

//    public int gradoSaliente(int i) {
//        //(v,w) v ---> w  v=i w=j i=filas y j=columnas  0, 1, 2, 3  (0 ---> 3, 70)
//        int cantidadArcos = 0;
//
//        for (int j = 0; j < numCiudad; j++) {
//            int valorDeLaPosicion = matriz[i][j];
//            if (valorDeLaPosicion > -1) {
//                cantidadArcos++;
//            }
//        }
//        return cantidadArcos;
//    }

//    public int gradoEntrante(int j) {
//        //(v,w) v ---> w  v=i w=j i=filas y j=columnas  0, 1, 2, 3  (0 ---> 3, 70)
//        int cantidadArcos = 0;
//
//        for (int i = 0; i < numCiudad; i++) {
//            int valorDeLaPosicion = matriz[i][j];
//            if (valorDeLaPosicion > -1) {
//                cantidadArcos++;
//            }
//        }
//        return cantidadArcos;
//    }

//    public ArrayList<Integer> vecinosDerechos(int i) {
//
//        ArrayList<Integer> adyacentes = new ArrayList<>();
//        for (int j = 0; j < numCiudad; j++) {
//
//            int valorDeLaPosicion = matriz[i][j];
//
//            if (valorDeLaPosicion > -1) {
//                adyacentes.add(j);
//            }
//        }
//        return adyacentes;
//    }

//    public ArrayList<Integer> vecinosIzquierdos(int j) {
//
//        ArrayList<Integer> incidentes = new ArrayList<>();
//
//        for (int i = 0; i < numCiudad; i++) {
//
//            int valorDeLaPosicion = matriz[i][j];
//
//            if (valorDeLaPosicion > -1) {
//                incidentes.add(i);
//            }
//        }
//        return incidentes;
//    }

//    public ArrayList<Integer> vecindadDerechaExtendida(int i) {
//
//        ArrayList<Integer> derechaExtendida = new ArrayList<>();
//        ArrayList<Integer> vecinosDeJ = new ArrayList<>();
//        for (int j = 0; j < numCiudad; j++) {
//
//            int valorDeLaPosicion = matriz[i][j];
//
//            if (valorDeLaPosicion > -1) {
//                derechaExtendida.add(j);
//                vecinosDeJ = vecinosDerechos(j);
//                if (vecinosDeJ != null) {
//                    for (int vecinoD : vecinosDeJ) {
//                        derechaExtendida.add(vecinoD);
//                    }
//                }
//
//            }
//        }
//        return derechaExtendida;
//    }
    
//     public ArrayList<Integer> vecindadIzquierdaaExtendida(int j) {
//
//        ArrayList<Integer> izquierdaExtendida = new ArrayList<>();
//        ArrayList<Integer> vecinosDei = new ArrayList<>();
//        for (int i = 0; i < numCiudad; i++) {
//
//            int valorDeLaPosicion = matriz[i][j];
//
//            if (valorDeLaPosicion > -1) {
//                izquierdaExtendida.add(i);
//                vecinosDei = vecinosIzquierdos(i);
//                if (vecinosDei != null) {
//                    for (int vecinoI : vecinosDei) {
//                        izquierdaExtendida.add(vecinoI);
//                    }
//                }
//
//            }
//        }
//        return izquierdaExtendida;
//    }

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
                System.out.print(" " + (matriz[i][j]) + " ");
            }
            System.out.println();
        }
    }
    
     public void dijkstra(int origen) {
        int[] D = new int[numCiudades]; // distancias mínimas
        boolean[] visitado = new boolean[numCiudades];
        ArrayList<Integer> T = new ArrayList<>();

        // Inicializamos las distancias
        for (int i = 0; i < numCiudades; i++) {
            D[i] = matrizDistancias[origen][i];
            if (i != origen) {
                T.add(i); // Agregamos todos menos el origen a T
            }
        }

        D[origen] = 0;
        visitado[origen] = true;

        while (!T.isEmpty()) {
            int v = indiceMinimo(D, T);
            T.remove(Integer.valueOf(v));
            visitado[v] = true;

            for (int z : T) {
                if (matrizDistancias[v][z] != Integer.MAX_VALUE && D[z] > D[v] + matrizDistancias[v][z]) {
                    D[z] = D[v] + matrizDistancias[v][z];
                }
            }
        }

        // Mostrar resultados
        System.out.println("Distancias mínimas desde ciudad " + origen + ":");
        for (int i = 0; i < numCiudades; i++) {
            System.out.println("→ Ciudad " + i + ": " + (D[i] == Integer.MAX_VALUE ? "∞" : D[i]));
        }
    }

     private int indiceMinimo(int[] D, ArrayList<Integer> T) {
        int minValor = Integer.MAX_VALUE;
        int minIndice = -1;
        for (int nodo : T) {
            if (D[nodo] < minValor) {
                minValor = D[nodo];
                minIndice = nodo;
            }
        }
        return minIndice;
    }
    

}
