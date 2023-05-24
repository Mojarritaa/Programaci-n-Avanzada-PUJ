//Este código fue sacado de BroCode https://www.youtube.com/@BroCodez//
//Importar librerías necesarias
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
//Tamaño de la ventana
 static final int SCREEN_WIDTH = 600;
 static final int SCREEN_HEIGHT = 600;
 //Tamaño de las unidades
 static final int UNIT_SIZE = 25;
 static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
 //Velocidad del juego
 static final int DELAY = 75;
 //Arreglos para las coordenadas de la serpiente
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    //Crear las partes de la serpiente
    int bodyParts = 4;
    //Variables para ver cuantos puntos  ha comido
    int pointEaten;
    //Coordenadas del punto
    int pointX;
    int pointY;
    //Direccion inicial de la serpiente
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
 //Constructor, cada vez que se inicializa un GamePanel, iniciará el juego
   GamePanel(){
       random = new Random();
       this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
       this.setBackground(Color.black);
       this.setFocusable(true);
       this.addKeyListener(new MyKeyAdapter());
       startGame();
   }
 //Funcion que se encarga del inicio del juego, iniciliazar los atributos/parametros
   public void startGame(){
       newPoint();
       running = true;
       timer = new Timer(DELAY, this);
       timer.start();
   }
 //Funcion que se encarga de imprimir en el panel a través del método draw
   public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
   }
 //Funcion que se encarga de "imprimir" los contenidos en el panel, los dibuja
   public void draw(Graphics g) {
    //Verificar que el juego siga corriendo, es decir, que el jugador no ha perdido
       if (running) {
        //Imprimir rejillas para el movimiento, no son necesarias opcionales
           for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
               g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_WIDTH);
               g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
           }
        //El color del punto/manzana
           g.setColor(Color.cyan);
           g.fillOval(pointX, pointY, UNIT_SIZE, UNIT_SIZE);
        //Imprimir la serpiente, tanto la cabeza [0] y el resto del cuerpo
           for (int i = 0; i < bodyParts; i++) {
               if (i == 0) {
                   g.setColor(Color.GREEN);
                   g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
               } else {
                   g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                   g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
               }
           }
        //Mostrar en pantalla el marcador del jugador, su puntaje
           g.setColor(new Color(98,37,89));
           g.setFont(new Font("SansSerif", Font.BOLD, 30));
           FontMetrics metrics = getFontMetrics(g.getFont());
           g.drawString("Puntos: " + pointEaten, (SCREEN_WIDTH - metrics.stringWidth("Puntos: " + pointEaten))/2, g.getFont().getSize());
       }
       else{
        //Si pierde, muestra en pantalla gameover, utiliza el metodo gameOver
           gameOver(g);
       }
   }
 //Funcion que crea nuevas coordenadas para la manzana/punto
   public void newPoint(){
    //Crear nuevas posiciones de la manzana/punto utilizando random
        pointX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        pointY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
   }
 //Función que se encarga del movimiento de la serpiente
   public void move(){
    //Hace el intercambio
        for(int i = bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
    //Hace el cambio de la dirección
        switch (direction){
            case 'U' ->{
                y[0] = y[0] - UNIT_SIZE;
            }
            case 'D' ->{
                y[0] = y[0] + UNIT_SIZE;
            }
            case 'R' ->{
                x[0] = x[0] + UNIT_SIZE;
            }
            case 'L' ->{
                x[0] = x[0] - UNIT_SIZE;
            }
        }
   }
 //verificar que la serpiente se haya comido la manzana/punto
   public void checkPoint(){
       if((x[0] == pointX) && (y[0]==pointY)){
        //Agrandar la serpiente y aumentar el contador
           bodyParts++;
           pointEaten++;
        //Crear una nueva manzana
           newPoint();
       }
   }
   public void checkCollisions(){
       //Revisar si se chocó con alguna parte de su cuerpo
       for(int i = bodyParts; i>0; i--){
           if((x[0]==x[i]) && (y[0] == y[i])){
              running = false;
           }
       }
       //Revisar si la serpiente se chocó con uno de los bordes
       //Borde izquierdo
       if(x[0] < 0){
           running = false;
       }
       //Borde derecho
       if(x[0] > SCREEN_WIDTH){
           running = false;
       }
        //Borde superior
       if(y[0] < 0){
           running = false;
       }
       //Borde inferior
       if(y[0] > SCREEN_HEIGHT){
           running = false;
       }
    //Si el jugador pierde, se para el timer
       if(!running){
           timer.stop();
       }
   }
 //Funcion que se encarga de mostrar en pantalla el mensaje de Game over, si pierde el jugador
   public  void gameOver(Graphics g){
       //Mostrar el puntaje
       g.setColor(new Color(98,37,89));
       g.setFont(new Font("SansSerif", Font.BOLD, 30));
       FontMetrics metrics1 = getFontMetrics(g.getFont());
    //Esto muestra el mensaje en la mitad del panel
       g.drawString("Puntos: " + pointEaten, (SCREEN_WIDTH - metrics1.stringWidth("Puntos: " + pointEaten))/2, g.getFont().getSize());
        //Mostrar que se acabo el juego
       g.setColor(Color.red);
       g.setFont(new Font("SansSerif", Font.BOLD, 75));
       FontMetrics metrics2 = getFontMetrics(g.getFont());
      g.drawString("GAME OVER!!!!!!", (SCREEN_WIDTH - metrics2.stringWidth("GAME OVER!!!!!!"))/2, SCREEN_HEIGHT/2);

   }
//Funcion que se encarga de la acción, maneja el juego
    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkPoint();
            checkCollisions();
        }
        repaint();
    }
 //Recibe las teclas oprimidas por el jugador para poder mover la serpiente
    public class MyKeyAdapter extends KeyAdapter{
       @Override
        public void keyPressed(KeyEvent e){
           switch (e.getKeyCode()){
             //Verificar que los movimientos se hagan correctamente y eviten chocarse al hacerlo, evitar un bug. 
               case KeyEvent.VK_LEFT -> {
                   if(direction != 'R'){
                       direction = 'L';
                   }
               }
               case KeyEvent.VK_RIGHT -> {
                   if(direction != 'L'){
                       direction = 'R';
                   }
               }
               case KeyEvent.VK_UP -> {
                   if(direction != 'D'){
                       direction = 'U';
                   }
               }
               case KeyEvent.VK_DOWN -> {
                   if(direction != 'U'){
                       direction = 'D';
                   }
               }
           }
       }
    }
}
