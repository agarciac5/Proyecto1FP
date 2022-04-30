import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

public class Principal{
    public static void main(String [] main){
   Principal principal = new Principal();
   principal.mostrarMenu();
}
Scanner scan = new Scanner(System.in);
ArrayList<Zombie> zombie;
ArrayList<Ubicacion> ubicacion;
int fecha;
String stringFecha;
int cantidadZ;
int numero;
public void mostrarMenu(){
       zombie  = new ArrayList<Zombie>();
       ubicacion  = new ArrayList<Ubicacion>();
       String nombre;
       int salud ;
       String stringFecha;
       int laBomba;
       String Fecha;
       String sangre;   
  while(true){
      System.out.println("Menu de opciones: ");
      System.out.println("(0): Para cerrar el menu. (1): Para crear un nuevo zombie. (2) Para mostrar los zombies creados "+
      "hasta el momento. (3) Para mostrar la cantidad de zombies existentes. (4) Para ver los zombies cuya sangre es O+ o AB+."+
      "(5) Para mostrar la informacion de los zombies que nacieron despues del 2000. (6) Para lanzar una bomba a los zombies. "
      +"(7) Para crear una Ubicacion. (8) Para mostrar las ubicaciones creadas hasta el momento. (9) Para mostrar la ubicacion "+
      "mas segura. (10) Para ordenar las ubicaciones de la mas cercana a la mas lejana de alexandria. (11) Para mostrar una frase "
      +"aleatoria sobre zombies. (12) Para calcular que zombies moriran en cierto año.");
      int numero = scan.nextInt();
    if(numero == 0){
        System.out.println("Fin del programa");
        break;
    }else if (numero == 1){
        System.out.println("Ingrese nombre del zombie");
        nombre = scan.next();
         System.out.println("Ingrese salud del zombie");
        salud = scan.nextInt();
         System.out.println("Ingrese fecha de nacimiento del zombie (DD/MM/AAAA)");
         stringFecha = scan.next();
        this.stringFecha = stringFecha;
         Fecha();
         laBomba = salud/2;
         System.out.println("Ingrese tipo de sangre del zombie");
        sangre = scan.next();
        Zombie zomb = new Zombie(nombre, salud, fecha, sangre);
        zombie.add(zomb);
     
        }else if(numero == 2){
            System.out.println("Estos son los datos de los zombies que existen actualmente: ");
        Listar();
        }else if(numero == 3){
            System.out.println("Los zombies acutales son: ");
        ListarNumero();
        }else if (numero == 4){
            System.out.println("Los siguientes son zombies cuya sangre es O+ o AB: ");
           ListSangre();
        }else if (numero == 5){
            System.out.println("Estos son los zombies que nacieron despues del 2000: ");
         compareFecha();
        }else if(numero == 6){
            System.out.println("--Se lanza una Bomba en: -- ");
            System.out.println("--3--");
                 System.out.println("--2--");
                      System.out.println("--1--");
                      System.out.println("*--La bomba estalla--*");
                      System.out.println("La vida de los zombies despues de estallar la bomba es:");
            DisSalud();
               }else if(numero == 7){
            System.out.println("Ingrese nombre de la ciudad: ");
            String nombreC = scan.next();
            System.out.println("Ingrese distancia de la ciudad de Alexandria: ");
            double distancia = scan.nextDouble();
             System.out.println("Ingrese cantidad de Zombies que hay en la ciudad: ");
             cantidadZ = scan.nextInt();
         Ubicacion ubic = new Ubicacion(nombreC, distancia, cantidadZ);
         ubicacion.add(ubic);
        }else if (numero == 8){
            System.out.println("Ubicaciones existentes en el momento: ");
        ListarC();
        }else if(numero == 9){
            System.out.println("La ciudad mas segura que se conoce acutalmente es: ");
           compareSeguridad();
           ListarSeguridad();
           
        }else if (numero== 10){
            System.out.println("Ubicaciones que estan mas cerca a Alexandria (la mas cercana a la mas lejana)");
            ubicacionOrdenar();
            System.out.println(ubicacion);
        }else if (numero == 11){
            System.out.println("Te cuento un frase o rumor sobre los zombies: ");
        generarFrase();
        }else if(numero == 12){
            System.out.println("Ingresa una fecha (AAAA), se calculara los zombies que moriran para esa fecha");
            System.out.println("Esto se hace basandose en una hipotesis de que cada año su vida se reduce aproximadamente en un 50%");
        finalZombies();
        }
    }
    
    }
    
    
    
    
    public void Listar(){
     for(int i=0; i < zombie.size(); i++){
        System.out.println("["+i+"]: " + zombie.get(i));
        }
    }
    public void ListarNumero(){
    
        System.out.println(zombie.size());
        
    }
    public void ListSangre(){
     for(int i=0; i < zombie.size(); i++){
          String SangreT=zombie.get(i).getSangre();
        if(SangreT.equals("O+") || SangreT.equals("AB+")){
            System.out.println("["+i+"]: " + zombie.get(i));
            }else{
            }
        }
    }
   public void DisSalud(){
      for(int i=0;i < zombie.size();i++){
        int salud=zombie.get(i).getSalud();
        int dis= salud/2;
        zombie.get(i).setSalud(dis);
      }
       Listar();
    }
      public void finSalud(){
      for(int i=0;i < zombie.size();i++){
        int salud=zombie.get(i).getSalud();
        int dis= salud/2;
        zombie.get(i).setSalud(dis);
      }
      System.out.println(".");
    }
    public void ListarC(){
     for(int i=0; i < ubicacion.size(); i++){
        System.out.println("["+i+"]: " + ubicacion.get(i));
        }
    }
    public String generarFrase(){
        String frase = Frases[(int)(Math.random()*5)];
     return frase;
    }
    public String Frases[]= {
         "Estas rodeado de zombies, esas son las malasnoticias.", 
    "Cuando los muertos echan a andar, ¿para qué obstinarse en matarlos? "+
    "No hay formas de vencerlos.",
    "Cada ser humano que salvamos es un zombi menos que combatir.",
    "Los zombis nos invaden y nosotros nos encerramos en una biblioteca.",
    "Viven para la noche, viven para matar, y ... viven siempre."
};
  
    public void Fecha(){
        String stringAño = stringFecha.substring(6,10);
        int fecha = Integer.parseInt(stringAño);
        this.fecha = fecha;
    }
   public void compareFecha(){
    for(int i=0; i < zombie.size(); i++){
          int fecha2k =zombie.get(i).getFecha();
        if(fecha2k > 2000){
            System.out.println("["+i+"]: " + zombie.get(i));
            }else{
            }
        }
    }
  public void ubicacionOrdenar(){
     
     ubicacion.sort(new Comparator<Ubicacion>()
        {
           public int compare(Ubicacion o1, Ubicacion o2){
              return o1.compareTo(o2);
           }
        }
    );
    }
             int seguridadZombie = 0;
    public void compareSeguridad(){
       int  o=0;
        int seguridad1 =ubicacion.get(o).getCantidadZ();
           int seguridad2 =ubicacion.get(o+1).getCantidadZ();

        if(seguridad1 < seguridad2){
             seguridadZombie = seguridad1;
            }else if(seguridad2 < seguridad1){
                 seguridadZombie = seguridad2;
            }else{
            }
            
    
    }
    public void ListarSeguridad(){
       for(int i=0; i < ubicacion.size()-1; i++){
          int seguridad3 =ubicacion.get(i).getCantidadZ();
           int seguridad4 =ubicacion.get(i+1).getCantidadZ();
        if(seguridad3 < seguridadZombie){         
        if(seguridad3 < seguridad4){
            seguridadZombie = seguridad3;
            }else{
                 seguridadZombie = seguridad4;
            }
        }else if(seguridad4 < seguridadZombie){
        seguridadZombie= seguridad4;
        }else{
        }
        }
        for(int i=0; i < ubicacion.size(); i++){
          int seguridad5 =ubicacion.get(i).getCantidadZ();     
        if(seguridadZombie == seguridad5){
            System.out.println("["+i+"]: " + ubicacion.get(i));
            }else{
            }
        
      }

    }
    public void finalZombies(){
        System.out.println("1");
    int añoMuerte = scan.nextInt();
    int fecha2k=0;
    if(añoMuerte < 2023){
      añoMuerte = 2022;
    }
     for(int i=0; i < zombie.size(); i++){
           fecha2k =zombie.get(i).getFecha();
        int fin = añoMuerte-fecha2k;
      for(int j=0; j < fin; j++){
           fecha2k =zombie.get(i).getFecha();
          
        if(fecha2k < añoMuerte){
            finSalud();
            
            }else{
           
            }
        }
    }
     for(int i=0; i < zombie.size(); i++){
          int saludZ=zombie.get(i).getSalud();
        if(saludZ <= 1){
            zombie.remove(i);
            }
        }
        Listar();
        
    }
    
}
