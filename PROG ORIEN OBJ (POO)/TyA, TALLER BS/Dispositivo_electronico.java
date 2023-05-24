public abstract class Dispositivo_electronico {
    //Atributos de la clase
    protected String nombre;
    protected double precio;
    protected String garantia;

    //Constructor de la clase
    Dispositivo_electronico(String nombre, double precio, String garantia){
        this.garantia = garantia;
        this.nombre = nombre;
        this.precio = precio;
    }
    //Metodos de la clase

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getGarantia() {
        return garantia;
    }
    public void cargar(){
        System.out.println("No se especifica es general?!");
    }
    public void codigo(){
        System.out.println("No hay codigo");
    }
    public void color(){
        System.out.println("No hay color");
    }
}
