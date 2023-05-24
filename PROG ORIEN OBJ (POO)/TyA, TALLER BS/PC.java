public class PC extends Dispositivo_electronico{
    //Atributos
    protected String forma;
    protected int codigo;

    //Constructor
    PC(String nombre, String garantia,double precio, String forma, int codigo) {
        super(nombre, precio, garantia);
        this.codigo = codigo;
        this.forma = forma;
    }
    //Metodos

    public String getForma() {
        return forma;
    }

    public int getCodigo() {
        return codigo;
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
    public void color() {
        System.out.println("NO TENGO COLOR PERO SI FORMA, Y ES: " + this.forma + ":DD");
    }

    @Override
    public void codigo() {
        System.out.println("Mi codigo no te lo voy a dar fácil, te daré mi codigo por dos");
        int i = this.codigo*2;
        System.out.println("Es: " + i);
    }

    @Override
    public void cargar() {
        System.out.println("No tendré color ni nada, pero soy rapido: 12s de carga >:D");
    }
}
