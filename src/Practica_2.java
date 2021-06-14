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
        int[] telefono_c=new int[100];
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
            System.out.println("\n\nRenta de Peliculas\n");
            //llama al metodo que visualiza las opciones que tiene 
            //el programa
            menuOpciones();
            System.out.print("***La opcion Ingresada es: ");
            op=scanner.nextInt();
            //Evalua la opcion ingresada
            //para ejecutarlo
            switch(op){
                case 1: mostrarPeliculasDisponible(id_p,nombre_p,anio_p,categoria_p,disponible_p);
                        aceptarPeli(id_p,id_c,peliculaPrestada_c,peliculasPrestadas,disponible_p,op_6,op_4);
                    break;
                case 2: devolucion(disponible_p,peliculaPrestada_c,peliculasPrestadas,op_6,op_4,nombre_p,nombre_c,id_p,id_c);
                    break;
                case 3: mostrarPeliculas(id_p,nombre_p,anio_p,categoria_p,disponible_p);
                    break;
                case 4: ingresoPelicula(id_p,nombre_p,anio_p,categoria_p,disponible_p,op_4);
                        op_4++;
                    break;
                case 5: ordenarPeliculas(id_p,nombre_p,anio_p,categoria_p,disponible_p,op_4);
                    break;
                case 6: clientesNuevos(id_c,nombre_c,telefono_c,op_6,peliculaPrestada_c);
                        op_6++;
                    break;
                case 7: mostraClientes(id_c,nombre_c,telefono_c);
                    break;
                case 8:
                    break;
                default: System.out.println("OPCION INVALIDA");
                    break;
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

    //metodos que registran a los nuevos clientes del negocio
    public void clientesNuevos(int[] id,String[] nombre,int[] telefono,int nClientes,boolean[] peliculaPrestada){
        crearID(id,100,999,nClientes);
        //pide el nombre
        System.out.print("\n\nNombre del Nuevo Cliente: ");
        nombre[nClientes]=scanner.next();
        peliculaPrestada[nClientes]=false;
        //metodo para registrar telefono nuevo
        registrarTelefono(telefono,nClientes);
        
        System.out.println("\n Informacion del nuevo cliente \n");
        System.out.println("Codigo (id): "+ id[nClientes]);
        System.out.println("Nombre: "+nombre[nClientes]);
        System.out.println("Telefono: "+telefono[nClientes]);
    }
    public void registrarTelefono(int[] telefono,int nClientes){
        boolean tel_Regis=false;
        do{
            System.out.print("Telefono del Nuevo Cliente: ");
            telefono[nClientes]=scanner.nextInt();
            if(telefono[nClientes]<100000000 &&telefono[nClientes]>9999999){
                if(nClientes==0){
                    tel_Regis=true;
                }else{
                    for(int i=0;i<nClientes;i++){
                        if(telefono[nClientes]==telefono[i]){
                            tel_Regis=false;
                            System.out.println("...El telefono ya existe ");
                            i=nClientes;
                        }else{
                            tel_Regis=true;
                        }
                    }
                }
            }else{
                System.out.println("La cantidad de digitos es invalido");
                tel_Regis=false;
            }
        }while(tel_Regis!=true);
    }
}