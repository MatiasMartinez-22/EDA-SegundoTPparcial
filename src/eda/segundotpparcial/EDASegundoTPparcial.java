
package eda.segundotpparcial;

import java.util.ArrayList;


public class EDASegundoTPparcial {

    
    public static void main(String[] args) {
        
        
         GrafoEtiquetado grafoEtiquetado = new GrafoEtiquetado(5, 4, false);
        //0, 1, 2, 3
        //La arista (v,w) donde v y w son vertices y v ---> w (es dirigido)  v=i w=j i=filas  j=columnas 

        Ciudad cityBuenosAires =new Ciudad("BuenosAires");
        Ciudad citySanMartin =new Ciudad("SanMartin");
        Ciudad cityVm =new Ciudad("Vm");
        Ciudad citySl =new Ciudad("Sl");
        
//        ArrayList <Ciudad> saberCiudad=new ArrayList <Ciudad> ();
//        
//        saberCiudad.add(cityBuenosAires);
//        saberCiudad.add(cityBuenosAires);
//        saberCiudad.add(cityBuenosAires);
//        saberCiudad.add(cityBuenosAires);
        
        
        Camino camino= new Camino(cityBuenosAires, 10, 2);
        Camino camino2= new Camino(citySanMartin, 20, 2);
        Camino camino3= new Camino(cityVm, 30, 2);
        Camino camino4= new Camino(citySl, 40, 2);
        
        
        grafoEtiquetado.agregarArco(0, 1, camino);
        grafoEtiquetado.agregarArco(0, 3, camino2);
        grafoEtiquetado.agregarArco(3, 1, camino3);
        grafoEtiquetado.agregarArco(3, 2, camino4);
        
        grafoEtiquetado.mostrarMatriz();

        grafoEtiquetado.dijkstra(3); // Desde ciudad 0 (A)
        
         
         
    }
    
}
