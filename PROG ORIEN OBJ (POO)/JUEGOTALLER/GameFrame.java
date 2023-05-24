import javax.swing.JFrame;
public class GameFrame extends JFrame{
    //Constructor
    GameFrame(){
        //Instanciar el panel
        GamePanel panel = new GamePanel();
        //Agregarlo al game frame
        this.add(panel);
        //Definir el titulo
        this.setTitle("Snake Game");
        //Definir la salida
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //nos ayuda a meter los componentes al frame
        this.pack();
        //Poder verlo en pantalla
        this.setVisible(true);
        //Verlo en el centro del computador
        this.setLocationRelativeTo(null);
    }
}
