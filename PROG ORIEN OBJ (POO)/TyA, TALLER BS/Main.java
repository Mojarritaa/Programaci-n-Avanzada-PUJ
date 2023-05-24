
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //Crear variable auxiliar
        Scanner scanner = new Scanner(System.in);
        //Realización del taller
        //Crear la lista de dispositvos electronicos
        ArrayList<Dispositivo_electronico> lista_dispositivos = new ArrayList<>();
        //Agregar un dispositovo electronico para mostrar el poliformismo
        System.out.println("Bienvenido al servicio de manejo de dispositivos electronicos" + "\n");
        System.out.println("1. Imprimir los dispositivos");
        System.out.println("2. Agregar un PC");
        System.out.println("3. Agregar un Celular");
        System.out.println("4. Salir");
        System.out.print("Elige una opcion: ");
        int opc = scanner.nextInt();
        while(opc != -1) {
            switch (opc) {
                case 0 -> {
                    System.out.println("Bienvenido al servicio de manejo de dispositivos electronicos" + "\n");
                    System.out.println("1. Imprimir los dispositivos");
                    System.out.println("2. Agregar un PC");
                    System.out.println("3. Agregar un Celular");
                    System.out.println("4. Salir");
                    System.out.print("Elige una opcion: ");
                    opc = scanner.nextInt();
                }
                case 1 -> {
                    System.out.println("Lista de los dispositivos agregados: ");
                    for (Dispositivo_electronico dispostivo : lista_dispositivos) {
                        if (lista_dispositivos.size() != 0) {
                            System.out.println("Nombre: " + dispostivo.nombre + "\nPrecio: " + dispostivo.precio + "\nGarantia: " + dispostivo.garantia);
                            System.out.println("Ahora sus metodos: ");
                            dispostivo.color();
                            System.out.println("");
                            dispostivo.codigo();
                            System.out.println("");
                            dispostivo.cargar();
                            System.out.println("");
                        }
                        else{
                            System.out.println("No se ha agregado nada a la lista");
                        }
                    }
                    opc = 0;
                }
                case 2 -> {
                    System.out.println("Para agregar el PC, ingrese los siguientes datos");
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del PC: ");
                    String nombre_pc = scanner.nextLine();
                    System.out.print("Ingrese la garantia del PC: ");
                    String garantia_pc = scanner.nextLine();
                    System.out.print("Ingrese el precio del PC: ");
                    double precio_pc = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese la forma del PC: ");
                    String forma_pc = scanner.nextLine();
                    System.out.print("Ingrese el codigo del PC: ");
                    int codigo_pc = scanner.nextInt();
                    lista_dispositivos.add(new PC(nombre_pc,garantia_pc,precio_pc,forma_pc,codigo_pc));
                    System.out.print("Se ha agregado correctamente el PC");
                    opc = 0;
                }
                case 3 ->{
                    System.out.println("Para agregar el Celular, ingrese los siguientes datos");
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del Celular: ");
                    String nombre_cel = scanner.nextLine();
                    System.out.print("Ingrese la garantia del Celular: ");
                    String garantia_cel = scanner.nextLine();
                    System.out.print("Ingrese el precio del Celular: ");
                    double precio_cel = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese el color del Celular: ");
                    String color_cel = scanner.nextLine();
                    System.out.print("Ingrese el codigo del Celular: ");
                    int codigo_cel = scanner.nextInt();
                    lista_dispositivos.add(new Celular(nombre_cel,garantia_cel,precio_cel,color_cel,codigo_cel));
                    System.out.println("Se ha agregado correctamente el Celular");
                    opc = 0;
                }
                case 4 ->{
                    System.exit(0);
                }
                default ->{
                    System.out.println("Ingrese una opcion valida");
                    opc = 0;
                }
            }
        }
    }
}