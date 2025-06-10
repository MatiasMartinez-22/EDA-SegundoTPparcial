
package eda.segundotpparcial;


public class Camino {
    
   private int distancia;
    private int carriles;

    public Camino() {
        this.distancia = 1000;
        this.carriles =0;
    }

    
    
    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getCarriles() {
        return carriles;
    }

    public void setCarriles(int carriles) {
        this.carriles = carriles;
    }

    @Override
    public String toString() {
        return  distancia + " km" ;
    }

    
    
    
    
}
