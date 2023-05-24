import java.security.ProtectionDomain;
import java.sql.SQLOutput;

public class Celular extends Dispositivo_electronico{
    //Atributos de la clase
    protected String color;
    protected int codigo;

    //Constructor de la clase
    Celular(String nombre, String garantia,double precio, String color, int codigo){
        super(nombre, precio, garantia);
        this.codigo = codigo;
        this.color = color;
    }
    //metodos de la clase

    public int getCodigo() {
        return codigo;
    }

    public String getColor() {
        return color;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String getGarantia() {
        return garantia;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    //Sobreescritura de metodos
    @Override
    public void cargar() {
        System.out.println("El tiempo de carga de 1 minuto y 30s :( soy lento tenme paciencia");
    }

    @Override
    public void codigo() {
        System.out.println("Mi codigo es: " + this.codigo + " Soy un celular :DD USAMEEE AAA" + "\n PD: SOY MEJOR QUE UN PC");
    }

    @Override
    public void color() {
        System.out.println("Mi color como celular es: " + this.color + " Aunque no se para que se usa.");
    }

}
