import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Zombie{
 private String nombre;
 private int salud;
 private int fecha;
 private String sangre;
 

 public Zombie(String nombre, int salud, int fecha, String sangre){
    this.nombre = nombre;
    this.salud = salud;
    this.fecha = fecha;
    this.sangre = sangre;
    }
    
    public String toString() {
   return "Zombie: "+this.nombre + ": Salud: "+ this.salud + "," + "Año: "+this.fecha + ","
   + "fecha"+this.sangre;
}


 public String getSangre(){
    return this.sangre;
    }
    public int getFecha(){
    return this.fecha;
    }
     public int getSalud(){
    return this.salud;
    }
     public void setSalud(int salud){
      this.salud=salud;
    }
    
}