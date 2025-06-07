
package eda.segundotpparcial;


public class Camino {
    
    private Ciudad ciudad;
    private int distancia; // en km
    private int capacidad; // cantidad de carriles

    public Camino(Ciudad ciudad, int distancia, int capacidad) {
        this.ciudad = ciudad;
        this.distancia = distancia;
        this.capacidad = capacidad;
    }
    
    public Camino (int distancia){
    this.distancia= distancia;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return  "km=" + distancia  ;
    }

    
    
    
    
}
