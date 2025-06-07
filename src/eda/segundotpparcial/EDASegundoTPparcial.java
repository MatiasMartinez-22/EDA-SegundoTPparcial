
package eda.segundotpparcial;

import java.util.ArrayList;


public class EDASegundoTPparcial {

    
    public static void main(String[] args) {
        
        
         GrafoEtiquetado grafoEtiquetado = new GrafoEtiquetado(5, 4, false);
        //0, 1, 2, 3
        //La arista (v,w) donde v y w son vertices y v ---> w (es dirigido)  v=i w=j i=filas  j=columnas 

        Ciudad moreno =new Ciudad("Moreno");
        Ciudad moron =new Ciudad("Moron");
        Ciudad beraz =new Ciudad("Berazategui");
        Ciudad merlo =new Ciudad("Merlo");
        
//        ArrayList <Ciudad> saberCiudad=new ArrayList <Ciudad> ();
//        
//        saberCiudad.add(cityBuenosAires);
//        saberCiudad.add(cityBuenosAires);
//        saberCiudad.add(cityBuenosAires);
//        saberCiudad.add(cityBuenosAires);
        
        
        Camino camino= new Camino(12);
        Camino camino2= new Camino(20);
        Camino camino3= new Camino(70);
        Camino camino4= new Camino(35);
        
        
//        Camino camino2= new Camino(moron, 20, 2);
//        Camino camino3= new Camino(beraz, 30, 2);
//        Camino camino4= new Camino (merlo, 40, 2);
        
        
        grafoEtiquetado.agregarArco(0, 1, camino);
        grafoEtiquetado.agregarArco(0, 3, camino2);
        grafoEtiquetado.agregarArco(1, 2, camino3);
        grafoEtiquetado.agregarArco(3, 2, camino4);
        
        grafoEtiquetado.mostrarMatriz();

        grafoEtiquetado.dijkstra2(2); // Desde ciudad 0 (A)
        
//         grafoEtiquetado.dijkstra(2);
         
    }
    
}
