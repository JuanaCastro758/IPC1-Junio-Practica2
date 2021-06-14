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
    public void crearID(int[] id,int ini,int f, int num){
        //crea automaticamente el ID de cada cliente
        if(num==0){
            id[0]=random.nextInt(f-ini+1)+ini;
        }else{
            for(int i=0;i<num;i++){
                int x=random.nextInt(f-ini+1)+ini;
                if(x!=id[i]){
                    id[num]=x;
                }
            }
        }
    }
    //metodo que muestra los clientes inscritos en el negocio
    //metodo registra a los clientes nuevos
   public void mostraClientes(int[] id,String[] nombre,int[] telefono){
        System.out.println("\n\nClientes Registrados");
        System.out.println("\nID               Nombre               telefono");
        for(int i=0;i<id.length;i++){
            if(nombre[i]==null){
            }else{
                System.out.println(id[i]+"               "+nombre[i]+"               "+telefono[i]);
            }
        }
    }
    //registrar una pelicula nueva
    public void ingresoPelicula(int[] id,String[] nombre,int[] anio,String[] categoria,boolean[] disponible,int nClientes){
        crearID(id,1000,9999,nClientes);
        System.out.println("\n\nRegistro de peliculas");
        System.out.print("\nnonmbre de la pelicula: ");
        nombre[nClientes]=scanner.next();
        //verifica si el año es valido
        do{
            System.out.print("Año de estreno: ");
            anio[nClientes]=scanner.nextInt();
            if(anio[nClientes]<1888){
                System.out.println("----¡Año no valido! ");
            }
        }while(anio[nClientes]<1888);
        System.out.print("Categoria: ");
        categoria[nClientes]=scanner.next();
        disponible[nClientes]=true;
    }
    private void mostrarPeliculas(int[] id,String[] nombre,int[] anio,String[] categoria,boolean[] disponible) {
        System.out.println("\n\nPeliculas Registrados");
        System.out.println("\nID      Nombre                 Año         Categoria         Disponible");
        String x;
        for(int i=0;i<id.length;i++){
            if(nombre[i]!=null){
                if(disponible[i]==true){
                    x="si";
                }else{
                    x="no";
                }
                System.out.println(id[i]+"    "+nombre[i]+"              "+anio[i]+"         "+categoria[i]+"              "+x);
            }else{
                
            }
        }
    }
    //metodo burbuja que intercambia valores
    private void ordenarPeliculas(int[] id,String[] nombre,int[] anio,String[] categoria,boolean[] disponible,int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
            	//evalua el valor de la variable si es mayor a cero realiza el cambio
                if (nombre[j].compareToIgnoreCase(nombre[j+1])>0){
                    
                    int tmp1 = id[j];
                    id[j] = id[j+1];
                    id[j+1] = tmp1;

                    String tmp2 = nombre[j];
                    nombre[j] = nombre[j+1];
                    nombre[j+1] = tmp2;

                    int tmp3 = anio[j];
                    anio[j] = anio[j+1];
                    anio[j+1] = tmp3;

                    String tmp4 = categoria[j];
                    categoria[j] = categoria[j+1];
                    categoria[j+1] = tmp4;

                    boolean tmp5 = disponible[j];
                    disponible[j] = disponible[j+1];
                    disponible[j+1] = tmp5;
                }

            }
        }
        System.out.println("\n¡Peliculas Ordenadas Exitosamente!");
        
        
    }
    
    
    

}