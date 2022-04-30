
public class Ubicacion implements Comparable<Ubicacion>{
private String nombreC;
 private double distancia;
 private int cantidadZ;
 
 public Ubicacion(String nombreC, double distancia, int cantidadZ){
     
  
    this.nombreC = nombreC;
    this.distancia = distancia;
    this.cantidadZ = cantidadZ;
}
    
    public String toString() {
   return this.nombreC + ": "+ this.distancia + "," + this.cantidadZ;
}
 public String getNombreC(){
    return this.nombreC;
    }
    public double getDistancia(){
     return this.distancia;
    }
     public int getCantidadZ(){
     return this.cantidadZ;
    }
    @Override
    public int  compareTo(Ubicacion u){
     
        if(u.getDistancia()>distancia){
        return -1;
    }else if(u.getDistancia()>distancia){
    return 0;
    }else{
    return 1;
    }
    }
 
}
