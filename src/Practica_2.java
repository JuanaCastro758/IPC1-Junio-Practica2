package src;
import java.util.*;

public class Practica_2{
    Scanner scanner=new Scanner(System.in);
    Random random=new Random();

    public static void main(String[] args){
        Practica_2 inicio=new Practica_2();
    }
    public Practica_2(){
        //datos de los clientes
        int[] id_c=new int[100];
        String[] nombre_c=new String[100];
        int[] telefono_c=new int[100];https://meet.google.com/qby-vsjk-tzy?authuser=0&hs=122
        boolean[] peliculaPrestada_c=new boolean[100];
        //datos de la pelicula
        int[] id_p=new int[100];
        String[] nombre_p=new String[100];
        int[] anio_p=new int[100];
        String[] categoria_p=new String[100];
        boolean[] disponible_p=new boolean[100];
        //datos de las peliculas prestadas
        int[][] peliculasPrestadas=new int[100][3];
        //llevar el control de los clientes nuevos
        int op_6=0;
        //levar el control de las peliculas nuevas
        int op_4=0;
        //Titulo del programa
        int op;
        do{
            //Titulo del programa
            System.out.println("\n\nMemorabilia\n");
            //llama al metodo que visualiza las opciones que tiene 
            //el programa
            menuOpciones();
            System.out.print("***La opcion Ingresada es: ");
            op=scanner.nextInt();
            //Evalua la opcion ingresada
            //para ejecutarlo
            if(op==1){
                mostrarPeliculasDisponible(id_p,nombre_p,anio_p,categoria_p,disponible_p);
                aceptarPeli(id_p,id_c,peliculaPrestada_c,peliculasPrestadas,disponible_p,op_6,op_4);
                
            }else if(op==2){
                devolucion(disponible_p,peliculaPrestada_c,peliculasPrestadas,op_6,op_4,nombre_p,nombre_c,id_p,id_c);
            }else if(op==3){
                mostrarPeliculas(id_p,nombre_p,anio_p,categoria_p,disponible_p);
            }else if(op==4){
                ingresoPelicula(id_p,nombre_p,anio_p,categoria_p,disponible_p,op_4);
                op_4++;
            }else if(op==5){
                ordenarPeliculas(id_p,nombre_p,anio_p,categoria_p,disponible_p,op_4);
            }else if(op==6){
                clientesNuevos(id_c,nombre_c,telefono_c,op_6,peliculaPrestada_c);
                op_6++;
            }else if(op==7){
                mostraClientes(id_c,nombre_c,telefono_c);
            }else if(op==8){
            }else{
                System.out.println("OPCION INVALIDA");
            }
        }while(op!=0);
    }
    
    public void menuOpciones(){
        //se muestra en pantalla las opciones disponibles
        System.out.println("1. Prestamos de peliculas");
        System.out.println("2. Devolucion de peliculas");
        System.out.println("3. Mostrar peliculas");
        System.out.println("4. Ingreso de peliculas");
        System.out.println("5. Ordenar las peliculas");
        System.out.println("6. Ingresar cliente nuevo");
        System.out.println("7. Mostrar clientes");
        System.out.println("8. Reportes");
        System.out.println("0. Cerrar");
    }
    
}